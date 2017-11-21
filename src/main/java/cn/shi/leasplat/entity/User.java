package cn.shi.leasplat.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private Integer userId;
	private String userName;	//账号
	private String password;	//密码
	private String userSex;		//性别
	private String phone;		//手机号
	private String security;	//密保
	private String secretAnswer;//密保答案
	private Integer isDelete = 0;//是否删除
	private Integer isAdmin = 0; //是否为管理员
	private Date createTime = new Date();	// 创建时间
	
	
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getIsAdmin() {
		return isAdmin;
	}

	public User setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
		return this;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}
	

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userSex=" + userSex
				+ ", phone=" + phone + ", security=" + security + ", secretAnswer=" + secretAnswer + ", isDelete="
				+ isDelete + ", isAdmin=" + isAdmin + "]";
	}

	
}
