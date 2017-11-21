package test;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.shi.leasplat.entity.GoodsImage;
import cn.shi.leasplat.service.GoodsImageService;

public class GoodsImageTest {
	ApplicationContext ac;
	@Before
	public void init(){
		 ac=new ClassPathXmlApplicationContext(
				"spring-web.xml","spring-mybatis.xml","spring-service.xml");
	}
	
	/**
	 * ≤‚ ‘≤Â»Î
	 */
//	@Test
	public void save(){
		GoodsImage goodsImage = new GoodsImage();
		goodsImage.setGoodsId(1);
		goodsImage.setPath("d:"+File.separator + "image");
		GoodsImageService goodsImageService = ac.getBean("goodsImageService",GoodsImageService.class);
		goodsImageService.save(goodsImage);
	}
	/**
	 * ≤‚ ‘≤È—Ø
	 */
//	@Test
	public void findList()
	{
		GoodsImageService goodsImageService = ac.getBean("goodsImageService",GoodsImageService.class);
		List<GoodsImage> list = goodsImageService.findByGoodsId(1);
		System.out.println(list);
	}
	
	/**
	 * ≤‚ ‘–ﬁ∏ƒ
	 */
	@Test
	public void update()
	{
		GoodsImage goodsImage = new GoodsImage();
		goodsImage.setId(3);
		goodsImage.setGoodsId(1);
		goodsImage.setPath("d:"+File.separator + "images");
		System.out.println(goodsImage);
		GoodsImageService goodsImageService = ac.getBean("goodsImageService",GoodsImageService.class);
		Integer count = goodsImageService.update(goodsImage);
		System.out.println(count);
	}
}
