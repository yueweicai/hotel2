package com.orilore.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.orilore.model.Record;

@Mapper
public interface RecordMapper {
	public boolean insert(Record bean);
	public boolean update(Record bean);
	public boolean delete(Integer id);
	public Record selectOne(Integer id);
	public List<Record> select(Map<String,Object> map);
}
