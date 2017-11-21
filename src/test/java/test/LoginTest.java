package test;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.shi.leasplat.entity.User;
import cn.shi.leasplat.service.UserService;

public class LoginTest {
	ApplicationContext ac;
	@Before
	public void init(){
		 ac=new ClassPathXmlApplicationContext(
				"spring-web.xml","spring-mybatis.xml","spring-service.xml");
	}
	@Test
	/**
	 * 测试登录方法
	 */
	public void Logint(){
		UserService service=ac.getBean("userService",UserService.class);
		HttpServletRequest req = null;
		User user =service.login("admin","admin","sfdz",req);//假验证码
		System.out.println(user);
		
	}
}
