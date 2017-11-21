package cn.shi.leasplat.entity;

import java.io.Serializable;
import java.util.Date;

public class Notices implements Serializable{
	private Integer id;
	private String noticeMessage;
	private Date createDate = new Date();
	private Integer isDelete = 0;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNoticeMessage() {
		return noticeMessage;
	}
	public void setNoticeMessage(String noticeMessage) {
		this.noticeMessage = noticeMessage;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "Notices [id=" + id + ", noticeMessage=" + noticeMessage + ", createDate=" + createDate + ", isDelete="
				+ isDelete + "]";
	}
	

}
