package com.orilore.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.orilore.mapper.RecordMapper;
import com.orilore.model.Record;

@Service
public class RecordBiz implements IRecordBiz {
	@Resource
	private RecordMapper mapper;
	@Override
	public boolean save(Record bean) {
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
	public Record find(Integer id) {
		return mapper.selectOne(id);
	}

	@Override
	public List<Record> query(Map<String,Object> map) {
		return mapper.select(map);
	}

}
