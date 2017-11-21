package cn.shi.leasplat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.shi.leasplat.dao.SystemLogDAO;
import cn.shi.leasplat.dao.UserDao;
import cn.shi.leasplat.entity.SystemLog;
import cn.shi.leasplat.entity.User;
import cn.shi.leasplat.util.Page;


/**
 * 
 * @author shiqiang
 *
 */
@Service("systemLogService")
public class SystemLogServiceImpl implements SystemLogService{

	@Autowired
	private SystemLogDAO systemLogDAO;
	
	@Autowired
	private UserDao userDao;
	
	public Integer saveSystemLog(SystemLog log) {
		return systemLogDAO.saveSystemLog(log);
	}

	public Page<SystemLog> findPage(Integer pageNo, Integer pageSize) {
		Page<SystemLog> page = new Page<SystemLog>(pageNo, pageSize);
		List<SystemLog> logs = systemLogDAO.findPage(page.getLimit(), page.getOffset());
		Integer count = systemLogDAO.getCount();
		for (SystemLog log : logs)
		{
			User user = userDao.findUserById(log.getUserId());
			user.setPassword("");
			user.setSecretAnswer("");
			user.setSecurity("");
			log.setUser(user);
		}
		page.setTotalCount(count);
		page.setResult(logs);
		return page;
	}

}
