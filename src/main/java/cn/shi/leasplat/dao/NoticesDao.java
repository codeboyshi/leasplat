package cn.shi.leasplat.dao;

import java.util.List;

import cn.shi.leasplat.entity.Notices;

public interface NoticesDao {
	
	public List<Notices> findList();
	
	public List<Notices> findPage(Integer limit, Integer offset, String name);
	
	public Integer getCount(String name);
	
	public Integer update(Notices notices);
	
	public Integer save(Notices notices);
	
	public Notices getById(Integer id);
	
	public void delete(Integer id);
}
