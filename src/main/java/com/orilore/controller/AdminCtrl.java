package com.orilore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.orilore.biz.IAdminBiz;
import com.orilore.model.Admin;
import com.orilore.util.MD5;

@RestController
@RequestMapping("/admin")
public class AdminCtrl {
	@Resource
	private IAdminBiz biz;
	private MD5 md5 = new MD5();
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public Admin login(String username,String password){
		Admin bean = new Admin();
		bean.setUsername(username);
		bean.setPassword(md5.md5crypt(password));
		return biz.find(bean);
	}
	
	@RequestMapping("/find")
	public Admin find(int id){
		return biz.get(id);
	}
	
	@RequestMapping("/query")
	public List<Admin> query(){
		return biz.query();
	}
	
	@RequestMapping("/save")
	public boolean save(HttpServletRequest request){
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String status = request.getParameter("status");
		String ids = request.getParameter("ids");
		
		List<Integer> list = new ArrayList<>();
		if(ids!=null && ids.length()>0){
			String[] pids = ids.split(",");
			for(String s : pids){
				list.add(Integer.parseInt(s));
			}
		}
		
		Admin bean = new Admin();
		bean.setUsername(username);
		bean.setPassword(md5.md5crypt(password));
		bean.setStatus(Integer.parseInt(status));
		if(id!=null && !"".equals(id)){
			bean.setId(Integer.parseInt(id));
		}
		
		return biz.save(bean, list);
	}
}
