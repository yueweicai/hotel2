package com.orilore.biz;

import java.util.List;

import com.orilore.model.Admin;

public interface IAdminBiz {
	public boolean save(Admin bean,int pids[]);
	public boolean remove(Integer id);
	public Admin find(Admin bean);
	public List<Admin> query();
}
