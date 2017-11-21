package cn.shi.leasplat.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.shi.leasplat.annotation.Auditable;
import cn.shi.leasplat.entity.Notices;
import cn.shi.leasplat.service.NoticesService;
import cn.shi.leasplat.util.Page;
import cn.shi.leasplat.util.Result;

@Controller
@RequestMapping("/notice")
public class NoticesController {
	
	@Autowired
	private NoticesService noticesService;
	
	@RequestMapping("/list.do")
	@ResponseBody
	public Result list()
	{
		Result res = new Result();
		try {
			List<Notices> noticesList = noticesService.findList();
			res.setData(noticesList);
		} catch (Exception e) {
			res.setError(e);
		}
		return res;
	}
	
	@RequestMapping("/toList.do")
	public String toList()
	{
		return "/html/notices";
	}
	
	@RequestMapping("/view.do")
	@ResponseBody
	public Result page(@RequestParam Integer pageNo,
						@RequestParam Integer pageSize,
						@RequestParam(required = false) String name)
	{
		Result res = new Result();
		try {
			Page<Notices> page = noticesService.findPage(pageNo, pageSize, name);
			res.setData(page);
		} catch (Exception e) {
			res.setError(e);
		}
		return res;
	}
	
	@RequestMapping("/add.do")
	public String add(Model model)
	{
		return "/html/notices-add";
	}
	
	@RequestMapping("/save.do")
	@ResponseBody
	@Auditable(moduleName="系统通知管理", operationName="添加")
	public Result save(@RequestParam String name)
	{
		Result res = new Result();
		try {
			Notices notices = new Notices();
			notices.setNoticeMessage(name);
			noticesService.save(notices);
		} catch (Exception e) {
			res.setError(e);
		}
		return res;
	}
	
	@RequestMapping("/edit.do")
	public String edit(@RequestParam Integer id,
						Model model)
	{
		Notices notices = noticesService.getById(id);
		model.addAttribute("notices", notices);
		return "/html/notices-edit";
	}
	
	@RequestMapping("/update.do")
	@ResponseBody
	@Auditable(moduleName="系统通知管理", operationName="修改")
	public Result update(@RequestParam String name,@RequestParam Integer id)
	{
		Result res = new Result();
		try {
			Notices notices = new Notices();
			notices.setNoticeMessage(name);
			notices.setId(id);
			noticesService.update(notices);
		} catch (Exception e) {
			res.setError(e);
		}
		return res;
	}
	
	@RequestMapping("/delete.do")
	@ResponseBody
	@Auditable(moduleName="系统通知管理", operationName="删除")
	public Result delete(@RequestParam Integer id)
	{
		Result res = new Result();
		try {
			noticesService.delete(id);
		} catch (Exception e) {
			res.setError(e);
		}
		return res;
	}
}
