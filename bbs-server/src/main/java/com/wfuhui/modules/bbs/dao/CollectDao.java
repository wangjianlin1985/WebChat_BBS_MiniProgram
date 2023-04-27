package com.wfuhui.modules.bbs.dao;

import com.wfuhui.modules.bbs.entity.CollectEntity;
import com.wfuhui.modules.bbs.entity.TopicEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 收藏
 * 
 * @author lizhengle
 * @email xxxxx@qq.com
 */
@Mapper
public interface CollectDao extends BaseDao<CollectEntity> {
	void remove(@Param("topicId") Integer topicId, @Param("userId") Long userId);

	List<TopicEntity> queryLike(Long userId);
}
