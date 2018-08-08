package com.orilore.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.orilore.biz.IReserveBiz;
import com.orilore.model.Reserve;

@RestController
@RequestMapping("/reserve")
public class ReserveCtrl {
	@Resource
	private IReserveBiz biz;
	
	@RequestMapping("/save")
	public boolean save(Reserve bean){
		return biz.save(bean);
	}
	@RequestMapping("/remove")
	public boolean remove(int id){
		return biz.remove(id);
	}
	
	@RequestMapping("/change")
	public boolean change(int id){
		return biz.change(id);
	}
	
	@RequestMapping("/find")
	public Reserve find(int id){
		return biz.find(id);
	}
	@RequestMapping("/query")
	public Map<String,Object> query(HttpServletRequest request){
	 	String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		String kname = request.getParameter("kname");
		String custom = request.getParameter("custom");
		String phone = request.getParameter("phone");
		String sdate = request.getParameter("sdate");
		String edate = request.getParameter("edate");
		int p = 1;
		int r = 10;
		if(page!=null && !"".equals(page)){
			p = Integer.parseInt(page);
		}
		if(rows!=null && !"".equals(rows)){
			r = Integer.parseInt(rows);
		}
		PageHelper.startPage(p,r);
		Map<String,Object> map = new HashMap<>();
		if(kname!=null && !"".equals(kname)){
			map.put("kname", kname);
		}
		if(custom!=null && !"".equals(custom)){
			map.put("custom", custom);
		}
		if(phone!=null && !"".equals(phone)){
			map.put("phone", phone);
		}
		if(sdate!=null && !"".equals(sdate)){
			map.put("sdate", sdate);
		}
		if(edate!=null && !"".equals(edate)){
			map.put("edate", edate);
		}
		List<Reserve> list = biz.query(map);
		Page pg = (Page)list;
		int pages = pg.getPages();
		Map<String,Object> rs = new HashMap<>();
		rs.put("list", list);
		rs.put("pages", pages);
		return rs;
	}
}
