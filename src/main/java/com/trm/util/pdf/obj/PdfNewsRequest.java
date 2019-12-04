package com.trm.util.pdf.obj;

import javax.validation.constraints.NotNull;

public class PdfNewsRequest {
	
	@NotNull(message = "所下载项的id不能为空")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PdfNewsRequest [id=" + id + "]";
	}
	
}
