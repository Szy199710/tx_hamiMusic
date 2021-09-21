package cn.tx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class HamiPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HamiPortalApplication.class, args);
	}
	public class DefaultController  extends WebMvcConfigurerAdapter {
		@Override
		public void addViewControllers( ViewControllerRegistry registry ) {
			registry.addViewController( "/" ).setViewName( "forward:/songer/dofindAll" );
			registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
			super.addViewControllers( registry );
		}
	}
}
