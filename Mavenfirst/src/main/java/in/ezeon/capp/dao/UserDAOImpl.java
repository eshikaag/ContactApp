package in.ezeon.capp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import in.ezeon.capp.domain.User;
import in.ezeon.capp.rm.UserRowMapper;
@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {

//    @Override

		 public void save(User u) {
		        String sql = "INSERT INTO user(name, phone, email, address, loginName, password, role, loginStatus)"
		                + " VALUES(:name, :phone, :email, :address, :loginName, :password, :role, :loginStatus)";
		        Map m = new HashMap();
		        m.put("name", u.getName());
		        m.put("phone", u.getPhone());
		        m.put("email", u.getEmail());
		        m.put("address", u.getAddress());
		        m.put("loginName", u.getLoginName());
		        m.put("password", u.getPassword());
		        m.put("role", u.getRole());
		        m.put("loginStatus", u.getLoginStatus());

		        KeyHolder kh = new GeneratedKeyHolder();//auto genertaed ids it will store
		        SqlParameterSource ps = new MapSqlParameterSource(m);//Bind all Map values
		        super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
		        Integer userId = kh.getKey().intValue();
		        u.setUserId(userId);
	}

	public void update(User u) {
		// TODO Auto-generated method stub
		 String sql = "UPDATE user "
	                + " SET name=:name,"
	                + " phone=:phone, "
	                + " email=:email,"
	                + " address=:address,"
	                + " role=:role,"
	                + " loginStatus=:loginStatus "
	                + " WHERE userId=:userId";
	        Map m = new HashMap();//BINDING ALL VALUES
	        m.put("name", u.getName());
	        m.put("phone", u.getPhone());
	        m.put("email", u.getEmail());
	        m.put("address", u.getAddress());       
	        m.put("role", u.getRole());
	        m.put("loginStatus", u.getLoginStatus());
	        m.put("userId", u.getUserId());
	        getNamedParameterJdbcTemplate().update(sql, m);
	}

	 public void delete(User u) {
	        this.delete(u.getUserId());//USING BELOW METHOD TO GET ID AND THEN DELETE USING OBJ
	    }

	    public void delete(Integer userId) {
	        String sql="DELETE FROM user WHERE userId=?";
	        getJdbcTemplate().update(sql, userId);//CAN USE TEMP ONE OBJ ALSO ..ANY
	    
	}

	public User findById(Integer userId) {
		// TODO Auto-generated method stub
		String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus"
                + " FROM user WHERE userId=?";
		User u=getJdbcTemplate().queryForObject(sql, new UserRowMapper(),userId);
		//queryforobj will help to fetch single recode data
		//nd atlast written userid as ? so replace ? with userid as ned to find record by that only
	return u;
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus"
                + " FROM user";
           /*
           List users = getJdbcTemplate().query(sql, new UserRowMapper());
           return users;
           */
           return getJdbcTemplate().query(sql, new UserRowMapper());
	}

	public List<User> findByProperty(String propname, Object propValue) {
		// TODO Auto-generated method stub
		String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus"
                + " FROM user WHERE "+propname+"=?";
         return getJdbcTemplate().query(sql, new UserRowMapper(), propValue);
	}

}
