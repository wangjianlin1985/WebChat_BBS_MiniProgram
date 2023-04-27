package com.wfuhui.modules.bbs.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.utils.DateUtils;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.bbs.service.ReplyService;
import com.wfuhui.modules.bbs.service.TopicService;
import com.wfuhui.modules.member.service.MemberService;


/**
 * 统计
 * 
 * @author lizhengle
 * @email xxxxx@qq.com
 */
@RestController
@RequestMapping("statistics")
public class StatisticsController {
	@Autowired
	private ReplyService replyService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private MemberService memberService;
	
	/**
	 * 
	 */
	@RequestMapping("/query")
	public R query(@RequestParam Map<String, Object> params){
		Map<String, Object> map = new HashMap<String, Object>();
		Integer userTotal = memberService.queryTotal(map);
		Integer topicTotal = topicService.queryTotal(map);
		Integer replyTotal = replyService.queryTotal(map);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("userTotal", userTotal);
		result.put("replyTotal", replyTotal);
		result.put("topicTotal", topicTotal);
		
		List<Map<String, String>> topicCountList = topicService.queryTopicCount();
		List<Map<String, String>> newTopicCountList = new ArrayList<>();
		if (topicCountList == null || topicCountList.size() < 7) {
			for (int i = -7; i < 0; i++) {
				// 补齐近7天数据，值为0
				Date now = new Date();
				Map<String, String> c = hasDate(DateUtils.format(DateUtils.add(now, i)), topicCountList);
				if(c == null) {
					Map<String, String> m = new HashMap<>();
					m.put("createTime", DateUtils.format(DateUtils.add(now, i)));
					m.put("count", "0");
					newTopicCountList.add(m);
				}else {
					newTopicCountList.add(c);
				}
			}
			result.put("topicCountList", newTopicCountList);
		}else {
			result.put("topicCountList", topicCountList);
		}
		return R.ok().put("statistics", result);
	}
	
	private Map<String, String> hasDate(String date, List<Map<String, String>> list) {
		for (Map<String, String> map : list) {
			if(date.equals(map.get("createTime"))) {
				return map;
			}
		}
		return null;
	}
}
