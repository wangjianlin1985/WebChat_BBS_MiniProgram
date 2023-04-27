package com.wfuhui.modules.bbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.bbs.dao.ReplyDao;
import com.wfuhui.modules.bbs.entity.ReplyEntity;
import com.wfuhui.modules.bbs.service.ReplyService;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyDao replyDao;
	
	@Override
	public ReplyEntity queryObject(Integer id){
		return replyDao.queryObject(id);
	}
	
	@Override
	public List<ReplyEntity> queryList(Map<String, Object> map){
		return replyDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return replyDao.queryTotal(map);
	}
	
	@Override
	public void save(ReplyEntity reply){
		replyDao.save(reply);
	}
	
	@Override
	public void update(ReplyEntity reply){
		replyDao.update(reply);
	}
	
	@Override
	public void delete(Integer id){
		replyDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		replyDao.deleteBatch(ids);
	}
	
}
