package com.wfuhui.modules.bbs.entity;

import java.io.Serializable;

/**
 * 主贴图片
 * 
 * @author lizhengle
 * @email xxxxx@qq.com
 */
public class TopicPicEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer topicId;
	//
	private String picUrl;

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
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	/**
	 * 获取：
	 */
	public String getPicUrl() {
		return picUrl;
	}
}
