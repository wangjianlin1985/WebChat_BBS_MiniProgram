package com.wfuhui.modules.bbs.entity;

import java.io.Serializable;
import java.util.Date;

import com.wfuhui.modules.member.entity.MemberEntity;


/**
 * 回复
 * 
 * @author lizhengle
 * @email xxxxx@qq.com
 */
public class ReplyEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//内容
	private String content;
	//会员id
	private Long memberId;
	//主贴id
	private Integer topicId;
	//创建时间
	private Date createTime;
	
	private MemberEntity member;
	
	private TopicEntity topic;
	
	private Integer anonymous;

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
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
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
	 * 设置：主贴id
	 */
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	/**
	 * 获取：主贴id
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
	
	public MemberEntity getMember() {
		return member;
	}
	
	public void setMember(MemberEntity member) {
		this.member = member;
	}
	
	public TopicEntity getTopic() {
		return topic;
	}
	
	public void setTopic(TopicEntity topic) {
		this.topic = topic;
	}
	
	public Integer getAnonymous() {
		return anonymous;
	}
	
	public void setAnonymous(Integer anonymous) {
		this.anonymous = anonymous;
	}
	
}
