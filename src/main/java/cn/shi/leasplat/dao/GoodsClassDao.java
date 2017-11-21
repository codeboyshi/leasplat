package cn.shi.leasplat.dao;

import java.util.List;

import cn.shi.leasplat.entity.GoodsClass;

public interface GoodsClassDao {
	public List<GoodsClass> findAll();
	
	public Integer save(GoodsClass goodsClass);
	
	public Integer update(GoodsClass goodsClass);
	
	public Integer delete(Integer id);
	
	public GoodsClass getById(Integer id);
	
	public List<GoodsClass> findPage(Integer limit, Integer offset, String name);
	
	public Integer getCount(String name);
}
