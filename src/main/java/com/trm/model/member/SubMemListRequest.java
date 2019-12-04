package com.trm.model.member;

import com.trm.model.common.CommonRequest;

/**
 * 
 * @author zhaosimiao 2017-11-29 15:22:36
 *
 */
public class SubMemListRequest extends CommonRequest{
	
    private Integer id;
    /**
	 * 所属单位id
	 */
	private Integer unitId;
	/**
	 * 所属部门id
	 */
	private Integer departId;
	/**
	 * 所属管理用户id
	 */
	private Integer masterId;
	private String username;
	private String department;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public Integer getDepartId() {
		return departId;
	}
	public void setDepartId(Integer departId) {
		this.departId = departId;
	}
	public Integer getMasterId() {
		return masterId;
	}
	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "SubMemListRequest [id=" + id + ", unitId=" + unitId + ", departId=" + departId + ", masterId="
				+ masterId + ", username=" + username + ", department=" + department + "]";
	}

}
