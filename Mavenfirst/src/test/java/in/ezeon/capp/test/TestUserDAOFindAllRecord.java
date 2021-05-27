package in.ezeon.capp.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ezeon.capp.config.SpringRootConfig;
import in.ezeon.capp.dao.UserDAO;
import in.ezeon.capp.domain.User;

public class TestUserDAOFindAllRecord {

	public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO=ctx.getBean(UserDAO.class);
        
        
        List<User> users=userDAO.findAll();
        for(User u:users)
        {
        	System.out.println(u.getUserId()+" "+u.getAddress());
        }
	
}
}
