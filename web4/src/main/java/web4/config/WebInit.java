package web4.config;



import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {
			WebConfig.class
		};
	}
	
	

	@Override
	protected WebApplicationContext createServletApplicationContext() {
		AnnotationConfigWebApplicationContext wac=new AnnotationConfigWebApplicationContext();
		wac.register(WebConfig.class);
		return wac;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {
				"/"
		};
	}

//	@Override
//	protected Filter[] getServletFilters() {
//		CharacterEncodingFilter cef=new CharacterEncodingFilter();
//		cef.setEncoding("UTF-8");
//		cef.setForceEncoding(true);
//		return new Filter[]{
//				(Filter) new HiddenHttpMethodFilter(),cef
//		};
//	}
	
	

}
