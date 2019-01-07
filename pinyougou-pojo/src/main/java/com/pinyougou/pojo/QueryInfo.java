package com.pinyougou.pojo;

import java.io.Serializable;

public class QueryInfo<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8271272355993196332L;

	private T searchEntity;

	/**
	 * 当前页
	 */
	private Integer pageNum;

	/**
	 * 每页条数
	 */
	private Integer pageSize;
	/**
	 * 排序
	 */
	private String orderBy;

	public T getSearchEntity() {
		return searchEntity;
	}

	public void setSearchEntity(T searchEntity) {
		this.searchEntity = searchEntity;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

}
