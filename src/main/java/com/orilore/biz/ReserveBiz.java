package com.orilore.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.orilore.mapper.ReserveMapper;
import com.orilore.model.Reserve;

@Service
public class ReserveBiz implements IReserveBiz {
	@Resource
	private ReserveMapper mapper;
	@Override
	public boolean save(Reserve bean) {
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
	public Reserve find(Integer id) {
		return mapper.selectOne(id);
	}

	@Override
	public List<Reserve> query(Map<String,Object> map) {
		return mapper.select(map);
	}

}
