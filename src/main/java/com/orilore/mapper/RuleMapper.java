package com.orilore.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.orilore.model.Rule;

@Mapper
public interface RuleMapper {
	public boolean insert(Rule bean);
	public boolean delete(Integer aid);
}
