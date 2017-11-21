package cn.shi.leasplat.service;


import java.util.List;

import cn.shi.leasplat.entity.Goods;
import cn.shi.leasplat.util.Page;

public interface GoodsService {
	
	/**
	 * 分页查商品
	 * 需要添加查询条件
	 * 1.商品类别查找
	 * 2.商品名称模糊查找
	 * 3.无条件时不添加条件查找
	 * @param pageNo
	 * @param pageSize
	 * @param name (商品名称或商品类别)
	 * @return
	 */
	Page<Goods> findPage(Integer pageNo, Integer pageSize, String name);
	
	Integer getCount(String name);
	
	Integer save(Goods goods);
	
	Integer update(Goods goods);
	
	Integer delete(Integer id);
	
	Goods getById(Integer id);
	
	Integer getId();
	
	Integer getMyGoodsCount(Integer userId);
	
	List<Goods> findMyGoods(Integer userId);
	
	List<Goods> findNewestGoods();
}
