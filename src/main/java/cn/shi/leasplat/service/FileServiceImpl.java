package cn.shi.leasplat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.shi.leasplat.dao.FileDao;
import cn.shi.leasplat.entity.File;
@Service(value = "fileService")
public class FileServiceImpl implements FileService{

	@Autowired
	private FileDao fileDao;
	
	public Integer save(File file) {
		return fileDao.save(file);
	}

	public File getById(Integer id) {
		return fileDao.getById(id);
	}

	public Integer getId() {
		return fileDao.getId();
	}

	
}
