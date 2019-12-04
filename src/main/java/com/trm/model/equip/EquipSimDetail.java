package com.trm.model.equip;

public class EquipSimDetail {

    private Integer id;
    /* 设备名称*/
    private String equipName;
    /* 设备功能分类*/
    private String equipType;
    /* 服务领域分类*/
    private String serviceRange;
    //生产国别
    private String proCountry;
    //型号
    private String equipVerCode;
    private String equipPic1;

    public EquipSimDetail() {
        super();
    }

    public EquipSimDetail(Integer id, String equipName, String equipType, String serviceRange, String proCountry, String equipVerCode,
            String equipPic1) {
        super();
        this.id = id;
        this.equipName = equipName;
        this.equipType = equipType;
        this.serviceRange = serviceRange;
        this.proCountry = proCountry;
        this.equipVerCode = equipVerCode;
        this.equipPic1 = equipPic1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public String getEquipType() {
        return equipType;
    }

    public void setEquipType(String equipType) {
        this.equipType = equipType;
    }

    public String getServiceRange() {
        return serviceRange;
    }

    public void setServiceRange(String serviceRange) {
        this.serviceRange = serviceRange;
    }

    public String getProCountry() {
        return proCountry;
    }

    public void setProCountry(String proCountry) {
        this.proCountry = proCountry;
    }

    public String getEquipVerCode() {
        return equipVerCode;
    }

    public void setEquipVerCode(String equipVerCode) {
        this.equipVerCode = equipVerCode;
    }

    public String getEquipPic1() {
        return equipPic1;
    }

    public void setEquipPic1(String equipPic1) {
        this.equipPic1 = equipPic1;
    }

    @Override
    public String toString() {
        return "EquipSimDetail [id=" + id + ", equipName=" + equipName + ", equipType=" + equipType + ", serviceRange="
                + serviceRange + ", proCountry=" + proCountry + ", equipVerCode=" + equipVerCode + ", equipPic1=" + equipPic1 + "]";
    }

}
