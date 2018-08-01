package com.orilore.biz;

import java.util.List;
import java.util.Map;

import com.orilore.model.Power;

public interface IPowerBiz {
	public boolean save(Power bean);
	public boolean saveXh(Map<String,Integer> map);
	public boolean remove(Integer id);
	public Power find(Integer id);
	public List<Power> query();
	public List<Power> query2();
}
