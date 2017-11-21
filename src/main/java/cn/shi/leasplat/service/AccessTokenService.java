package cn.shi.leasplat.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shi.leasplat.entity.AccessToken;
import cn.shi.leasplat.entity.User;

public interface AccessTokenService {
	//创建token
	Integer saveAccessToken(AccessToken accessToken);
	//查询当前用户token个数
	Integer getCount(Integer userId);
	
	//删除当前用户登陆前拥有的所有token
	void deleteByUserId(Integer userId);
	
	Boolean check(User user, String token, HttpServletRequest request, HttpServletResponse response);
}
