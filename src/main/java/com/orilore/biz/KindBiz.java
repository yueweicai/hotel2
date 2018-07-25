package com.orilore.biz;
import com.orilore.model.*;
import com.orilore.mapper.*;
import java.util.*;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class KindBiz implements IKindBiz{
	@Resource
	private KindMapper mapper;
	private static final Logger log = LoggerFactory.getLogger(KindBiz.class);
	@Override
	public boolean save(Kind bean) {
		if(bean.getId()!=null){
			return this.mapper.update(bean);
		}else{
			return this.mapper.insert(bean);
		}
	}

	@Override
	public boolean remove(Integer id) {
		boolean flag = false;
		try{
			flag = this.mapper.delete(id);
		}catch(Exception ex){
			log.error(ex.getMessage());
		}
		return flag;
	}

	@Override
	public Kind find(Integer id) {
		return this.mapper.selectOne(id);
	}

	@Override
	public List<Kind> query() {
		return this.mapper.select();
	}
}
