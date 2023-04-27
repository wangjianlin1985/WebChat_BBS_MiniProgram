package com.wfuhui.modules.bbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wfuhui.modules.bbs.dao.ReplyDao;
import com.wfuhui.modules.bbs.dao.TopicDao;
import com.wfuhui.modules.bbs.dao.TopicPicDao;
import com.wfuhui.modules.bbs.entity.ReplyEntity;
import com.wfuhui.modules.bbs.entity.TopicEntity;
import com.wfuhui.modules.bbs.entity.TopicPicEntity;
import com.wfuhui.modules.bbs.service.TopicService;

@Service("topicService")
public class TopicServiceImpl implements TopicService {
	@Autowired
	private TopicDao topicDao;
	@Autowired
	private ReplyDao replyDao;
	@Autowired
	private TopicPicDao topicPicDao;
	
	@Override
	public TopicEntity queryObject(Integer id){
		TopicEntity topic = topicDao.queryObject(id);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("topicId", id);
		List<ReplyEntity> replyList = replyDao.queryList(params);
		topic.setReplyList(replyList);
		return topic;
	}
	
	@Override
	public List<TopicEntity> queryList(Map<String, Object> map){
		return topicDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return topicDao.queryTotal(map);
	}
	
	@Override
	public void save(TopicEntity topic){
		topicDao.save(topic);
		if (topic.getPicUrls() != null) {
			String[] picUrls = topic.getPicUrls();
			for (String picUrl : picUrls) {
				TopicPicEntity topicPic = new TopicPicEntity();
				topicPic.setTopicId(topic.getId());
				topicPic.setPicUrl(picUrl);
				topicPicDao.save(topicPic);
			}
		}
	}
	
	@Override
	public void update(TopicEntity topic){
		topicDao.update(topic);
	}
	
	@Override
	public void delete(Integer id){
		topicDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		topicDao.deleteBatch(ids);
	}

	@Override
	public List<Map<String, String>> queryTopicCount() {
		return topicDao.queryTopicCount();
	}
	
}
