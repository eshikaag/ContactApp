package in.ezeon.capp.test;

import javax.sql.DataSource;

//import org.apache.tomcat.jni.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import in.ezeon.capp.config.SpringRootConfig;
import in.ezeon.capp.dao.UserDAO;
import in.ezeon.capp.domain.User;
public class TestUserDAOSave {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO=ctx.getBean(UserDAO.class);
        //TODO: the user details will be taken from User-Reg-Form
        User u=new User();
        u.setName("eSHIKA");
        u.setPhone("9888888888");
        u.setEmail("eshi.agra@gmaol.com");
        u.setAddress("14nilkhil");
        u.setLoginName("eSHIKaaAchk");
        u.setPassword("123");
        u.setRole(1);//Admin Role 
        u.setLoginStatus(1); //Active
        userDAO.save(u);
        System.out.println("data saved..............");
        
	}
}
