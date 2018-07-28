package com.orilore.biz;

import java.util.List;
import com.orilore.model.HPrice;

public interface IHPriceBiz {
	public boolean save(HPrice bean);
	public boolean remove(Integer id);
	public List<HPrice> query();
	public HPrice find(Integer id);
}
