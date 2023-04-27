package com.wfuhui.modules.bbs.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.modules.bbs.entity.TopicEntity;
import com.wfuhui.modules.bbs.service.TopicService;
import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;


/**
 * 主贴
 * 
 * @author lizhengle
 * @email xxxxx@qq.com
 */
@RestController
@RequestMapping("topic")
public class TopicController {
	@Autowired
	private TopicService topicService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TopicEntity> topicList = topicService.queryList(query);
		int total = topicService.queryTotal(query);
		
		return R.ok().put("rows", topicList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		TopicEntity topic = topicService.queryObject(id);
		
		return R.ok().put("topic", topic);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody TopicEntity topic){
		topicService.save(topic);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody TopicEntity topic){
		topicService.update(topic);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		topicService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
