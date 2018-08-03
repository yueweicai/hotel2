package com.orilore.biz;

import java.util.List;

import com.orilore.model.Admin;

public interface IAdminBiz {
	public boolean save(Admin bean,List<Integer> pids);
	public boolean remove(Integer id);
	public Admin find(Admin bean);
	public Admin get(Integer id);
	public List<Admin> query();
}
