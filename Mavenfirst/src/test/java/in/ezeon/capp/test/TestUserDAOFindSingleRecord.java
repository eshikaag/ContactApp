package in.ezeon.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ezeon.capp.config.SpringRootConfig;
import in.ezeon.capp.dao.UserDAO;
import in.ezeon.capp.domain.User;

public class TestUserDAOFindSingleRecord {

	public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO=ctx.getBean(UserDAO.class);
        User u=userDAO.findById(1);
        System.out.println("--------User details------");
        System.out.println(u.getUserId());
        System.out.println(u.getName());
        System.out.println(u.getPhone());
        System.out.println(u.getEmail());
        System.out.println(u.getAddress());
        System.out.println(u.getLoginName());
        System.out.println(u.getLoginStatus());
}
}
