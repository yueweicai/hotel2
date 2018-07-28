package com.orilore.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.orilore.model.HPrice;

@Mapper
public interface HPriceMapper {
	public boolean insert(HPrice bean);
	public boolean update(HPrice bean);
	public boolean delete(Integer id);
	public List<HPrice> select();
	public HPrice selectOne(Integer id);
}
