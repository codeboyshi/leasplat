package cn.shi.leasplat.dao;

import cn.shi.leasplat.entity.AccessToken;

public interface AccessTokenDao {
	//创建token
	public Integer saveToken(AccessToken accesstoken);
	
	//查询当前用户是否有token存在
	public Integer getCount(Integer userId);
	
	public void deleteByUserId(Integer userId);
	
	public AccessToken getByUserId(Integer userId);
}
