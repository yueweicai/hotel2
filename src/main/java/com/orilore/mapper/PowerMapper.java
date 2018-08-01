package com.orilore.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.orilore.model.Power;

@Mapper
public interface PowerMapper {
	public boolean insert(Power bean);
	public boolean delete(Integer id);
	public boolean update(Power bean);
	public Power selectOne(Integer id);
	public boolean updateXh(Map<String,Integer> map);
	public List<Power> select();
	public List<Power> select2();
	
}
