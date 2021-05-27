package in.ezeon.capp.service;
import in.ezeon.capp.dao.BaseDAO;
import in.ezeon.capp.dao.ContactDAO;
import in.ezeon.capp.domain.Contact;
import in.ezeon.capp.rm.ContactRowMapper;
import in.ezeon.capp.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContactServiceImpl extends BaseDAO implements ContactService{
    
    @Autowired
    private ContactDAO contactDAO;
    
//    @Override    
    public void save(Contact c) {
        contactDAO.save(c);
    }

//    @Override
    public void update(Contact c) {
        contactDAO.update(c);
    }

//    @Override
    public void delete(Integer cotactId) {
        contactDAO.delete(cotactId);
    }

//    @Override
    public void delete(Integer[] cotactIds) {//as not theer in contactdao so create
        String ids = StringUtil.toCommaSeparatedString(cotactIds);//create cls string itol
        String sql = "DELETE FROM contact WHERE contactId IN("+ids+")";
        getJdbcTemplate().update(sql);
    }

//    @Override
    public List findUserContact(Integer userId) {
        return contactDAO.findByProperty("userId", userId);
    }

//    @Override
    public List findUserContact(Integer userId, String txt) {
        String sql = "SELECT contactId, userId, name, phone, email, address, remark FROM contact WHERE userId=? AND (name LIKE '%"+txt+"%' OR address LIKE '%"+txt+"%' OR phone LIKE '%"+txt+"%' OR email LIKE '%"+txt+"%' OR remark LIKE '%"+txt+"%')";
        return getJdbcTemplate().query(sql, new ContactRowMapper(),userId); 
    }

	public Contact findById(Integer contactId) {
		// TODO Auto-generated method stub
		return contactDAO.findById(contactId) ;
	}    
	
}
