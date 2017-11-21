package cn.shi.leasplat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.shi.leasplat.dao.GoodsImageDao;
import cn.shi.leasplat.entity.GoodsImage;

@Service(value="goodsImageService")
public class GoodsImageServiceImpl implements GoodsImageService{

	@Autowired
	private GoodsImageDao goodsImageDao;
	// TODO:此处可能会涉及到商品id转商品名称，使用时再做修改
	public List<GoodsImage> findByGoodsId(Integer goodsId) {
		return goodsImageDao.findByGoodsId(goodsId);
	}

	public void delete(Integer id) {
		goodsImageDao.delete(id);
	}

	public Integer update(GoodsImage goodsImage) {
		return goodsImageDao.update(goodsImage);
	}

	public Integer save(GoodsImage goodsImage) {
		return goodsImageDao.save(goodsImage);
	}

	public GoodsImage getByGoodsId(Integer goodsId) {
		return goodsImageDao.getByGoodsId(goodsId);
	}

	public GoodsImage getById(Integer id) {
		return goodsImageDao.getById(id);
	}

	public void deleteByGoodsId(Integer goodsId) {
		goodsImageDao.deleteByGoodsId(goodsId);
	}

}
