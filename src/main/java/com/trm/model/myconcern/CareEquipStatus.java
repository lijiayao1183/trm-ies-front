package com.trm.model.myconcern;

/**
 * 添加关注请求参数
 * @author zhaosimiao 2017-10-17 14:26:01
 */
public class CareEquipStatus {

	/**
	 * 关注设备id
	 */
	private Integer eqpId;
	
	/**
	 * 设备上传用户id
	 */
	private Integer orgId;
	
	/**
	 * 设备关注状态 
	 * 添加关注：Y
	 * 取消关注：N
	 */
	private String focusStatus;

	public Integer getEqpId() {
		return eqpId;
	}

	public void setEqpId(Integer eqpId) {
		this.eqpId = eqpId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getFocusStatus() {
		return focusStatus;
	}

	public void setFocusStatus(String focusStatus) {
		this.focusStatus = focusStatus;
	}

	@Override
	public String toString() {
		return "CareEquipStatus [eqpId=" + eqpId + ", orgId=" + orgId + ", focusStatus=" + focusStatus + "]";
	}
	
}
