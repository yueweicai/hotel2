package com.orilore.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.orilore.model.Company;

@Mapper
public interface CompanyMapper {
	public Company selectOne();
	public boolean update(Company bean);
	public boolean updateImage(Company bean);
}
