package com.finacial.database.dao;

import java.util.List;

public class Pager<E> {
	private int pageNo;
	private int pageSize;
	private int rowCount;
	private List<E> pageData;
	public Pager(){
		
	}
	public Pager(int pageNo,int pageSize,int rowCount,List<E> pageData){
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.pageData = pageData;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public List<E> getPageData() {
		return pageData;
	}
	public void setPageData(List<E> pageData) {
		this.pageData = pageData;
	}
	
	
}
