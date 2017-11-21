package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.shi.leasplat.dao.UserDao;
import cn.shi.leasplat.entity.User;
import cn.shi.leasplat.util.Utils;

public class UserTest {
	ApplicationContext ac;
	@Before
	public void init(){
		 ac=new ClassPathXmlApplicationContext(
				"spring-web.xml","spring-mybatis.xml","spring-service.xml");
	}
//	@Test
	/**
	 * id≤È—ØºÏ≤‚
	 */
	public void test(){
		UserDao dao=ac.getBean("userDao",UserDao.class);
		User user=dao.findUserById(1);
		System.out.println("user:"+user);
	}
//	@Test
	/**
	 * ≤Â»Î≤‚ ‘
	 */
	public void saveTest(){
		UserDao dao=ac.getBean("userDao",UserDao.class);
		User user=new User();
		user.setUserName("demo");
		user.setPassword(Utils.md5salt("123"));
		user.setUserSex("1");
		user.setPhone("13091450766");
		dao.saveUser(user);
	}
	//@Test
	/**
	 * √˚◊÷≤È—Ø≤‚ ‘
	 */
	public void selectName(){
		UserDao dao=ac.getBean("userDao",UserDao.class);
		User user = dao.findUserByName("admin");
		System.out.println("user:"+user);
	}
//	@Test
	//∏¸–¬≤Ÿ◊˜≤‚ ‘
	public void updateUser(){
		UserDao dao=ac.getBean("userDao",UserDao.class);
		User user=new User();
		user.setUserName("admin");
		user.setPassword("admin");
		user.setUserSex("1");
		user.setPhone("13091450766");
		dao.updateUser(user);
	}
}
