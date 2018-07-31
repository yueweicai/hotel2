package com.orilore.biz;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.orilore.mapper.CompanyMapper;
import com.orilore.model.Company;

@Service
public class CompanyBiz implements ICompanyBiz {
	@Resource
	private CompanyMapper mapper;
	@Override
	public Company find() {
		return this.mapper.selectOne();
	}

	@Override
	public boolean save(Company bean) {
		return this.mapper.update(bean);
	}

	@Override
	public boolean saveImage(Company bean) {
		return this.mapper.updateImage(bean);
	}

}
