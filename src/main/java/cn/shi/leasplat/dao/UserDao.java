package cn.shi.leasplat.dao;

import java.util.List;

import cn.shi.leasplat.entity.User;
/**
 * 封装用户User对象的CRUD方法
 * MapperScanner 会扫描这个接口,自动为接口创建
 * 实现类,  并且实例化接口的子类Bean对象
 */
public interface UserDao {
	/*
	 * id查询
	 */
	public User findUserById(int userId); 
	/*
	 * 用户注册方法
	 */
	public Integer saveUser(User user);
	/**
	 * 名字查询
	 */
	public User findUserByName(String userName);
	/**
	 * 更新操作
	 * @return 
	 */
	public Integer updateUser(User user);
	
	public Integer updatePwd(String password,String userName);
	
	// 完善用户信息
	public Integer info(User user);
	
	// 所有用户信息显示
	public List<User> findPage(Integer limit, Integer offset, String userName);
	
	public Integer getCount(String userName);
	
	public void delete(Integer userId);
	
	public Integer getCountByYear(Integer year);
}
