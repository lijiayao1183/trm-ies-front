package com.trm.model.techservorg;

import java.util.List;

/**
 * 技术服务机构 某类随附材料信息
 * @author zhaosimiao 2018-6-5 14:21:20
 */
public class OrgOneKindMaterial implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * 技术服务机构id
	 */
	private Integer orgId;
	
	/*
	 * 1 法人营业执照副本扫描件/2 组织机构代码证书扫描件/3 税务登记证书扫描件/4 所获资质及荣誉证书扫描件
	 */
	private String materialType;

	private List<OrgOneMaterial> materialList;


	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public List<OrgOneMaterial> getMaterialList() {
		return materialList;
	}

	public void setMaterialList(List<OrgOneMaterial> materialList) {
		this.materialList = materialList;
	}

    @Override
    public String toString() {
    	
    	String printMaterialList = "";
		for(OrgOneMaterial pmtd : materialList){
			printMaterialList += pmtd.toString();
		}
		
        return "OrgIdMaterialDetails [orgId=" + orgId + ", materialType=" + materialType + ", materialList=" + printMaterialList + "]";
    }

}
