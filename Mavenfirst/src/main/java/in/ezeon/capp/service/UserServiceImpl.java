package in.ezeon.capp.service;

import in.ezeon.capp.dao.BaseDAO;
import in.ezeon.capp.dao.UserDAO;
import in.ezeon.capp.domain.User;
import in.ezeon.capp.exception.UserBlockedException;
import in.ezeon.capp.rm.UserRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


@Service//as service layer btr to write coponent in specific way
//extend basedao for accessing db
//not diectly implementing userdaoimp as 1 layer shld communicate with other layer through interface
public class UserServiceImpl extends BaseDAO implements UserService{
    @Autowired//so that obj of userdao available here as not creatin obj only nnotation
    private UserDAO userDAO;//so that can access userdao methods and reuse them
    
//    @Override
    public void register(User u) {
        userDAO.save(u);//we have to make this service layer though we could have used this 
        //from userdao only as dao works on single table but we need to wrk on multiple tables
    }

//   @Override
    public User login(String loginName, String password) throws UserBlockedException {
        String sql = "SELECT userId, name, phone, email, address, role, loginStatus, loginName"
                + " FROM user WHERE loginName=:ln AND password=:pw";
        Map<String,Object> m= new HashMap<String,Object>();
        m.put("ln", loginName);
        m.put("pw", password);
        try {
//        	User u=getJdbcTemplate().queryForObject(sql,new Object[]{ln,pw},new UserRowMapper());

           User u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
           //using queryforobj as unique loginname so 1 record of the binded data will get fetched
            //using rowmapper so that ssuer acn get returned
           //all records ass with that loginname and pass will be now in obj u
            if (u.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)) 
            //is status is blocked then throw this exception
            {
                throw new UserBlockedException("Your accout has been blocked. Contact to admin.");
           
            } else {
                return u;//when no recoerd retured or no record there the below n excep will get thrown
            }
        } catch (EmptyResultDataAccessException ex) {
            return null;
        	
//if name not there then null
        }
    }
//    @Override
    public List getUserList() {

        return userDAO.findByProperty("role", UserService.ROLE_USER);

    
    }

//    @Override
    public void changeLoginStatus(Integer userId, Integer loginStatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	public Boolean isUsernameExist(String username) {
		// TODO Auto-generated method stub
		return null;
	}    
}

