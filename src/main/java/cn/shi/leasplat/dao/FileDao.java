package cn.shi.leasplat.dao;

import cn.shi.leasplat.entity.File;

public interface FileDao {
	public Integer save(File file);
	public File getById(Integer id);
	public Integer getId();
}
