package com.trm.model.common;

import java.util.List;

public class CommonListResponse <T> implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int pageTotal;
	private List<T> list;
	private int count;
	

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	@Override
	public String toString() {
		return "CommonListResponse [pageTotal=" + pageTotal + ", list=" + list + "]";
	}
	
}
