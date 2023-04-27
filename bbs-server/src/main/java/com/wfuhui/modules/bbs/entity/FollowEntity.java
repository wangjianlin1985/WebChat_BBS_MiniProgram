package com.wfuhui.modules.bbs.entity;

import java.io.Serializable;
import java.util.Date;

import com.wfuhui.modules.member.entity.MemberEntity;



/**
 * 关注
 * 
 * @author lizhengle
 * @email xxxxx@qq.com
 */
public class FollowEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//用户
	private Long memberId;
	//被关注者
	private Long userId;
	//关注时间
	private Date createTime;
	
	private MemberEntity member;

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
	 * 设置：用户
	 */
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：用户
	 */
	public Long getMemberId() {
		return memberId;
	}
	/**
	 * 设置：被关注者
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：被关注者
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：关注时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：关注时间
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
	
	
}
