package com.wfuhui.modules.bbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.bbs.dao.TopicPicDao;
import com.wfuhui.modules.bbs.entity.TopicPicEntity;
import com.wfuhui.modules.bbs.service.TopicPicService;

@Service("topicPicService")
public class TopicPicServiceImpl implements TopicPicService {
	@Autowired
	private TopicPicDao topicPicDao;
	
	@Override
	public TopicPicEntity queryObject(Integer id){
		return topicPicDao.queryObject(id);
	}
	
	@Override
	public List<TopicPicEntity> queryList(Map<String, Object> map){
		return topicPicDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return topicPicDao.queryTotal(map);
	}
	
	@Override
	public void save(TopicPicEntity topicPic){
		topicPicDao.save(topicPic);
	}
	
	@Override
	public void update(TopicPicEntity topicPic){
		topicPicDao.update(topicPic);
	}
	
	@Override
	public void delete(Integer id){
		topicPicDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		topicPicDao.deleteBatch(ids);
	}
	
}
