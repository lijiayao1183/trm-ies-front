package com.trm.model.common;

import javax.validation.constraints.NotNull;

public class FindDetailsById {
	@NotNull(message = "id不能为空")
	private Integer id;
	private Integer viewCount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	@Override
	public String toString() {
		return "FindDetailsById [id=" + id + ", viewCount=" + viewCount + "]";
	}
}
