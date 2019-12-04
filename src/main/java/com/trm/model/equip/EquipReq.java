package com.trm.model.equip;

import java.util.List;

import com.trm.model.common.CommonRequest;

public class EquipReq extends CommonRequest {

    private String equipName;//设备名称
    
    //@NotEmpty(message = "设备名称和单位名称-搜索关系不能为空  and or")
    private String equipOrgType;//设备名称和单位名称-搜索关系（且、或） and or
    
    private String orgName;//单位名称
    
    //@NotEmpty(message = "单位名称和主要技术指标-搜索关系不能为空  and or")
    private String orgQualType;//单位名称和主要技术指标-搜索关系（且、或）and or
    
    private String qualification;//主要技术指标
    
    //@NotEmpty(message = "主要技术指标和功能/应用范围-搜索关系不能为空  and or")
    private String qualUseType;//主要技术指标和功能/应用范围-搜索关系（且、或）and or
    
    private String useField;//功能/应用范围
    
    //@NotEmpty(message = "功能/应用范围和技术特色-搜索关系不能为空  and or")
    private String useTecType;//功能/应用范围和技术特色-搜索关系（且、或）and or
    
    private String tecFeature;//技术特色

    private List<String> equipType;//设备功能分类
    private List<String> serviceRange;//服务领域分类

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public String getEquipOrgType() {
        return equipOrgType;
    }

    public void setEquipOrgType(String equipOrgType) {
        this.equipOrgType = equipOrgType;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgQualType() {
        return orgQualType;
    }

    public void setOrgQualType(String orgQualType) {
        this.orgQualType = orgQualType;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getQualUseType() {
        return qualUseType;
    }

    public void setQualUseType(String qualUseType) {
        this.qualUseType = qualUseType;
    }

    public String getUseField() {
        return useField;
    }

    public void setUseField(String useField) {
        this.useField = useField;
    }

    public String getUseTecType() {
        return useTecType;
    }

    public void setUseTecType(String useTecType) {
        this.useTecType = useTecType;
    }

    public String getTecFeature() {
        return tecFeature;
    }

    public void setTecFeature(String tecFeature) {
        this.tecFeature = tecFeature;
    }

    public List<String> getEquipType() {
        return equipType;
    }

    public void setEquipType(List<String> equipType) {
        this.equipType = equipType;
    }

    public List<String> getServiceRange() {
        return serviceRange;
    }

    public void setServiceRange(List<String> serviceRange) {
        this.serviceRange = serviceRange;
    }

    @Override
    public String toString() {
        return "EquipReq [equipName=" + equipName + ", equipOrgType=" + equipOrgType + ", orgName=" + orgName + ", orgQualType=" + orgQualType
                + ", qualification=" + qualification + ", qualUseType=" + qualUseType + ", useField=" + useField + ", useTecType=" + useTecType
                + ", tecFeature=" + tecFeature + ", equipType=" + equipType + ", serviceRange=" + serviceRange + "]";
    }

}
