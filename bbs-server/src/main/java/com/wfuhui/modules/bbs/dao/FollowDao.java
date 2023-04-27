package com.wfuhui.modules.bbs.dao;

import com.wfuhui.modules.bbs.entity.FollowEntity;
import com.wfuhui.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 关注
 * 
 * @author lizhengle
 * @email xxxxx@qq.com
 */
@Mapper
public interface FollowDao extends BaseDao<FollowEntity> {

	void remove(@Param("memberId")Long memberId, @Param("userId")Long userId);
	
}
