package test;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.shi.leasplat.entity.Goods;
import cn.shi.leasplat.service.GoodsService;
import cn.shi.leasplat.util.Page;

public class GoodsTest {

	ApplicationContext ac;
	@Before
	public void init(){
		 ac=new ClassPathXmlApplicationContext(
				"spring-web.xml","spring-mybatis.xml","spring-service.xml");
	}
	
//	@Test
	/**
	 * 测试商品添加
	 */
	public  void save(){
		Goods goods = new Goods();
		goods.setUserId(1);
		goods.setBasicUnit(1);//(0天,1月,2年)
		goods.setGoodsClassId(1);
//		goods.setGoodsImageId(1);
		goods.setName("佳能（Canon）EOS 5DS 照相机");
		goods.setGoodsMessage("");
		goods.setPrice(new BigDecimal(12));//以元为单位
		GoodsService goodsService = ac.getBean("goodsService",GoodsService.class);
		Integer count = goodsService.save(goods);
		System.out.println(count);
	}

//	@Test
	/**
	 * 查询一条数据
	 */
	public void getById(){
		GoodsService goodsService = ac.getBean("goodsService",GoodsService.class);
		Goods goods = goodsService.getById(1);
		System.out.println(goods);
	}
	/**
	 * 测试删除
	 */
//	@Test
	public void delete()
	{
		GoodsService goodsService = ac.getBean("goodsService",GoodsService.class);
		Integer count = goodsService.delete(1);
		System.out.println(count);
	}
	
//	@Test
	/**
	 * 测试修改
	 */
	public void update(){
		GoodsService goodsService = ac.getBean("goodsService",GoodsService.class);
		Goods goods = new Goods();
		goods.setId(1);
		goods.setUserId(1);
		goods.setBasicUnit(0);//(0天,1月,2年)
		goods.setGoodsClassId(1);
//		goods.setGoodsImageId(1);
		goods.setName("苹果电脑");
		goods.setPrice(new BigDecimal(12));//已元为单位
		Integer count = goodsService.update(goods);
		System.out.println(count);
	}
	
//	@Test
	public void getCount()
	{
		GoodsService goodsService = ac.getBean("goodsService",GoodsService.class);
		Integer count = goodsService.getCount("苹果电脑");
		System.out.println(count);
	}
	
	/**
	 * 测试分页查找
	 */
//	@Test
	public void findPage(){
		GoodsService goodsService = ac.getBean("goodsService",GoodsService.class);
		Page<Goods> page = goodsService.findPage(1, 10, "苹果电脑");
		System.out.println(page.getResult().size());
	}
}
