package cn.shi.leasplat.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 存储用户留言
 * @author Administrator(shiqiang)
 *
 */
public class Message implements Serializable {
	
	private Integer id;

	private Integer userId;
	
	private String message;		//用户留言
	
	private Date createTime = new Date();

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", userId=" + userId + ", message=" + message + ", createTime=" + createTime + "]";
	}
	
	
}
