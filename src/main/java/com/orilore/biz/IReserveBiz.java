package com.orilore.biz;

import java.util.List;
import java.util.Map;

import com.orilore.model.Reserve;

public interface IReserveBiz {
	public boolean save(Reserve bean);
	public boolean remove(Integer id);
	public Reserve find(Integer id);
	public List<Reserve> query(Map<String,Object> map);
}
