package com.wfuhui.modules.bbs.api;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.annotation.AuthIgnore;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.bbs.entity.FollowEntity;
import com.wfuhui.modules.bbs.entity.LikeEntity;
import com.wfuhui.modules.bbs.entity.ReplyEntity;
import com.wfuhui.modules.bbs.entity.TopicEntity;
import com.wfuhui.modules.bbs.service.FollowService;
import com.wfuhui.modules.bbs.service.LikeService;
import com.wfuhui.modules.bbs.service.ReplyService;
import com.wfuhui.modules.bbs.service.TopicService;

/**
 * 帖子
 */
@RestController
@RequestMapping("/api/topic")
public class ApiTopicController {
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private LikeService likeService;
	
	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private FollowService followService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@AuthIgnore
    @GetMapping("list")
    public R list(@RequestParam Map<String, Object> params){
    	List<TopicEntity> topicList = topicService.queryList(params);
    	Integer total = topicService.queryTotal(params);
        return R.ok().put("topicList", topicList).put("total", total);
    }
	
	/**
	 * 我的
	 * @param params
	 * @param userId
	 * @return
	 */
	@GetMapping("mylist")
    public R mylist(@RequestParam Map<String, Object> params, @RequestAttribute Long userId){
		params.put("userId", userId);
    	List<TopicEntity> topicList = topicService.queryList(params);
        return R.ok().put("topicList", topicList);
    }
    
	/**
	 * 发布
	 * @param topic
	 * @param userId
	 * @return
	 */
    @RequestMapping("/save")
	public R save(@RequestBody TopicEntity topic, @RequestAttribute Long userId){
    	topic.setMemberId(userId);
    	topic.setCreateTime(new Date());
		topicService.save(topic);
		
		return R.ok();
	}
    
    /**
     * 详情
     * @param id
     * @return
     */
    @AuthIgnore
    @RequestMapping("/detail")
    public R detail(Integer id) {
    	TopicEntity topic = topicService.queryObject(id);
    	return R.ok().put("topic", topic);
    }
    
    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/del")
    public R del(Integer id) {
    	topicService.delete(id);;
    	return R.ok();
    }
    
    
    /**
     * 是否点赞
     * @param topicId
     * @param userId
     * @return
     */
    @RequestMapping("/isLike")
	public R isLike(Integer topicId, @RequestAttribute Long userId){
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("topicId", topicId);
    	map.put("userId", userId);
		int total = likeService.queryTotal(map);
		if(total > 0) {
			return R.ok();
		}
		return R.error("未点赞");
	}
    
    /**
     * 点赞
     * @param topicId
     * @param userId
     * @return
     */
    @RequestMapping("/like")
    public R like(Integer topicId, @RequestAttribute Long userId) {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("topicId", topicId);
    	params.put("userId", userId);
    	Integer total = likeService.queryTotal(params);
    	if(total > 0) {
    		return R.ok();
    	}
    	LikeEntity like = new LikeEntity();
    	like.setTopicId(topicId);
    	like.setCreateTime(new Date());
    	like.setMemberId(userId);
    	likeService.save(like);
    	return R.ok();
    }
    
    /**
     * 取消点赞
     * @param topicId
     * @param userId
     * @return
     */
    @RequestMapping("/unlike")
    public R unlike(Integer topicId, @RequestAttribute Long userId) {
    	likeService.remove(topicId, userId);
    	return R.ok();
    }
    
    /**
     * 回复
     * @param reply
     * @param userId
     * @return
     */
    @RequestMapping("/reply")
	public R save(@RequestBody ReplyEntity reply, @RequestAttribute Long userId){
    	reply.setMemberId(userId);
    	reply.setCreateTime(new Date());
		replyService.save(reply);
		
		return R.ok();
	}
    
    
    @RequestMapping("/isFollow")
	public R isFollow(Long uId, @RequestAttribute Long userId){
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("memberId", userId);
    	map.put("userId", uId);
		int total = followService.queryTotal(map);
		if(total > 0) {
			return R.ok();
		}
		return R.error("未关注");
	}
    
    @RequestMapping("/follow")
    public R follow(Long uId, @RequestAttribute Long userId) {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("memberId", userId);
    	params.put("userId", uId);
    	Integer total = followService.queryTotal(params);
    	if(total > 0) {
    		return R.ok();
    	}
    	FollowEntity follow = new FollowEntity();
    	follow.setUserId(uId);
    	follow.setCreateTime(new Date());
    	follow.setMemberId(userId);
    	followService.save(follow);
    	return R.ok();
    }
    
    @RequestMapping("/unfollow")
    public R unfollow(Long uId, @RequestAttribute Long userId) {
    	followService.remove(uId, userId);
    	return R.ok();
    }
    
    @RequestMapping("/mineLike")
    public R mineLike(@RequestAttribute Long userId) {
    	List<TopicEntity> topicList = likeService.queryLike(userId);
    	return R.ok().put("topicList", topicList);
    }
}
