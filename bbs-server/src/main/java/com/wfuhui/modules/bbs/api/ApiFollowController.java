package com.wfuhui.modules.bbs.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.utils.R;
import com.wfuhui.modules.bbs.entity.FollowEntity;
import com.wfuhui.modules.bbs.service.FollowService;

/**
 * 关注接口
 * @author lzl
 *
 */
@RestController
@RequestMapping("/api/follow")
public class ApiFollowController {
	
	@Autowired
	private FollowService followService;
	
	/**
	 * 列表
	 * @return
	 */
    @GetMapping("list")
    public R list(@RequestAttribute Long userId){
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("memberId", userId);
    	List<FollowEntity> followList = followService.queryList(params);
        return R.ok().put("followList", followList);
    }
}
