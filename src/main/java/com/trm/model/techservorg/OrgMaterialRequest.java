package com.trm.model.techservorg;

import javax.validation.constraints.NotNull;

public class OrgMaterialRequest {

	@NotNull(message = "id不能为空")
	private Integer orgId;

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	@Override
	public String toString() {
		return "OrgMaterialRequest [orgId=" + orgId + "]";
	}

}
