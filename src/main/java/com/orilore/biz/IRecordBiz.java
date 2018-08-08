package com.orilore.biz;

import java.util.List;
import java.util.Map;

import com.orilore.model.Record;

public interface IRecordBiz {
	public boolean save(Record bean);
	public boolean remove(Integer id);
	public Record find(Integer id);
	public List<Record> query(Map<String,Object> map);
}
