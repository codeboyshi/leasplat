package cn.shi.leasplat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.shi.leasplat.annotation.Auditable;
import cn.shi.leasplat.entity.GoodsClass;
import cn.shi.leasplat.service.GoodsClassService;
import cn.shi.leasplat.util.Page;
import cn.shi.leasplat.util.Result;

@RequestMapping("/goodsclass")
@Controller
public class GoodsClassController {
	
	@Autowired
	private GoodsClassService goodsClassService;
	
	@RequestMapping("/list.do")
	public String toList()
	{
		return "/html/admin-goods-class";
	}
	
	@RequestMapping("/select.do")
	@ResponseBody
	public Result select(@RequestParam Integer pageNo,
						@RequestParam Integer pageSize,
						@RequestParam(required = false) String name)
	{
		Result res = new Result();
		try {
			Page<GoodsClass> page = goodsClassService.findPage(pageNo, pageSize, name);
			res.setData(page);
		} catch (Exception e) {
			res.setError(e);
		}
		return res;
	}
	
	@RequestMapping("/delete.do")
	@ResponseBody
	@Auditable(moduleName="商品类别管理", operationName="删除")
	public Result delete(@RequestParam Integer id)
	{
		Result res = new Result();
		try {
			goodsClassService.delete(id);
		} catch (Exception e) {
			res.setError(e);
		}
		return res;
	}
	
	// 修改
	@RequestMapping("/edit.do")
	public String edit(@RequestParam Integer id,
						Model model)
	{
		GoodsClass goodsClass = goodsClassService.getById(id);
		model.addAttribute("goodsClass", goodsClass);
		return "/html/goods-class-edit";
	}
	
	@RequestMapping("/update.do")
	@ResponseBody
	@Auditable(moduleName="商品类别管理", operationName="修改")
	public Result update(@RequestParam Integer id,
						@RequestParam String name)
	{
		Result res = new Result();
		try {
			GoodsClass goodsClass = new GoodsClass();
			goodsClass.setId(id);
			goodsClass.setName(name);
			goodsClassService.update(goodsClass);
		} catch (Exception e) {
			res.setError(e);
		}
		return res;
	}
	
	@RequestMapping("/add.do")
	public String add()
	{
		return "/html/goods-class-add";
	} 
	
	@RequestMapping("/save.do")
	@ResponseBody
	@Auditable(moduleName="商品类别管理", operationName="添加")
	public Result save(@RequestParam String name)
	{
		Result res = new Result();
		try {
			GoodsClass goodsClass = new GoodsClass();
			goodsClass.setName(name);
			goodsClassService.save(goodsClass);
		} catch (Exception e) {
			res.setError(e);
		}
		return res;
	}
}
