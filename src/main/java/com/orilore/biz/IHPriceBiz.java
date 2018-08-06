package com.orilore.biz;

import java.util.List;
import java.util.Map;

import com.orilore.model.HPrice;

public interface IHPriceBiz {
	public boolean save(HPrice bean);
	public boolean remove(Integer id);
	public HPrice find(Integer id);
	public List<HPrice> query();
	public HPrice query(Map<String,Object> map);
}
