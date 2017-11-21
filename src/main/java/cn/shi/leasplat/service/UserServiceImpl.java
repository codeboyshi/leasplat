package cn.shi.leasplat.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import cn.shi.leasplat.dao.UserDao;
import cn.shi.leasplat.entity.User;
import cn.shi.leasplat.util.MD5;
import cn.shi.leasplat.util.Page;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource(name="userDao")  //注入的组件ID是 userDao
	private UserDao userDao;
	/**
	 * 用户登录检测方法
	 */
	public User login(String name,String pwd,String checkCode,HttpServletRequest req){
		if(name==null || name == "" || pwd == null || pwd == "" || checkCode =="" || checkCode == null) throw new NameOrPasswordException("用户名或密码、验证码不能为空");
		if(!name.matches("\\w{5,16}") || name.length()<5 || name.length()>16) throw new NameOrPasswordException("账号由6-16位字母数字下划线组成");
		if(!pwd.matches("\\w{5,16}") || pwd.length()<5 || pwd.length()>16) throw new NameOrPasswordException("密码由6-16位字母数字下划线组成");
		User user=null;
		user=userDao.findUserByName(name);
		if(user==null){
			System.out.println("用户不存在");
			throw new NameOrPasswordException("用户不存在");
		}
		if(!checkCode.equals(req.getSession().getAttribute("checkCode"))) {
			throw new NameOrPasswordException("验证码错误");
		}
		String checkPass = MD5.encode(pwd +"石强太帅了");
        if(!checkPass.equals(user.getPassword())) 
        {
        	System.out.println("密码不正确");
        	throw new NameOrPasswordException("密码不正确");
        }
		return user;
	}
	//注册
	public Integer saveUser(User user,String repassword) {
		if(user.getUserName() == null ) throw new NameOrPasswordException("账号不能为空");
		if(user.getPassword() == null || repassword == null|| user.getPassword() == "" || repassword == ""){
			throw new NameOrPasswordException("密码和确认密码不能为空");
		}
		if(!user.getPassword().equals(repassword))
		{  
			throw new NameOrPasswordException("密码与确认密码不同");
		}
		if(!user.getUserName().matches("\\w{5,16}") || user.getUserName().length()<5 || user.getUserName().length()>16) throw new NameOrPasswordException("账号由5-16位字母数字下划线组成");
		if(!user.getPassword().matches("\\w{5,16}") || user.getPassword().length()<5 || user.getPassword().length()>16) throw new NameOrPasswordException("密码由5-16位字母数字下划线组成");
		User userCheck = findUserByName(user.getUserName());
		if(userCheck != null) throw new NameOrPasswordException("此用户名已存在！！");
		user.setPassword(MD5.encode(user.getPassword()+"石强太帅了"));
		return userDao.saveUser(user);
	}
	public Integer updateUser(User user) {
		
		return userDao.updateUser(user);
	}
	
	/**
	 * 按照userName查找用户（忘记密码使用）
	 * @return 密保问题
	 */
	public User findUserByName(String userName) {
		return userDao.findUserByName(userName);
	}
	
	/**
	 * 修改密码
	 */
	public Integer updatePwd(String password,String userName) {
		if(!password.matches("\\w{5,16}") || password.length()<5 || password.length()>16) throw new NameOrPasswordException("密码由6-16位字母数字下划线组成");
		password = MD5.encode(password+"石强太帅了");
		return userDao.updatePwd(password,userName);
	}
	
	public User findUserById(Integer id) {
		return userDao.findUserById(id);
	}
	
	public Integer info(User user) {
		return userDao.info(user);
	}
	public Page<User> findPage(Integer pageNo, Integer pageSize, String userName) {
		Page<User> page = new Page<User>(pageNo, pageSize);
		List<User> list = userDao.findPage(page.getLimit(), page.getOffset(), userName);
		Integer count = userDao.getCount(userName);
		page.setTotalCount(count);
		page.setResult(list);
		return page;
	}
	public void delete(Integer userId) {
		userDao.delete(userId);
	}
	public Map<String, List<Integer>> findCountByYear() {
		Date date = new Date();
		Integer year = date.getYear() + 1900;
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		List<Integer> yearCount = new ArrayList<Integer>();
		List<Integer> years = new ArrayList<Integer>();
		for (int i = year - 4;i <= year;i++)
		{
			Integer count = userDao.getCountByYear(i);
			yearCount.add(count);
			years.add(i);
		}
		map.put("years", years);
		map.put("yearCount", yearCount);
		return map;
	}
	
}
