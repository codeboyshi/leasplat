package cn.shi.leasplat.service;

import cn.shi.leasplat.entity.File;

public interface FileService {
	
	Integer save(File file);
	File getById(Integer id);
	Integer getId();
}
