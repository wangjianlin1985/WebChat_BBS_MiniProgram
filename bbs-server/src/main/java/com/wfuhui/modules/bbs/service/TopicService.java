package com.wfuhui.modules.bbs.service;

import com.wfuhui.modules.bbs.entity.TopicEntity;

import java.util.List;
import java.util.Map;

/**
 * 主贴
 * 
 * @author lizhengle
 * @email xxxxx@qq.com
 * @date 2020-03-11 11:45:26
 */
public interface TopicService {
	
	TopicEntity queryObject(Integer id);
	
	List<TopicEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TopicEntity topic);
	
	void update(TopicEntity topic);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	List<Map<String, String>> queryTopicCount();
}
