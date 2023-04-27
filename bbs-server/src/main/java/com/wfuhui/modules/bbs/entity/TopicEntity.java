package com.wfuhui.modules.bbs.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.wfuhui.modules.member.entity.MemberEntity;

/**
 * 主贴
 * 
 * @author lizhengle
 * @email xxxxx@qq.com
 */
public class TopicEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	// 话题
	private String title;
	// 会员id
	private Long memberId;
	// 状态
	private Integer status;
	// 创建时间
	private Date createTime;

	private Integer likeNumber;

	private Integer replyNumber;

	private String[] picUrls;
	
	private String videoUrl;

	private List<ReplyEntity> replyList;

	private MemberEntity member;
	
	private String content;
	
	private Integer categoryId;
	
	private CategoryEntity category;
	
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
	 * 设置：话题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 获取：话题
	 */
	public String getTitle() {
		return title;
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
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
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

	public Integer getLikeNumber() {
		if (likeNumber == null) {
			return 0;
		}
		return likeNumber;
	}

	public void setLikeNumber(Integer likeNumber) {
		this.likeNumber = likeNumber;
	}

	public Integer getReplyNumber() {
		if (replyNumber == null) {
			return 0;
		}
		return replyNumber;
	}

	public void setReplyNumber(Integer replyNumber) {
		this.replyNumber = replyNumber;
	}

	public String[] getPicUrls() {
		return picUrls;
	}

	public void setPicUrls(String[] picUrls) {
		this.picUrls = picUrls;
	}

	public List<ReplyEntity> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<ReplyEntity> replyList) {
		this.replyList = replyList;
	}

	public MemberEntity getMember() {
		return member;
	}

	public void setMember(MemberEntity member) {
		this.member = member;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public Integer getAnonymous() {
		return anonymous;
	}

	public void setAnonymous(Integer anonymous) {
		this.anonymous = anonymous;
	}
	
}
