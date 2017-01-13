package com.muke.emloyee.domain;

import java.util.List;

/*
 * 用于分页处理
 */
public class PageBean<T> {
	private int currPage;	//当前页数
	private int pageSize;	//每页显示记录数
	private int totalCount;	//总记录条数
	private int totalPage;	//总页数
	private List<T> list;	//每页显示的真实数据
	
	
	
	
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
	
}
