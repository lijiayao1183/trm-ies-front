package com.trm.trmserver.model;

import java.util.List;

/**
 * 泛型列表查询
 * 
 * @author <a href="mailto:humorbeau@163.com">胡渊博</a>
 * @date 2017年1月9日
 * @version 1.0
 * @param <T>
 */
public class ServiceListResponse<T> implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private int pageTotal;
	private List<T> list;
	private String remark;
    private int count;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "ServiceListResponse [pageTotal=" + pageTotal + ", list=" + list + ", remark=" + remark + "]";
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
