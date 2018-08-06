package com.orilore.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.orilore.model.*;

@Mapper
public interface HouseMapper{
	public boolean insert(House bean);
	public boolean delete(Integer id);
	public boolean update(House bean);
	public House selectOne(Integer id);
	public boolean enable(House bean);
	public boolean updateImage(House bean);
	public List<House> select(Map<String,Object> map);
	public List<House> selectByMap(Map<String,Object> map);
}