package com.orilore.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.orilore.model.Reserve;

@Mapper
public interface ReserveMapper {
	public boolean insert(Reserve bean);
	public boolean update(Reserve bean);
	public boolean delete(Integer id);
	public Reserve selectOne(Integer id);
	public List<Reserve> select(Map<String,Object> map);
}
