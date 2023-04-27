package com.wfuhui.modules.bbs.service;

import com.wfuhui.modules.bbs.entity.FollowEntity;

import java.util.List;
import java.util.Map;

/**
 * 关注
 * 
 * @author lizhengle
 * @email xxxxx@qq.com
 */
public interface FollowService {
	
	FollowEntity queryObject(Integer id);
	
	List<FollowEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(FollowEntity follow);
	
	void update(FollowEntity follow);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	void remove(Long uId, Long userId);
}
