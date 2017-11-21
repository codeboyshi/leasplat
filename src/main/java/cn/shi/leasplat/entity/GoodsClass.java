package cn.shi.leasplat.entity;

import java.io.Serializable;
import java.util.Date;

public class GoodsClass implements Serializable{
	private Integer id;
	private String name;		//商品类别名称
	private Date createTime = new Date();
	private Integer isDelete = 0;
	
	public GoodsClass(){}
	
	public GoodsClass(String name)
	{
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "GoodsClass [id=" + id + ", name=" + name + ", createTime=" + createTime + ", isDelete=" + isDelete
				+ "]";
	}
	
}
