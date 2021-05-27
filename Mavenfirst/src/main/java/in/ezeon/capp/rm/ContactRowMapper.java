
package in.ezeon.capp.rm;
import in.ezeon.capp.domain.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ContactRowMapper implements RowMapper{

	public Object mapRow(ResultSet rs, int i) throws SQLException {
		// TODO Auto-generated method stub
		Contact c=new Contact();
		c.setContactid(rs.getInt("contactId"));
		c.setUserid(rs.getInt("userId"));
        c.setName(rs.getString("name"));
        c.setPhone(rs.getString("phone"));
        c.setEmail(rs.getString("email"));

        c.setRemark(rs.getString("remark"));
       
        return c;
	}
	
	
	
	
}