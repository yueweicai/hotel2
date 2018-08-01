package com.orilore.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orilore.biz.IPowerBiz;
import com.orilore.model.Power;

@RestController
@RequestMapping("/power")
public class PowerCtrl {
	@Resource
	private IPowerBiz biz;
	@RequestMapping("/save")
	public boolean save(Power bean){
		return biz.save(bean);
	}
	@RequestMapping("/remove")
	public boolean remove(int id){
		return biz.remove(id);
	}
	@RequestMapping("/find")
	public Power find(int id){
		return biz.find(id);
	}
	@RequestMapping("/query")
	public List<Power> query(){
		return biz.query();
	}
	@RequestMapping("/query2")
	public List<Power> query2(){
		return biz.query2();
	}
	@RequestMapping("/savexh")
	public boolean savexh(int id,int flag){ 
		Map<String,Integer> map = new HashMap<>();
		map.put("id", id);
		map.put("flag", flag);
		return biz.saveXh(map);
	}
}
