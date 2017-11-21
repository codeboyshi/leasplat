package cn.shi.leasplat.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.shi.leasplat.service.UserService;
import cn.shi.leasplat.util.Result;

@Controller
@RequestMapping("count")
public class RegCountController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("reg.do")
	public String countView()
	{
		return "/html/statistics";
	}
	
	// 获取5年中每年的注册人数
	@RequestMapping("/regMsg.do")
	@ResponseBody
	public Result regCount()
	{
		Result res = new Result();
		try {
			Map<String, List<Integer>> map = userService.findCountByYear();
			res.setData(map);
		} catch (Exception e) {
			res.setError(e);
		}
		return res;
	}
	// 引入userService，查询五年的注册人数，先获取本年，然后减，统计出五个，然后分别查出，放在list里，
	//一个list装年份，另一个list装对应的年份的注册人数
	
}
