package cn.shi.leasplat.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Goods implements Serializable{
	private Integer id;
	
	private String name;						//商品名称
	
	private BigDecimal price;					//商品价格（例如：5元/天）
	
	private Integer userId;						//用户id
	
//	private Integer goodsImageId;				//商品图片id
	
	private Integer basicUnit;					//商品基础单位（0：天，1：月，2：年）
	
	private Integer goodsClassId;				//商品类别id
	
	private Date createTime = new Date();		//创建时间
	
	private Integer isDelete = 0; 				//是否删除
	
	private String goodsMessage;
	
	
	// 不存入数据库中的属性，主要目的是显示
	private String goodsClassName;				// 商品类别名称
	private User user;					//用户名
	private List<GoodsImage> imagePath;			//图片路径
	private Integer imageId;					// 其中一个商品的id
	
	
	
	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getGoodsMessage() {
		return goodsMessage;
	}

	public void setGoodsMessage(String goodsMessage) {
		this.goodsMessage = goodsMessage;
	}

	public String getGoodsClassName() {
		return goodsClassName;
	}

	public void setGoodsClassName(String goodsClassName) {
		this.goodsClassName = goodsClassName;
	}

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<GoodsImage> getImagePath() {
		return imagePath;
	}

	public void setImagePath(List<GoodsImage> imagePath) {
		this.imagePath = imagePath;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

//	public Integer getGoodsImageId() {
//		return goodsImageId;
//	}
//
//	public void setGoodsImageId(Integer goodsImageId) {
//		this.goodsImageId = goodsImageId;
//	}

	public Integer getBasicUnit() {
		return basicUnit;
	}

	public void setBasicUnit(Integer basicUnit) {
		this.basicUnit = basicUnit;
	}

	public Integer getGoodsClassId() {
		return goodsClassId;
	}

	public void setGoodsClassId(Integer goodsClassId) {
		this.goodsClassId = goodsClassId;
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
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", userId=" + userId + ", basicUnit="
				+ basicUnit + ", goodsClassId=" + goodsClassId + ", createTime=" + createTime + ", isDelete=" + isDelete
				+ ", goodsMessage=" + goodsMessage + ", goodsClassName=" + goodsClassName + ", user=" + user
				+ ", imagePath=" + imagePath + "]";
	}

	
}
