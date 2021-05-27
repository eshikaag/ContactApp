//package in.ezeon.capp.test;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import in.ezeon.capp.config.SpringRootConfig;
//import in.ezeon.capp.dao.UserDAO;
//import in.ezeon.capp.domain.User;
//import in.ezeon.capp.service.UserService;
//
//public class TestUserServiceRegister {
//	public static void main(String[] args) {
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
//        UserService userService=ctx.getBean(UserService.class);
//        //TODO: the user details will be taken from Update User Profile Page
//        User u=new User();
//        u.setUserId(2);//wiwill autoincrement no need to set
//        u.setName("eshika Sinha");
//        u.setPhone("930358550884");
//        u.setEmail("amit.sibnha@ezeon.net");
//        u.setAddress("Mumfbai, MS");
//        u.setLoginName("eshuuu");
//        u.setPassword("123");
//        u.setRole(userService.ROLE_ADMIN);//Admin Role 
//        u.setLoginStatus(userService.LOGIN_STATUS_ACTIVE); //Active
//        
//        userService.register(u);
//        System.out.println("--------Reg-----");
//    }    
//}







package in.ezeon.capp.test;

import in.ezeon.capp.config.SpringRootConfig;
import in.ezeon.capp.dao.UserDAO;
import in.ezeon.capp.domain.User;
import in.ezeon.capp.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestUserServiceRegister {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserService userService=ctx.getBean(UserService.class);
        //TODO: the user details will be taken from User-Reg-Form
        User u=new User();
        u.setName("Nitinnn");
        u.setPhone("55555555");
        u.setEmail("nitin@ezeon.net");
        u.setAddress("Mumbai");
        u.setLoginName("nitinnn");
        u.setPassword("nitin123");
        u.setRole(UserService.ROLE_ADMIN);
        u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
        userService.register(u);
        System.out.println("--------User Registered Successfully------");
    }    
}

