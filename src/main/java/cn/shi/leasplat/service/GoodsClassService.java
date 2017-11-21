package cn.shi.leasplat.service;

import java.util.List;

import cn.shi.leasplat.entity.GoodsClass;
import cn.shi.leasplat.util.Page;

public interface GoodsClassService {
	public List<GoodsClass> findAll();
	
	public Integer save(GoodsClass goodsClass);
	
	public Integer update(GoodsClass goodsClass);
	
	public Integer delete(Integer id);
	
	public GoodsClass getById(Integer id);
	
	public Page<GoodsClass> findPage(Integer pageNo, Integer pageSize, String name);

}
