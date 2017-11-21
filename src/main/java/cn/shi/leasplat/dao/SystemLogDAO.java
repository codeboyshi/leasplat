package cn.shi.leasplat.dao;

import java.util.List;

import cn.shi.leasplat.entity.SystemLog;

public interface SystemLogDAO {
	// 添加系统日志，后期需要完善，暂时是测试
	public Integer saveSystemLog(SystemLog log);
	
	// 分页显示
	public List<SystemLog> findPage(Integer limit, Integer offset);
	
	// 总数
	public Integer getCount();
}
