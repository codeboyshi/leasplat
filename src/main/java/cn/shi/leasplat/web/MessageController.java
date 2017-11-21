package cn.shi.leasplat.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.shi.leasplat.annotation.Auditable;
import cn.shi.leasplat.entity.Message;
import cn.shi.leasplat.entity.User;
import cn.shi.leasplat.service.MessageService;
import cn.shi.leasplat.service.UserService;
import cn.shi.leasplat.util.Page;
import cn.shi.leasplat.util.Result;

@Controller
@RequestMapping("/message")
/**
 * 留言板控制器
 * @author Administrator
 *
 */
public class MessageController {
	
	@Resource
	private MessageService messageService;
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/about.do")
	public String toMessage(Model model){
		return "/html/about-us";
	}
	
	@RequestMapping("/select.do")
	@ResponseBody
	public Result findPage(@RequestParam Integer pageNo,
						   @RequestParam Integer pageSize){
		Result res = new Result();
		try {
			Page<Message> pages = messageService.findPage(pageNo, pageSize);
			List<String> list = new ArrayList<String>();
			for(int i=0; i < pages.getResult().size();i++){
//				System.out.println(pages.getResult().get(i));
				User user = userService.findUserById(pages.getResult().get(i).getUserId());
				list.add(user.getUserName());
			}
			List li = new ArrayList();
			li.add(pages);
			li.add(list);
			res.setData(li);
		} catch (Exception e) {
			e.printStackTrace();
			res.getError().setCode(0);
			res.getError().setReason("系统失败");
		}
		return res;
	}
	
	@RequestMapping("/save.do")
	@ResponseBody
	@Auditable(moduleName="留言板管理", operationName="添加")
	public Result save(Message message,HttpServletRequest request){
		Result res = new Result();
		try {
			Cookie cooks[] = request.getCookies();
			//TODO:暂时通过cookie数量进行判断
			if(cooks == null || cooks.length <= 1)
			{
				res.getError().setCode(0);
				res.getError().setReason("请先到首页进行登录");
				return res;
			}
			if(cooks != null)
			for(int i = 0;i < cooks.length;i++){
				if("userId".equals(cooks[i].getName())){
					message.setUserId(Integer.parseInt(cooks[i].getValue()));
				}
			}
			messageService.save(message);
		} catch (Exception e) {
			res.getError().setCode(0);
			res.setError(e);
		}
		return res;
	}
	
	@RequestMapping("/list.do")
	public String list()
	{
		return "/html/admin-msg";
	}
	
	@RequestMapping("/delete.do")
	@ResponseBody
	@Auditable(moduleName="留言板管理", operationName="删除")
	public Result delete(@RequestParam Integer id)
	{
		Result res = new Result();
		try {
			messageService.deleteById(id);
		} catch (Exception e) {
			res.setError(e);
		}
		return res;
	}
}
