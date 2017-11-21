package cn.shi.leasplat.service;

import java.util.List;

import cn.shi.leasplat.entity.Notices;
import cn.shi.leasplat.util.Page;

public interface NoticesService {
	
	public List<Notices> findList();
	
	public Page<Notices> findPage(Integer pageNo, Integer pageSize, String name);
	
	public Integer update(Notices notices);
	
	public Integer save(Notices notices);
	
	public Notices getById(Integer id);
	
	public void delete(Integer id);
}
