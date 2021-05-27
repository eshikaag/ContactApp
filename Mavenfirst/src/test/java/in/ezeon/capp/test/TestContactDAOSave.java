package in.ezeon.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ezeon.capp.config.SpringRootConfig;
import in.ezeon.capp.dao.ContactDAO;
import in.ezeon.capp.dao.UserDAO;
import in.ezeon.capp.domain.Contact;
import in.ezeon.capp.domain.User;

public class TestContactDAOSave {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        ContactDAO contactDAO=ctx.getBean(ContactDAO.class);
        //TODO: the user details will be taken from User-Reg-Form
        Contact u=new Contact();
        u.setName("eSHIKA");
        u.setPhone("9888888888");
        u.setEmail("eshi.agra@gmaol.com");
        u.setAddress("14nilkhil");
        u.setRemark("hi");
        u.setContactid(1);
        u.setUserid(1);
        contactDAO.save(u);
        System.out.println("data saved..............");
        
	}
}
