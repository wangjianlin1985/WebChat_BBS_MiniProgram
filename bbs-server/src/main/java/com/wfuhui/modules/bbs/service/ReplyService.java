package com.wfuhui.modules.bbs.service;

import com.wfuhui.modules.bbs.entity.ReplyEntity;

import java.util.List;
import java.util.Map;

/**
 * 回复
 * 
 * @author lizhengle
 * @email xxxxx@qq.com
 * @date 2020-03-11 11:45:26
 */
public interface ReplyService {
	
	ReplyEntity queryObject(Integer id);
	
	List<ReplyEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ReplyEntity reply);
	
	void update(ReplyEntity reply);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
