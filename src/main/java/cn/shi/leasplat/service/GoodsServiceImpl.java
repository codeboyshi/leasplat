package cn.shi.leasplat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.shi.leasplat.dao.GoodsClassDao;
import cn.shi.leasplat.dao.GoodsDao;
import cn.shi.leasplat.dao.GoodsImageDao;
import cn.shi.leasplat.dao.UserDao;
import cn.shi.leasplat.entity.Goods;
import cn.shi.leasplat.entity.GoodsClass;
import cn.shi.leasplat.entity.GoodsImage;
import cn.shi.leasplat.entity.User;
import cn.shi.leasplat.util.Page;

@Service(value = "goodsService")
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsDao goodsDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private GoodsImageDao goodsImageDao;
	
	@Autowired
	private GoodsClassDao goodsClassDao;
	
	
	public Page<Goods> findPage(Integer pageNo, Integer pageSize, String name) {
		Page<Goods> page = new Page<Goods>(pageNo, pageSize);
		List<Goods> list = goodsDao.findPage(page.getLimit(), page.getOffset(), name);
		for (Goods goods : list)
		{
			// 查出商品类别，将商品类别名称赋值
			GoodsClass goodsClass = goodsClassDao.getById( goods.getGoodsClassId() );
			if(goodsClass != null) goods.setGoodsClassName(goodsClass.getName());
			// 查出图片路径
			List<GoodsImage> goodsImages = goodsImageDao.findByGoodsId(goods.getId());
			if (goodsImages != null) goods.setImagePath(goodsImages);
			// 查出用户名
			User user = userDao.findUserById(goods.getUserId());
			if (user != null)
			{
				user.setPassword("");
				user.setSecretAnswer("");
				user.setSecurity("");
				goods.setUser(user);
			}
		}
		int count = goodsDao.getCount(name);
		page.setTotalCount(count);
		page.setResult(list);
		return page;
	}

	public Integer getCount(String name) {
		return goodsDao.getCount(name);
	}

	public Integer save(Goods goods) {
		return goodsDao.save(goods);
	}

	public Integer update(Goods goods) {
		return goodsDao.update(goods);
	}

	public Integer delete(Integer id) {
		return goodsDao.delete(id);
	}

	public Goods getById(Integer id) {
		return goodsDao.getById(id);
	}

	public Integer getId() {
		return goodsDao.getId();
	}

	public Integer getMyGoodsCount(Integer userId) {
		return goodsDao.getMyGoodsCount(userId);
	}

	public List<Goods> findMyGoods(Integer userId) {
		return goodsDao.findMyGoods(userId);
	}

	/**
	 * 首页最新的商品
	 */
	public List<Goods> findNewestGoods() {
		return goodsDao.findNewestGoods();
	}
	

}
