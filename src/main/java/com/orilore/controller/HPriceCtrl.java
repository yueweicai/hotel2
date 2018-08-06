package com.orilore.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.orilore.biz.IHPriceBiz;
import com.orilore.model.HPrice;

@RestController
@RequestMapping("/price")
public class HPriceCtrl {
	@Resource
	private IHPriceBiz biz;
	
	@RequestMapping("/save")
	public boolean save(HPrice bean){
		System.out.println(bean);
		return biz.save(bean);
	}
	
	@RequestMapping("/remove/{id}")
	public boolean remove(@PathVariable("id") int id){
		return biz.remove(id);
	}
	
	@RequestMapping("/get")
	public HPrice getprice(int kid,String sdate,String edate){
		Map<String,Object> map = new HashMap<>();
		map.put("kid", kid);
		map.put("sdate",sdate);
		map.put("edate", edate);
		return biz.query(map);
	}
	
	@RequestMapping("/query")
	public Map<String,Object> query(int page,int rows){
		if(page<=0) page = 1;
		if(rows<=0) rows = 10;
 		PageHelper.startPage(page, rows);
		List<HPrice> list = biz.query();
		Page pg = (Page)list;
		int pages = pg.getPages();
		Map<String,Object> rs = new HashMap<>();
		rs.put("list", list);
		rs.put("pages", pages);
		rs.put("page", page);
		return rs;
	}
}
