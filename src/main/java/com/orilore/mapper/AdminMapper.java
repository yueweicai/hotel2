package com.orilore.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.orilore.model.Admin;

@Mapper
public interface AdminMapper {
	public boolean insert(Admin bean);
	public boolean delete(Integer id);
	public boolean update(Admin bean);
	public Admin selectOne(Admin bean);
	public List<Admin> select();
}
