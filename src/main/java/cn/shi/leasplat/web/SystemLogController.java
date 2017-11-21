package cn.shi.leasplat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.shi.leasplat.entity.SystemLog;
import cn.shi.leasplat.service.SystemLogService;
import cn.shi.leasplat.util.Page;
import cn.shi.leasplat.util.Result;

@Controller
@RequestMapping("/log")
public class SystemLogController {
	
	@Autowired
	private SystemLogService systemLogService;
	
	@RequestMapping("/list.do")
	public String logList()
	{
		return "/html/log";
	}
	
	@RequestMapping("/select.do")
	@ResponseBody
	public Result selectList(@RequestParam Integer pageNo,
							 @RequestParam Integer pageSize)
	{
		Result res = new Result();
		try {
			Page<SystemLog> page = systemLogService.findPage(pageNo, pageSize);
			res.setData(page);
		} catch (Exception e) {
			res.setError(e);
		}
		return res;
	}
}
