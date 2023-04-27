package com.wfuhui.modules.bbs.api;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.utils.R;
import com.wfuhui.modules.bbs.entity.CollectEntity;
import com.wfuhui.modules.bbs.service.CollectService;

/**
 * 收藏接口
 * @author lzl
 *
 */
@RestController
@RequestMapping("/api/collect")
public class ApiCollectController {
	
	@Autowired
	private CollectService collectService;
	
	/**
	 * 列表
	 * @param userId
	 * @return
	 */
	@GetMapping("list")
    public R list(@RequestAttribute Long userId){
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("memberId", userId);
    	List<CollectEntity> collectList = collectService.queryList(params);
        return R.ok().put("collectList", collectList);
    }
	
	/**
     * 是否收藏
     * @param topicId
     * @param userId
     * @return
     */
    @RequestMapping("/isCollect")
	public R isCollect(Integer topicId, @RequestAttribute Long userId){
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("topicId", topicId);
    	map.put("memberId", userId);
		int total = collectService.queryTotal(map);
		if(total > 0) {
			return R.ok().put("isCollect", true);
		}
		return R.error("未收藏");
	}
    
    /**
     * 收藏
     * @param topicId
     * @param userId
     * @return
     */
    @RequestMapping("/save")
    public R save(Integer topicId, @RequestAttribute Long userId) {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("topicId", topicId);
    	params.put("memberId", userId);
    	Integer total = collectService.queryTotal(params);
    	if(total > 0) {
    		return R.ok();
    	}
    	CollectEntity collect = new CollectEntity();
    	collect.setCreateTime(new Date());
    	collect.setTopicId(topicId);
    	collect.setMemberId(userId);
    	collectService.save(collect);
    	return R.ok();
    }
    
    /**
     * 取消收藏
     * @param topicId
     * @param userId
     * @return
     */
    @RequestMapping("/uncollect")
    public R uncollect(Integer topicId, @RequestAttribute Long userId) {
    	collectService.remove(topicId, userId);
    	return R.ok();
    }
}
