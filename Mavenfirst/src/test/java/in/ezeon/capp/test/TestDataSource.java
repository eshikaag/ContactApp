//This Project Work(Contact App) video is about DataSource/Connection Pool configuration and testing it independently(out of MVC and Without Web Server). 
//
//WHAT IS CONNECTION POOLING?
//Its a technique to manage and utilize the database connections effectively. Connection Pool is a cache of connection objects where pre-created connections are present. When application required a connection to execute SQL, we borrow it from connection pool, use it and place-back to pool. So that the same connection object can be reused for next SQL execution. This technique optimize the use of connection objects.
//Here in Java connection pool is an implementation of javax.sql.DataSource object.
package in.ezeon.capp.test;

import in.ezeon.capp.config.SpringRootConfig;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestDataSource {  
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        //prov confign info to appn..and implements all functionality of beanfactory
        DataSource ds = ctx.getBean(DataSource.class);
        //help to get bean of cls springroot..and basicds iwmplement ds
        JdbcTemplate jt = new JdbcTemplate(ds);
        //to exeure queries in db
        String sql="INSERT INTO user(`name`, `phone`, `email`, `address`, `loginName`, `password`) VALUES(?,?,?,?,?,?)";
        Object[] param = new Object[]{"Vikramagrawal", "9303580884", "vikram@ezeon.net", "Bhopal", "eshiiii", "v123"};
        jt.update(sql, param);
        System.out.println("------SQL executed-----");
    }    
}