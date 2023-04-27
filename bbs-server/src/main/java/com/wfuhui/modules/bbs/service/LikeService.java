package com.wfuhui.modules.bbs.service;

import com.wfuhui.modules.bbs.entity.LikeEntity;
import com.wfuhui.modules.bbs.entity.TopicEntity;

import java.util.List;
import java.util.Map;

/**
 * 点赞
 * 
 * @author lizhengle
 * @email xxxxx@qq.com
 * @date 2020-03-11 11:45:26
 */
public interface LikeService {
	
	LikeEntity queryObject(Integer id);
	
	List<LikeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(LikeEntity like);
	
	void update(LikeEntity like);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	void remove(Integer topicId, Long userId);

	List<TopicEntity> queryLike(Long userId);
}
