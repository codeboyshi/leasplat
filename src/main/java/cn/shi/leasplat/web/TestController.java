package cn.shi.leasplat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController extends BaseController{
	
	@RequestMapping("/test.do")
	public String test(Long userId)
	{
		return "/html/websocket";
	}
}
