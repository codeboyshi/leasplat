package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.shi.leasplat.dao.MessageDao;
import cn.shi.leasplat.entity.Message;

public class MessageTest {

	ApplicationContext ac;
	@Before
	public void init(){
		 ac=new ClassPathXmlApplicationContext(
				"spring-web.xml","spring-mybatis.xml","spring-service.xml");
	}
	
//	@Test
	public void saveTest(){
	  MessageDao dao = ac.getBean("messageDao",MessageDao.class);
	  Message message = new Message();
	  message.setUserId(4);
	  message.setMessage("ÄãºÃ9");
	  System.out.println(dao.save(message));
	}
	
	@Test
	public void findPageTest(){
		 MessageDao dao = ac.getBean("messageDao",MessageDao.class);
		 List<Message> list = dao.findPage(5, 10);
		 System.out.println(list);
	}
}
