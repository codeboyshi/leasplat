package cn.shi.leasplat.service;

import java.util.List;

import cn.shi.leasplat.entity.Message;
import cn.shi.leasplat.util.Page;

public interface MessageService {
		//保存留言
		Integer save(Message message);
		//按照id删除留言
		void deleteById(Integer id);
		//删除全部留言
		void deleteAll();
		//分页查找留言，显示的是倒序输出的
		Page<Message> findPage(Integer pageNo,Integer pageSize);
}
