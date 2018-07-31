package com.orilore.biz;

import com.orilore.model.Company;

public interface ICompanyBiz {
	public Company find();
	public boolean save(Company bean);
	public boolean saveImage(Company bean);
}
