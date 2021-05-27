package in.ezeon.capp.config;
import org.apache.taglibs.standard.tlv.JstlBaseTLV;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
//as mvc alyer so 3 comonents 1.controller @componentscan 2.handlermapping 3.viewresolver
@Configuration
@ComponentScan(basePackages={"in.ezeon"})//will scan all pkgs of this pkg
@EnableWebMvc//WILL ENABLE MVC..ACTIVATE MVC CONFIG
public class SpringWebConfig extends WebMvcConfigurerAdapter{
	//how to handle static resource(csshtml..) as soring will not allow any res to access on jsp pg
		//if it is not configured
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**").addResourceLocations("/static/");
//	contents present in static will be accessible from webpage 
    //** means all css js files
}
@Bean//DN KNOW USE
public ViewResolver viewResolver()
{
	//if any directory prsent in private folder(web-infy)..noone from browse can access content directly if under web-infy
	//so inside view folder we are gng to add all our jsps
	InternalResourceViewResolver vr=new InternalResourceViewResolver();
	vr.setViewClass(JstlView.class);//as jsp comes under this
	vr.setPrefix("/WEB-INF/view/");
	vr.setSuffix(".jsp");
	return vr;
}
}
