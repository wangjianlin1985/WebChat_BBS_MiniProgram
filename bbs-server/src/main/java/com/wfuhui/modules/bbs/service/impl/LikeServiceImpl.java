package com.wfuhui.modules.bbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.bbs.dao.LikeDao;
import com.wfuhui.modules.bbs.entity.LikeEntity;
import com.wfuhui.modules.bbs.entity.TopicEntity;
import com.wfuhui.modules.bbs.service.LikeService;

@Service("likeService")
public class LikeServiceImpl implements LikeService {
	@Autowired
	private LikeDao likeDao;
	
	@Override
	public LikeEntity queryObject(Integer id){
		return likeDao.queryObject(id);
	}
	
	@Override
	public List<LikeEntity> queryList(Map<String, Object> map){
		return likeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return likeDao.queryTotal(map);
	}
	
	@Override
	public void save(LikeEntity like){
		likeDao.save(like);
	}
	
	@Override
	public void update(LikeEntity like){
		likeDao.update(like);
	}
	
	@Override
	public void delete(Integer id){
		likeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		likeDao.deleteBatch(ids);
	}

	@Override
	public void remove(Integer topicId, Long userId) {
		likeDao.remove(topicId, userId);
		
	}

	@Override
	public List<TopicEntity> queryLike(Long userId) {
		return likeDao.queryLike(userId);
	}
	
}
