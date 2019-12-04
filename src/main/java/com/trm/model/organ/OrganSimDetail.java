package com.trm.model.organ;

public class OrganSimDetail {

    private Integer id;
    private String orgName;
    private String logoImg;

    public OrganSimDetail() {
        super();
    }

    public OrganSimDetail(Integer id, String orgName, String logoImg) {
        super();
        this.id = id;
        this.orgName = orgName;
        this.logoImg = logoImg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getLogoImg() {
        return logoImg;
    }

    public void setLogoImg(String logoImg) {
        this.logoImg = logoImg;
    }

    @Override
    public String toString() {
        return "OrganSimDetail [id=" + id + ", orgName=" + orgName + ", logoImg=" + logoImg + "]";
    }

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
}
