package com.wfuhui.modules.bbs.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 点赞
 * 
 * @author lizhengle
 * @email xxxxx@qq.com
 */
public class LikeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer id;
	//会员id
	private Long memberId;
	//帖子id
	private Integer topicId;
	//创建时间
	private Date createTime;

	/**
	 * 设置：主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：会员id
	 */
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：会员id
	 */
	public Long getMemberId() {
		return memberId;
	}
	/**
	 * 设置：帖子id
	 */
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	/**
	 * 获取：帖子id
	 */
	public Integer getTopicId() {
		return topicId;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
