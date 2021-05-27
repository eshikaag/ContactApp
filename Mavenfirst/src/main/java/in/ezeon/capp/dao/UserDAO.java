package in.ezeon.capp.dao;

import java.util.List;

import in.ezeon.capp.domain.User;

public interface UserDAO {
public void save(User u);
public void update(User u);
public void delete(User u);
public void delete(Integer userId);
public User findById(Integer userId);
public List<User> findAll();
public List<User> findByProperty(String propname,Object propValue);//propname is col name nd obj is int or str


}
