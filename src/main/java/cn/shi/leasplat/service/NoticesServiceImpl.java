package cn.shi.leasplat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.shi.leasplat.dao.NoticesDao;
import cn.shi.leasplat.entity.Notices;
import cn.shi.leasplat.util.Page;
@Service("noticesService")
public class NoticesServiceImpl implements NoticesService{

	@Autowired
	private NoticesDao noticesDao;
	
	public List<Notices> findList() {
		return noticesDao.findList();
	}

	public Page<Notices> findPage(Integer pageNo, Integer pageSize, String name) {
		Page<Notices> page = new Page<Notices>(pageNo, pageSize);
		List<Notices> list = noticesDao.findPage(page.getLimit(), page.getOffset(), name);
		Integer count = noticesDao.getCount(name);
		page.setTotalCount(count);
		page.setResult(list);
		return page;
	}

	public Integer update(Notices notices) {
		return noticesDao.update(notices);
	}

	public Integer save(Notices notices) {
		return noticesDao.save(notices);
	}

	public Notices getById(Integer id) {
		return noticesDao.getById(id);
	}

	public void delete(Integer id) {
		noticesDao.delete(id);
	}

}
