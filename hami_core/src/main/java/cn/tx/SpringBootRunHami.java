package cn.tx;

//import org.apache.shiro.realm.Realm;
//import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
//import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
//import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
//import cn.tx.service.realm.ShiroUserRealm;
//import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
//import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.servlet.MultipartConfigElement;
import java.util.LinkedHashMap;


@SpringBootApplication
@MapperScan("cn.tx.mapper")
public class SpringBootRunHami {
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootRunHami.class, args);
	}
//	@Bean
//	public Realm Realm(){
//
//
//		return new ShiroUserRealm();
//	}
//	@Bean
//	public ShiroFilterChainDefinition shiroFilterChainDefinition() {
//		DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
//		LinkedHashMap<String,String> map=new LinkedHashMap<>();
//		//设置允许匿名访问的资源路径(不需要登录即可访问)
//		map.put("/css/**","anon");//anon对应shiro中的一个匿名过滤器
//		map.put("/font/**","anon");
//		map.put("/images/**","anon");
//		map.put("/img/**","anon");
//		map.put("/javascript/**","anon");
//		map.put("/js/**","anon");
//		map.put("/open-iconic/**","anon");
//		map.put("/style/**","anon");
//		map.put("/login.jsp","anon");
//		map.put("/header.jsp","anon");
//		map.put("/user/doLogin","anon");
//		map.put("/doLogout","logout");
//		//设置需认证以后才可以访问的资源(注意这里的顺序,匿名访问资源放在上面)
//		map.put("/**","authc");//authc 对应一个认证过滤器，表示认证以后才可以访问
//		chainDefinition.addPathDefinitions(map);
//		return chainDefinition;
//	}
}
