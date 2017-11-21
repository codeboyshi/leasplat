package cn.shi.leasplat.entity;

import java.io.Serializable;

public class GoodsImage implements Serializable{
	private Integer id;
	private Integer goodsId;		// 商品id
	private String path;			// 商品图片路径
	
	public GoodsImage(){}
	
	public GoodsImage(Integer goodsId, String path)
	{
		this.goodsId = goodsId;
		this.path = path;
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getGoodsId() {
		return goodsId;
	}


	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	@Override
	public String toString() {
		return "GoodsImage [id=" + id + ", goodsId=" + goodsId + ", path=" + path + "]";
	}
	
	
}
