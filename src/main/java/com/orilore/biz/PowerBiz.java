package com.orilore.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.orilore.mapper.PowerMapper;
import com.orilore.model.Power;

@Service
public class PowerBiz implements IPowerBiz {
	@Resource
	private PowerMapper mapper;
	@Override
	public boolean save(Power bean) {
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
	public Power find(Integer id) {
		return mapper.selectOne(id);
	}

	@Override
	public List<Power> query() {
		return mapper.select();
	}

	@Override
	public boolean saveXh(Map<String, Integer> map) {
		return mapper.updateXh(map);
	}

	@Override
	public List<Power> query2() {
		return mapper.select2();
	}

}
