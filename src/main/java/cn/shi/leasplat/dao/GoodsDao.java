package cn.shi.leasplat.dao;

import java.util.List;

import cn.shi.leasplat.entity.Goods;

public interface GoodsDao {
	//查询分页---条件商品名或者类别名
	public List<Goods> findPage(Integer limit, Integer offset, String name);
	//获取总条数
	public Integer getCount(String name);
	//添加
	public Integer save(Goods goods);
	//修改
	public Integer update(Goods goods);
	//删除
	public Integer delete(Integer id);
	//查询一条数据
	public Goods getById(Integer id);
	
	// 获取商品id
	public Integer getId();
	
	// 获取当前用户上传的商品数量
	public Integer getMyGoodsCount(Integer userId);
	
	// 获取当前user_id的所有商品
	public List<Goods> findMyGoods(Integer userId);
	
	// 获取最新商品
	public List<Goods> findNewestGoods();
}
