package com.orilore.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.orilore.mapper.HPriceMapper;
import com.orilore.model.HPrice;

@Service
public class HPriceBiz implements IHPriceBiz {
	@Resource
	private HPriceMapper mapper;
	
	@Override
	public boolean save(HPrice bean) {
		if(bean.getId()!=null){
			return mapper.update(bean);
		}else{
			return mapper.insert(bean);
		}
	}

	@Override
	public boolean remove(Integer id) {
		return mapper.delete(id);
	}

	@Override
	public List<HPrice> query() {
		return mapper.select();
	}

	@Override
	public HPrice find(Integer id) {
		return mapper.selectOne(id);
	}

}
