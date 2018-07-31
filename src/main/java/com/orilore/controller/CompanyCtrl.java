package com.orilore.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.orilore.biz.ICompanyBiz;
import com.orilore.model.Company;
import com.orilore.util.Uploader;

@RestController
@RequestMapping("/company")
public class CompanyCtrl {
	@Resource
	private ICompanyBiz biz;
	
	@RequestMapping("/find")
	public Company find(){
		return this.biz.find();
	}
	
	@RequestMapping("/upload")
	public boolean upload(MultipartFile files[],HttpServletRequest request){
		//获取网站运行的tomcat绝对路径
		String path = request.getSession().getServletContext().getRealPath("/images");
		//判断目录结构是否存在，如果不存在创建之
		File dir = new File(path);
		if(!dir.exists()){
			dir.mkdirs();
		}
		Company bean = new Company();
		bean.setId(1);
		for(int i=0;i<files.length;i++){
			MultipartFile file = files[i];
			if(file!=null && file.getSize()>0){
				String name = Uploader.upload(file, path);
				if(name!=null){
					switch(i){
					case 0:
						bean.setPica(name);
						break;
					case 1:
						bean.setPicb(name);
						break;
					case 2:
						bean.setPicc(name);
						break;
					case 3:
						bean.setPicd(name);
						break;
					case 4:
						bean.setPice(name);
						break;
					case 5:
						bean.setPicf(name);
						break;
					}
				}
			}
		}
		return this.biz.saveImage(bean);
	}
	
	@RequestMapping("/save")
	public boolean save(Company bean){
		return this.biz.save(bean);
	}
	
}
