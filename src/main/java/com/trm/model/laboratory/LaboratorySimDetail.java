package com.trm.model.laboratory;

public class LaboratorySimDetail {

    private Integer id;
    private String labName;
    private String img;

    public LaboratorySimDetail() {
        super();
    }


    public LaboratorySimDetail(Integer id, String labName, String img) {
        super();
        this.id = id;
        this.labName = labName;
        this.img = img;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }


    public String getImg() {
        return img;
    }


    public void setImg(String img) {
        this.img = img;
    }

    //    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")

}
