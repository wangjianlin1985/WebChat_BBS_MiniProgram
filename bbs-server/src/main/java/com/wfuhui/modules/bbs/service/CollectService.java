package com.wfuhui.modules.bbs.service;

import com.wfuhui.modules.bbs.entity.CollectEntity;

import java.util.List;
import java.util.Map;

/**
 * 收藏
 * 
 * @author lizhengle
 * @email xxxxx@qq.com
 */
public interface CollectService {
	
	CollectEntity queryObject(Integer id);
	
	List<CollectEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CollectEntity collect);
	
	void update(CollectEntity collect);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	void remove(Integer topicId, Long userId);
}
