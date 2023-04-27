package com.wfuhui.modules.bbs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.modules.bbs.entity.FollowEntity;
import com.wfuhui.modules.bbs.service.FollowService;
import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;




/**
 * 关注
 * 
 * @author lizhengle
 * @email xxxxx@qq.com
 */
@RestController
@RequestMapping("follow")
public class FollowController {
	@Autowired
	private FollowService followService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<FollowEntity> followList = followService.queryList(query);
		int total = followService.queryTotal(query);
		
		return R.ok().put("rows", followList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		FollowEntity follow = followService.queryObject(id);
		
		return R.ok().put("follow", follow);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody FollowEntity follow){
		followService.save(follow);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody FollowEntity follow){
		followService.update(follow);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		followService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
