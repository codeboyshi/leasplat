package cn.shi.leasplat.service;

import cn.shi.leasplat.entity.SystemLog;
import cn.shi.leasplat.util.Page;

/**
 * 
 * @author shiqiang
 *
 */
public interface SystemLogService {
	public Integer saveSystemLog(SystemLog systemLog);
	
	public Page<SystemLog> findPage(Integer pageNo, Integer pageSize);
}
