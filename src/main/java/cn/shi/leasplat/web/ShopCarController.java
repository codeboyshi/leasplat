package cn.shi.leasplat.web;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.shi.leasplat.annotation.Auditable;
import cn.shi.leasplat.entity.Goods;
import cn.shi.leasplat.entity.GoodsImage;
import cn.shi.leasplat.entity.ShopCar;
import cn.shi.leasplat.service.GoodsImageService;
import cn.shi.leasplat.service.GoodsService;
import cn.shi.leasplat.service.NameOrPasswordException;
import cn.shi.leasplat.service.ShopCarService;
import cn.shi.leasplat.util.Result;

@Controller
@RequestMapping("/shop")
public class ShopCarController {

	@Autowired
	private ShopCarService shopCarService;
	
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private GoodsImageService goodsImageService;
	
	@RequestMapping("/list.do")
	public String list(Model model, HttpServletRequest request)
	{
		String userId = "";
		Cookie [] cookie = request.getCookies();
		for (int i = 0;i < cookie.length;i++)
		{
			if ("userId".equals(cookie[i].getName()))
			{
				userId = cookie[i].getValue();
			}
		}
//		if ("".equals(userId)) return "/index";
		Integer uId = Integer.parseInt(userId);
		List<ShopCar> shopCarList = shopCarService.findByUserId(uId);
		for (ShopCar shopCar : shopCarList)
		{
			Goods goods = goodsService.getById(shopCar.getGoodsId());
			GoodsImage goodsImage = goodsImageService.getByGoodsId(goods.getId());
			shopCar.setGoods(goods);
			shopCar.setGoodsImageId(goodsImage.getId());
		}
		model.addAttribute("shopCarList", shopCarList);
		return "/html/shopcart";
	}
	
	@RequestMapping("/save.do")
	@ResponseBody
	@Auditable(moduleName="租物车管理", operationName="添加")
	public Result save(ShopCar shopCar, HttpServletRequest request)
	{
		Result res = new Result();
		try {
			String userId = "";
			Cookie [] cookie = request.getCookies();
			for (int i = 0;i < cookie.length;i++)
			{
				if ("userId".equals(cookie[i].getName()))
				{
					userId = cookie[i].getValue();
				}
			}
			if ("".equals(userId)) throw new NameOrPasswordException("请先登录");
			Integer uId = Integer.parseInt(userId);
			Integer count = shopCarService.getMyGoodsCount(uId);
			if (count >= 5) throw new NameOrPasswordException("您租物车中商品已达上限");
			shopCar.setUserId(uId);
			shopCarService.save(shopCar);
		} catch (Exception e) {
			res.setError(e);
		}
		return res;
	}
	
	@RequestMapping("/delete.do")
	@ResponseBody
	@Auditable(moduleName="租物车管理", operationName="删除")
	public Result delete(@RequestParam Integer id)
	{
		Result res = new Result();
		try {
			shopCarService.delete(id);
		} catch (Exception e) {
			res.setError(e);
		}
		return res;
	}
	
	@RequestMapping("/update.do")
	@ResponseBody
	@Auditable(moduleName="租物车管理", operationName="修改")
	public Result update(@RequestParam Integer day,
							@RequestParam Integer id)
	{
		Result res = new Result();
		try {
			shopCarService.update(day, id);
		} catch (Exception e) {
			res.setError(e);
		}
		return res;
	}
}
