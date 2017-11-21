package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.shi.leasplat.entity.GoodsClass;
import cn.shi.leasplat.service.GoodsClassService;

public class GoodsClassTest {

	ApplicationContext ac;
	@Before
	public void init(){
		 ac=new ClassPathXmlApplicationContext(
				"spring-web.xml","spring-mybatis.xml","spring-service.xml");
	}
	
	/**
	 * 测试插入商品类别
	 */
//	@Test
	public void save()
	{
		GoodsClass goodsClass = new GoodsClass();
		goodsClass.setName("电脑");
		GoodsClassService goodsClassService = ac.getBean("goodsClassService",GoodsClassService.class);
		Integer count = goodsClassService.save(goodsClass);
		System.out.println(count);
	}
	/**
	 * 测试查询
	 */
	@Test
	public void findAll()
	{
		GoodsClassService goodsClassService = ac.getBean("goodsClassService",GoodsClassService.class);
		List<GoodsClass> list = goodsClassService.findAll();
		System.out.println(list);
	}
}
