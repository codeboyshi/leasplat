package cn.shi.leasplat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.shi.leasplat.dao.GoodsClassDao;
import cn.shi.leasplat.entity.GoodsClass;
import cn.shi.leasplat.util.Page;

@Service(value="goodsClassService")
public class GoodsClassServiceImpl implements GoodsClassService{

	@Autowired
	private GoodsClassDao goodsClassDao;

	public List<GoodsClass> findAll() {
		return goodsClassDao.findAll();
	}

	public Integer save(GoodsClass goodsClass) {
		return goodsClassDao.save(goodsClass);
	}

	public Integer update(GoodsClass goodsClass) {
		return goodsClassDao.update(goodsClass);
	}

	public Integer delete(Integer id) {
		return goodsClassDao.delete(id);
	}

	public GoodsClass getById(Integer id) {
		return goodsClassDao.getById(id);
	}

	public Page<GoodsClass> findPage(Integer pageNo, Integer pageSize, String name) {
		Page<GoodsClass> page = new Page<GoodsClass>(pageNo, pageSize);
		List<GoodsClass> list = goodsClassDao.findPage(page.getLimit(), page.getOffset(), name);
		Integer count = goodsClassDao.getCount(name);
		page.setTotalCount(count);
		page.setResult(list);
		return page;
	}
}
