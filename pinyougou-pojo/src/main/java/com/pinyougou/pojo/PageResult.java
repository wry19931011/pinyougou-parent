package com.pinyougou.pojo;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9094100356131947703L;

	private Long total;

	private List<T> rows;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public PageResult(Long total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public PageResult() {

	}
}
