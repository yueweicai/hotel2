package com.orilore.model;

public class Rule {
	private Integer aid;
	private Integer pid;
	
	public Rule(){
		
	}
	
	public Rule(Integer aid,Integer pid){
		this.aid = aid;
		this.pid = pid;
	}
	
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
}
