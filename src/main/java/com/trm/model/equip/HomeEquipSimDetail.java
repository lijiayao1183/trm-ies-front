package com.trm.model.equip;

public class HomeEquipSimDetail {

    private Integer id;
    /* 设备名称*/
    private String equipName;
    private String equipPic1;
    private String equipPic2;
    private String equipPic3;

    public HomeEquipSimDetail() {
        super();
    }

    public HomeEquipSimDetail(Integer id, String equipName, String equipPic1, String equipPic2, String equipPic3) {
        super();
        this.id = id;
        this.equipName = equipName;
        this.equipPic1 = equipPic1;
        this.equipPic2 = equipPic2;
        this.equipPic3 = equipPic3;
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

    public String getEquipPic1() {
        return equipPic1;
    }

    public void setEquipPic1(String equipPic1) {
        this.equipPic1 = equipPic1;
    }

    public String getEquipPic2() {
        return equipPic2;
    }

    public void setEquipPic2(String equipPic2) {
        this.equipPic2 = equipPic2;
    }

    public String getEquipPic3() {
        return equipPic3;
    }

    public void setEquipPic3(String equipPic3) {
        this.equipPic3 = equipPic3;
    }

    @Override
    public String toString() {
        return "HomeEquipSimDetail [id=" + id + ", equipName=" + equipName + ", equipPic1=" + equipPic1 + ", equipPic2=" + equipPic2 + ", equipPic3="
                + equipPic3 + "]";
    }

}
