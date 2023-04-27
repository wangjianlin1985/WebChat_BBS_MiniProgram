package com.wfuhui.modules.bbs.dao;

import com.wfuhui.modules.bbs.entity.TopicEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 主贴
 * 
 * @author lizhengle
 * @email xxxxx@qq.com
 */
@Mapper
public interface TopicDao extends BaseDao<TopicEntity> {

	List<Map<String, String>> queryTopicCount();
	
}
