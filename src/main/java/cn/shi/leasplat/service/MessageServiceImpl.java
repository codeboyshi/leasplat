package cn.shi.leasplat.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.shi.leasplat.dao.MessageDao;
import cn.shi.leasplat.entity.Message;
import cn.shi.leasplat.util.Page;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Resource
	private MessageDao messageDao;
	/**
	 * ´´½¨ÁôÑÔ
	 */
	public Integer save(Message message){
		if(message.getUserId() == null) throw new NameOrPasswordException("ÇëÏÈµÇÂ¼£¡");
		return messageDao.save(message);
	}
	/**
	 * °´ÕÕidÉ¾³ıÁôÑÔ
	 */
	public void deleteById(Integer id) {
		messageDao.deleteById(id);
	}
	/**
	 * É¾³ıÈ«²¿ÁôÑÔ
	 */
	public void deleteAll() {
		messageDao.deleteAll();
	}
	/**
	 * ·ÖÒ³²éÑ¯ÁôÑÔ
	 */
	public Page<Message> findPage(Integer pageNo, Integer pageSize) {
		Page<Message> page = new Page<Message>(pageNo, pageSize);
		List<Message> list = messageDao.findPage(page.getLimit(), page.getOffset());
		Integer count = messageDao.getCount();
		page.setTotalCount(count);
		page.setResult(list);
		return page;
	}
}
