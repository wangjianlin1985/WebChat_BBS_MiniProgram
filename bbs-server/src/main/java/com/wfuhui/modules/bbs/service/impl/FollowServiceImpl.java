package com.wfuhui.modules.bbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.bbs.dao.FollowDao;
import com.wfuhui.modules.bbs.entity.FollowEntity;
import com.wfuhui.modules.bbs.service.FollowService;



@Service("followService")
public class FollowServiceImpl implements FollowService {
	@Autowired
	private FollowDao followDao;
	
	@Override
	public FollowEntity queryObject(Integer id){
		return followDao.queryObject(id);
	}
	
	@Override
	public List<FollowEntity> queryList(Map<String, Object> map){
		return followDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return followDao.queryTotal(map);
	}
	
	@Override
	public void save(FollowEntity follow){
		followDao.save(follow);
	}
	
	@Override
	public void update(FollowEntity follow){
		followDao.update(follow);
	}
	
	@Override
	public void delete(Integer id){
		followDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		followDao.deleteBatch(ids);
	}

	@Override
	public void remove(Long memberId, Long userId) {
		// TODO Auto-generated method stub
		followDao.remove(memberId, userId);
	}
	
}
