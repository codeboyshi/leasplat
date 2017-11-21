package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.shi.leasplat.dao.AccessTokenDao;
import cn.shi.leasplat.entity.AccessToken;

public class AccessTokenTest {

	ApplicationContext ac;
	@Before
	public void init(){
		 ac=new ClassPathXmlApplicationContext(
				"spring-web.xml","spring-mybatis.xml","spring-service.xml");
	}
	
//	@Test
	//测试存入token
	public void saveTest(){
		AccessTokenDao dao = ac.getBean("accessTokenDao",AccessTokenDao.class);
		AccessToken token = new AccessToken();
		token.setUserId(4);
		token.setToken("sdkuahteosadigulosragterwgt");
		dao.saveToken(token);
	}
	
//	@Test
	//测试查出token个数
	public void getCountTest(){
		AccessTokenDao dao = ac.getBean("accessTokenDao",AccessTokenDao.class);
		int i = dao.getCount(4);
		System.out.println(i);
	}
	
	@Test
	//测试删除token
	public void deleteTest(){
		AccessTokenDao dao = ac.getBean("accessTokenDao",AccessTokenDao.class);
		dao.deleteByUserId(4);
	}

}
