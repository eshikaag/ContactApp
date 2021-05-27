package in.ezeon.capp.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import in.ezeon.capp.command.LoginCommand;
import in.ezeon.capp.command.UserCommand;
import in.ezeon.capp.domain.User;
import in.ezeon.capp.exception.UserBlockedException;
import in.ezeon.capp.service.UserService;

@Controller
public class UserController {
	 @Autowired
	    private UserService userService;

	    @RequestMapping(value = {"/", "/ind"})
	    public String index(Model m) {
	        m.addAttribute("command", new LoginCommand());
	        return "ind"; //JSP - /WEB-INF/view/index.jsp
	    }
	    @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m,HttpSession session) {
	    	
	    	
	        try {
	            User loggedInUser = userService.login(cmd.getLoginName(), cmd.getPassword());
	            if (loggedInUser == null) {
	                //FAILED
	                //add error message and go back to login-form
	                m.addAttribute("err", "Login Failed! Enter valid credentials.");
	                return "ind";//JSP - Login FORM
	            } else //SUCCESS
	            //check the role and redirect to a appropriate dashboard 
	            {
	                if (loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
	                    //add user detail in session (assign session to logged in user)
	                    addUserInSession(loggedInUser, session);
	                    return "redirect:admin/dashboard";
	                } else if (loggedInUser.getRole().equals(UserService.ROLE_USER)) {
	                    //add user detail in session (assign session to logged in user)
	                    addUserInSession(loggedInUser, session);
	                    return "redirect:user/dashboard";
	                } else {
	                    //add error message and go back to login-form
	                    m.addAttribute("err", "Invalid User ROLE");
	                    return "ind";//JSP - Login FORM
	                }
	            }
	        } catch (UserBlockedException ex) {
	            //add error message and go back to login-form
	            m.addAttribute("err", ex.getMessage());
	            return "ind";//JSP - Login FORM
	        }
	    }



@RequestMapping(value = "/user/dashboard")
public String userDashboard() {
    return "dashboard_user"; //JSP
}
@RequestMapping(value = "/admin/dashboard")
public String adminDashboard() {
    return "dashboard_admin"; //JSP
}
private void addUserInSession(User u, HttpSession session) {
	//will tell which user is currently logged in
    session.setAttribute("user", u);
    session.setAttribute("userId", u.getUserId());
    session.setAttribute("role", u.getRole());
}

@RequestMapping(value = "/logout")
public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:ind?act=lo";
}
@RequestMapping(value = "/reg_form")
public String registrationForm(Model m) {
    UserCommand cmd = new UserCommand();
   m.addAttribute("command", cmd);//.cmd binded with mpodel which is accessibl;e frpom jsp pg
    return "reg_form";//JSP
}
@RequestMapping(value = "/register")
public String registerUser(@ModelAttribute("command") UserCommand cmd, Model m) {
    try{
        User user = cmd.getUser();
        user.setRole(UserService.ROLE_USER);
        user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
        userService.register(user);
        return "redirect:ind?act=reg"; //Login Page
    }

catch (DuplicateKeyException e) {
    e.printStackTrace();
    m.addAttribute("err", "Username is already registered. Please select another username.");
    return "reg_form";//JSP
}
}


@RequestMapping(value = "/admin/users")
public String getUserList(Model m) {
    m.addAttribute("userList", userService.getUserList());
    return "users"; //JSP
}
}
