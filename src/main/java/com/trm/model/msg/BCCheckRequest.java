package com.trm.model.msg;

public class BCCheckRequest {
	
	/**
	 * 设备id
	 */
	private Integer equipId;

	/**
	 * 设备关注状态检查：传值0
	 * 设备预约状态检查：传值1
	 */
	private Integer flag;

	public Integer getEquipId() {
		return equipId;
	}

	public void setEquipId(Integer equipId) {
		this.equipId = equipId;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "BCCheckRequest [equipId=" + equipId + ", flag=" + flag + "]";
	}
	
}
