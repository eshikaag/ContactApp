package in.ezeon.capp.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages={"in.ezeon.capp.dao","in.ezeon.capp.Service"})//will scan all pkgs of this pkg
//so that dao and services can be read together@EnableWebMvc
public class SpringRootConfig {
@Bean
	
	public BasicDataSource getDataSource()//cls that implements ds
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/c_appdb");
		ds.setUsername("root");
		ds.setPassword("");
		ds.setInitialSize(1);//initial no of conn
		ds.setMaxTotal(2);//max no of conn that can be sret as per need
		ds.setTestOnBorrow(true);//conn is tested
		ds.setValidationQuery("SELECT 1");//validn query that need to be perf to test conn
		ds.setDefaultAutoCommit(true);//auto conmit isperformed
		return ds;
	}

}


