package cn.shi.leasplat.entity;

import java.io.Serializable;
import java.sql.Date;

public class AccessToken implements Serializable {
	private Integer id;
	private Integer userId;
	private String token;
	private Date createTime =new Date(System.currentTimeMillis());
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "AccessToken [id=" + id + ", userId=" + userId + ", token=" + token + ", createTime=" + createTime + "]";
	}
	
}
