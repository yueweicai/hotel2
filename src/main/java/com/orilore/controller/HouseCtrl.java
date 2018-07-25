package com.orilore.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.orilore.biz.IHouseBiz;
import com.orilore.model.House;

@RestController
@RequestMapping("/house")
public class HouseCtrl {
	@Resource
	private IHouseBiz biz;
	
	@RequestMapping("/query")
	public Map<String,Object> query(HttpServletRequest request){
		//封装查询条件
		String k = request.getParameter("kid");
		String b = request.getParameter("beds");
		Map<String,Object> map = new HashMap<>();
		if(k!=null && !k.equals("")){
			map.put("kid", Integer.parseInt(k));
		}
		if(b!=null && !b.equals("")){
			map.put("beds", Integer.parseInt(b));
		}
		//设置分页条件
		int page=1,rows=10;
		String p = request.getParameter("page");
		if(p!=null && !p.equals("")){
			page = Integer.parseInt(p);
		}
		String r = request.getParameter("rows");
		if(r!=null && !r.equals("")){
			rows = Integer.parseInt(r);
		}
		PageHelper.startPage(page,rows);
		List<House> list = biz.query(map);
		//获取分页信息
		Page pg = (Page)list;
		int pages = pg.getPages();
		//构建返回结果
		Map<String,Object> rs = new HashMap<>();
		rs.put("list", list);
		rs.put("pages", pages);
		rs.put("page", page);
		return rs;
	}
	
	@RequestMapping("/save")
	public boolean save(House bean){
		return biz.save(bean);
	}
	
	@RequestMapping("/enable/{id}/{status}")
	public boolean enable(@PathVariable("id") int id,@PathVariable("status") int status){
		return biz.enable(id, status);
	}
	
	@RequestMapping("/remove/{id}")
	public boolean remove(@PathVariable("id") int id){
		return biz.remove(id);
	}
	
	@RequestMapping("/find/{id}")
	public House find(@PathVariable("id") int id){
		return biz.find(id);
	}
}
