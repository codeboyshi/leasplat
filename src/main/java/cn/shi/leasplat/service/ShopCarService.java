package cn.shi.leasplat.service;

import java.util.List;

import cn.shi.leasplat.entity.ShopCar;

public interface ShopCarService {
	
	Integer save(ShopCar shopCar);
	
	Integer getMyGoodsCount(Integer userId);
	
	List<ShopCar> findByUserId(Integer userId);
	
	void delete(Integer id);
	
	Integer update(Integer day, Integer id);
}
