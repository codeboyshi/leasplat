package cn.shi.leasplat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.shi.leasplat.dao.ShopCarDao;
import cn.shi.leasplat.entity.ShopCar;
@Service("shopCarService")
public class ShopCarServiceImpl implements ShopCarService{

	@Autowired
	private ShopCarDao shopCarDao;
	
	public Integer save(ShopCar shopCar) {
		
		return shopCarDao.save(shopCar);
	}

	public Integer getMyGoodsCount(Integer userId) {
		return shopCarDao.getMyGoodsCount(userId);
	}

	public List<ShopCar> findByUserId(Integer userId) {
		return shopCarDao.findByUserId(userId);
	}

	public void delete(Integer id) {
		shopCarDao.delete(id);
	}

	public Integer update(Integer day, Integer id) {
		return shopCarDao.update(day, id);
	}
	
	

}
