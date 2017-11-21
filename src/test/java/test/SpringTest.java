package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * ≤‚ ‘spring≈‰÷√Œƒº˛
 * @author ASUS
 *
 */
public class SpringTest {
	ApplicationContext ac;
	@Before
	public void init(){
		 ac=new ClassPathXmlApplicationContext(
				"spring-web.xml","spring-mybatis.xml","spring-service.xml");
	}
	
	@Test
	public void test(){
		Object b=ac.getBean("dataSource");
		System.out.println(b);
		b=ac.getBean("sqlSessionFactory");
		System.out.println(b);
		b=ac.getBean("mapperScanner");
		System.out.println(b);
	}
}
