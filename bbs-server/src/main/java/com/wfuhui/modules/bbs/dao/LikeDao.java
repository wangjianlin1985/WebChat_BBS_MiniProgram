package com.wfuhui.modules.bbs.dao;

import com.wfuhui.modules.bbs.entity.LikeEntity;
import com.wfuhui.modules.bbs.entity.TopicEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 点赞
 * 
 * @author lizhengle
 * @email xxxxx@qq.com
 */
@Mapper
public interface LikeDao extends BaseDao<LikeEntity> {

	void remove(@Param("topicId") Integer topicId, @Param("userId") Long userId);

	List<TopicEntity> queryLike(Long userId);
	
}
