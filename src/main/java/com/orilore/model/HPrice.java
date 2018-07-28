package com.orilore.model;
/**
 * 客房价格数据模型
 * @author yue
 */
public class HPrice {
	private Integer id;
	private Integer kid;
	private String sdate;
	private String edate;
	private Float price;
	private Float dis;
	private Integer status;
	private Kind kind;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getKid() {
		return kid;
	}
	public void setKid(Integer kid) {
		this.kid = kid;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getDis() {
		return dis;
	}
	public void setDis(Float dis) {
		this.dis = dis;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Kind getKind() {
		return kind;
	}
	public void setKind(Kind kind) {
		this.kind = kind;
	}
}
