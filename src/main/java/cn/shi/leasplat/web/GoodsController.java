package cn.shi.leasplat.web;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.shi.leasplat.annotation.Auditable;
import cn.shi.leasplat.entity.File;
import cn.shi.leasplat.entity.Goods;
import cn.shi.leasplat.entity.GoodsClass;
import cn.shi.leasplat.entity.GoodsImage;
import cn.shi.leasplat.entity.User;
import cn.shi.leasplat.service.FileService;
import cn.shi.leasplat.service.GoodsClassService;
import cn.shi.leasplat.service.GoodsImageService;
import cn.shi.leasplat.service.GoodsService;
import cn.shi.leasplat.service.NameOrPasswordException;
import cn.shi.leasplat.service.UserService;
import cn.shi.leasplat.util.Page;
/**
 * 商品管理
 * @author Administrator
 *
 */
import cn.shi.leasplat.util.Result;
@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GoodsClassService goodsClassService;
	
	@Autowired
	private GoodsImageService goodsImageService;
	
	@Autowired
	private FileService fileService;
	/**
	 * 跳转商品列表页
	 * @param model
	 * @return
	 */
	@RequestMapping("/list.do")
	public String goodsList(Model model){
		return "/html/goods-list";
	}
	
	/**
	 * 我要出租页面，即出租页上传商品
	 */
	@RequestMapping("/add.do")
	public String add(Model model, HttpServletRequest request){
		
		String userId = "";
		Cookie [] cookie = request.getCookies();
		for (int i = 0;i < cookie.length;i++)
		{
			if ("userId".equals(cookie[i].getName()))
			{
				userId = cookie[i].getValue();
			}
		}
		if ("".equals(userId))
		{
			return "/index";
		}
		else
		{
			User user = userService.findUserById(Integer.parseInt(userId));
			if("".equals(user.getPhone()) || null == user.getPhone())
			{
				//TODO:应该跳转完善信息界面
				return "/html/info";
			}
		}
		List<GoodsClass> goodsClasses = goodsClassService.findAll();
		model.addAttribute("goodsClasses",goodsClasses);
		return "/html/add-goods";
	}
	
	@RequestMapping("/save.do")
	@ResponseBody
	@Transactional(rollbackFor = Exception.class)
	@Auditable(moduleName="商品管理", operationName="添加")
	public Result save(@RequestParam("imgs[]") Integer [] imgs,
						Goods goods,
						HttpServletRequest request) throws Exception{
		Result res = new Result();
		// 1.添加商品
		
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
			Integer myGoodsCount = goodsService.getMyGoodsCount(Integer.parseInt(userId));
			User user = userService.findUserById(Integer.parseInt(userId));		
			if (null == user.getPhone() || "".equals(user.getPhone())) throw new NameOrPasswordException("请您先完善信息！");
			if (myGoodsCount >= 5) throw new NameOrPasswordException("您上传的商品数量已经达到上限");
			goods.setUserId(Integer.parseInt(userId));
			goodsService.save(goods);
			Integer goodsId = goodsService.getId();
			// 2. 添加图片
			for(int i = 0;i < imgs.length;i++)
			{
				File file = fileService.getById(imgs[i]);
				goodsImageService.save(new GoodsImage(goodsId, file.getPath()));
			}
		} catch (Exception e) {
			res.setError(e);
			throw e;
		}finally
		{
			return res;
		}
		
	}
	
	// 跳转到我的商品列表页面
	@RequestMapping("/myList.do")
	public String myGoodsList(Model model, HttpServletRequest request)
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
		if ("".equals(userId)) return "index";
		List<Goods> myGoodsList = goodsService.findMyGoods(Integer.parseInt(userId));
		for (Goods goods : myGoodsList)
		{
			GoodsImage goodsImage = goodsImageService.getByGoodsId(goods.getId());
			goods.setImageId(goodsImage.getId());
		}
		model.addAttribute("myGoodsList",myGoodsList);
		return "/html/my-goods-list";
	}
	
	// 跳转到修改页面
	@RequestMapping("/edit.do")
	public String edit(@RequestParam Integer id, Model model)
	{
		Goods goods = goodsService.getById(id);
		List<GoodsClass> goodsClassList = goodsClassService.findAll();
		List<GoodsImage> goodsImageList = goodsImageService.findByGoodsId(id);
		model.addAttribute("goodsImageList", goodsImageList);
		model.addAttribute("goodsClassList", goodsClassList);
		model.addAttribute("goods", goods);
		return "/html/edit-goods";
	}
	
	
	@RequestMapping("/update.do")
	@ResponseBody
	@Transactional(rollbackFor = Exception.class)
	@Auditable(moduleName="商品管理", operationName="修改")
	public Result update(@RequestParam("imgs[]") Integer [] imgs,
						Goods goods,
						HttpServletRequest request)
	{
		System.out.println(goods);
		Result res = new Result();
		try {
			goodsService.update(goods);
			// 添加前先将此商品的所有图片删除
			goodsImageService.deleteByGoodsId(goods.getId());
			System.out.println(goods.getId());
			// 2. 添加图片
			for(int i = 0;i < imgs.length;i++)
			{
				File file = fileService.getById(imgs[i]);
				goodsImageService.save(new GoodsImage(goods.getId(), file.getPath()));
			}
		} catch (Exception e) {
			res.setError(e);
		}finally{
			return res;
		}
	}
	
	// 删除商品
	@RequestMapping("/delete.do")
	@ResponseBody
	@Auditable(moduleName="商品管理", operationName="删除")
	public Result delete(@RequestParam Integer id)
	{
		Result res = new Result();
		try {
			goodsService.delete(id);
		} catch (Exception e) {
			res.setError(e);
		}
		return res;
	}
	
	// 最新6件商品
	@RequestMapping("/newest.do")
	@ResponseBody
	public Result newestGoods()
	{
		Result res = new Result(); 
		try {
			List<Goods> goodsList = goodsService.findNewestGoods();
			for(Goods goods : goodsList)
			{
				User user = userService.findUserById(goods.getUserId());
				user.setPassword("");
				user.setSecretAnswer("");
				user.setSecurity("");
				GoodsImage goodsImage = goodsImageService.getByGoodsId(goods.getId());
				goods.setImageId(goodsImage.getId());
				goods.setUser(user);
			}
			res.setData(goodsList);
		} catch (Exception e) {
			res.setError(e);
		}
		return res;
	}
	
	
	// 商品详情
	@RequestMapping("/detail.do")
	public String detail(@RequestParam Integer id,
						 Model model)
	{
		Goods goods = goodsService.getById(id);
		User user = userService.findUserById(goods.getUserId());
		user.setPassword("");
		user.setSecretAnswer("");
		goods.setUser(user);
		List<GoodsImage> goodsImageList = goodsImageService.findByGoodsId(goods.getId());
		model.addAttribute("goods", goods );
		model.addAttribute("goodsImageList", goodsImageList);
		return "/html/goods-detail";
	}
	
	@RequestMapping("/serch.do")
	public String indexToList(String serchName, Model model){
		model.addAttribute("serchName", serchName);
		return "/html/goods-list";
	}
	
	// 分页查询商品，带查询条件的
	@RequestMapping("/select.do")
	@ResponseBody
	public Result select(@RequestParam(required = false) String selectName,
							@RequestParam Integer pageNo,
							@RequestParam Integer pageSize)
	{
		Result res = new Result();
		try {
			Page<Goods> page = goodsService.findPage(pageNo, pageSize, selectName);
			res.setData(page);
		} catch (Exception e) {
			res.setError(e);
		}
		return res;
	}
}
