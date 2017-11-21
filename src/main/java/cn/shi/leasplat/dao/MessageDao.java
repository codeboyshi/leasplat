package cn.shi.leasplat.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.shi.leasplat.entity.Message;
@Repository
public interface MessageDao {

	/**
	 * 创建一条留言
	 * @param message
	 * @return
	 */
	Integer save(Message message);
	
	/**
	 * 分页查找留言
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Message> findPage(Integer limit,Integer offset);
	/**
	 * 按照id删除一条留言
	 * @param id
	 */
	void deleteById(Integer id);
	/**
	 * 删除全部留言
	 */
	void deleteAll();
	/**
	 * 获取留言个数
	 * @return
	 */
	Integer getCount();
}
