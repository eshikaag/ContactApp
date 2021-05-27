package in.ezeon.capp.dao;

import java.util.List;

import org.apache.catalina.User;

import in.ezeon.capp.domain.Contact;

public interface ContactDAO {
	public void save(Contact c);
	public void update(Contact c);
	public void delete(Contact c);
	public void delete(Integer contactId);
	public Contact findById(Integer contactId);
	public List<Contact> findAll();
	public List<Contact> findByProperty(String propname,Object propValue);//propname is col name nd obj is int or str

}
