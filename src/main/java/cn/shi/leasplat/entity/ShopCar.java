package cn.shi.leasplat.entity;

import java.io.Serializable;

public class ShopCar implements Serializable{
	private Integer id;
	private Integer userId;
	private Integer goodsId;
	private Integer isDelete = 0;
	private Integer numberOfDays = 1;
	
	
	// 不加入数据库中的数据
	public Integer goodsImageId;
	public Goods goods;
	
	
	public Integer getGoodsImageId() {
		return goodsImageId;
	}
	public void setGoodsImageId(Integer goodsImageId) {
		this.goodsImageId = goodsImageId;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Integer getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(Integer numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
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
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	@Override
	public String toString() {
		return "ShopCar [id=" + id + ", userId=" + userId + ", goodsId=" + goodsId + ", isDelete=" + isDelete + "]";
	}
	
	
}
