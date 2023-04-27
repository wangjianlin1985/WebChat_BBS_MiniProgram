package com.wfuhui.modules.bbs.api;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.annotation.AuthIgnore;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.bbs.entity.ReplyEntity;
import com.wfuhui.modules.bbs.service.ReplyService;

@RestController
@RequestMapping("/api/reply")
public class ApiReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping("/save")
	public R save(@RequestBody ReplyEntity reply, @RequestAttribute Long userId){
    	reply.setMemberId(userId);
    	reply.setCreateTime(new Date());
		replyService.save(reply);
		
		return R.ok();
	}
    
	@AuthIgnore
    @RequestMapping("/list")
	public R save(Integer topicId){
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("topicId", topicId);
		List<ReplyEntity> replyList = replyService.queryList(params);
		return R.ok().put("replyList", replyList);
	}
	
	@RequestMapping("/mine")
	public R mine(@RequestAttribute Long userId) {
		Map<String, Object> params = new HashMap<String, Object>();
    	params.put("memberId", userId);
		List<ReplyEntity> replyList = replyService.queryList(params);
		return R.ok().put("replyList", replyList);
	}
    
	/**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/del")
    public R del(Integer id) {
    	replyService.delete(id);;
    	return R.ok();
    }
}
