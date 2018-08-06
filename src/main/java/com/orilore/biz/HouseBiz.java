package com.orilore.biz;
import com.orilore.model.*;
import com.orilore.mapper.*;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class HouseBiz implements IHouseBiz{
	@Resource
	private HouseMapper mapper;
	@Override
	public boolean save(House bean) {
		if(bean.getId()!=null){
			return this.mapper.update(bean);
		}else{
			return this.mapper.insert(bean);
		}
	}

	@Override
	public boolean remove(Integer id) {
		return this.mapper.delete(id);
	}

	@Override
	public House find(Integer id) {
		return this.mapper.selectOne(id);
	}

	@Override
	public List<House> query(Map<String,Object> map) {
		return this.mapper.select(map);
	}

	@Override
	public boolean enable(Integer id, Integer status) {
		House bean = new House();
		bean.setId(id);
		bean.setStatus(status);
		return this.mapper.enable(bean);
	}

	@Override
	public boolean updateImage(House bean) {
		return this.mapper.updateImage(bean);
	}

	@Override
	public List<House> queryHouses(Map<String, Object> map) {
		return this.mapper.selectByMap(map);
	}
}
