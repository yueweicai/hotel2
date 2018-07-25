package com.orilore.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orilore.biz.IKindBiz;
import com.orilore.model.Kind;

@RestController
@RequestMapping("/kind")
public class KindCtrl {
	@Resource
	private IKindBiz biz;
	private static final Logger log = LoggerFactory.getLogger(KindCtrl.class);
	@RequestMapping("/find/{kid}")
	public Kind get(@PathVariable("kid") int id){
		return biz.find(id);
	}
	
	@RequestMapping("/query")
	public List<Kind> query(){
		return biz.query();
	}
	
	@RequestMapping("/save")
	public boolean save(Kind bean){
		try{
			return biz.save(bean);
		}catch(Exception ex){
			log.info(ex.getMessage());
			return false;
		}
	}
	
	@RequestMapping("/remove/{id}")
	public boolean remove(@PathVariable("id") int id){
		return biz.remove(id);
	}
	
}
