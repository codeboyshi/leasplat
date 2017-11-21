package cn.shi.leasplat.dao;

import java.util.List;

import cn.shi.leasplat.entity.GoodsImage;

public interface GoodsImageDao {
	
	List<GoodsImage> findByGoodsId(Integer goodsId);
	
	void delete(Integer id);
	
	Integer update(GoodsImage goodsImage);
	
	Integer save(GoodsImage goodsImage);
	
	GoodsImage getByGoodsId(Integer goodsId);
	
	GoodsImage getById(Integer id);
	
	void deleteByGoodsId(Integer goodsId);
}
