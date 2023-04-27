package com.wfuhui.modules.bbs.service;

import com.wfuhui.modules.bbs.entity.TopicPicEntity;

import java.util.List;
import java.util.Map;

/**
 * 主贴图片
 * 
 * @author lizhengle
 * @email xxxxx@qq.com
 * @date 2020-03-11 11:45:26
 */
public interface TopicPicService {
	
	TopicPicEntity queryObject(Integer id);
	
	List<TopicPicEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TopicPicEntity topicPic);
	
	void update(TopicPicEntity topicPic);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
