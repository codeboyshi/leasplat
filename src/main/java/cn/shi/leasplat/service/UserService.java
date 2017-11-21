package cn.shi.leasplat.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.shi.leasplat.entity.Goods;
import cn.shi.leasplat.entity.User;
import cn.shi.leasplat.util.Page;

/**
 * 服务接口
 */
public interface UserService {
	/**
	 * 封装登录逻辑
	 * 如果登录成功就返回登录的成功的用户信息
	 * 否则登录失败就抛出异常
	 * @param name 用户名
	 * @param password 密码
	 * @return 登录成功的用户信息
	 * @throws NameOrPasswordException 登录失败
	 */
	User login(String name, String password,String checkCode,HttpServletRequest req);
	
	Integer saveUser(User user,String repassword);
	
	Integer updateUser(User user);
	
	User findUserByName(String userName);
	
	Integer updatePwd(String password,String userName);
	
	User findUserById(Integer id);
	
	Integer info(User user);
	
	Page<User> findPage(Integer pageNo, Integer pageSize, String userName);
	
	void delete(Integer userId);
	
	Map<String,List<Integer>> findCountByYear();
}
