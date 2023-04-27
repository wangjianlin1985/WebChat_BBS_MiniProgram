package com.wfuhui.modules.bbs.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 收藏
 * 
 * @author lizhengle
 * @email xxxxx@qq.com
 */
public class CollectEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Long memberId;
	//
	private Integer topicId;
	//
	private Date createTime;
	
	private TopicEntity topic;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：
	 */
	public Long getMemberId() {
		return memberId;
	}
	/**
	 * 设置：
	 */
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	/**
	 * 获取：
	 */
	public Integer getTopicId() {
		return topicId;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	
	public TopicEntity getTopic() {
		return topic;
	}
	
	public void setTopic(TopicEntity topic) {
		this.topic = topic;
	}
	
}
