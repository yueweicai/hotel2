package com.orilore.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.orilore.mapper.RecordMapper;
import com.orilore.mapper.ReserveMapper;
import com.orilore.model.Record;
import com.orilore.model.Reserve;

@Service
public class ReserveBiz implements IReserveBiz {
	@Resource
	private ReserveMapper mapper;
	@Resource
	private RecordMapper dao;
	
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

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean change(Integer id) {
		Reserve res = mapper.selectOne(id);
		if(res!=null){
			if(mapper.delete(id)){
				Record rec = new Record();
				rec.setCustom(res.getCustom());
				rec.setPhone(res.getPhone());
				rec.setPersons(res.getPersons());
				rec.setHid(res.getHid());
				rec.setLtime(res.getLdate());
				rec.setPrice(res.getPrice());
				rec.setTotal(res.getTotal());
				rec.setWxnick(res.getWxnick());
				if(dao.insert(rec)){
					return true;
				}
			}
		}
		return false;
	}

}
