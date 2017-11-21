package cn.shi.leasplat.dao;

import java.util.List;

import cn.shi.leasplat.entity.ShopCar;

public interface ShopCarDao {
	
	Integer save(ShopCar shopCar);
	
	Integer getMyGoodsCount(Integer userId);
	
	List<ShopCar> findByUserId(Integer userId);
	
	void delete(Integer id);
	
	Integer update(Integer day, Integer id);
}
