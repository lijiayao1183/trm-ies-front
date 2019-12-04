package com.trm.model.techservorg;

/**
 * 技术服务机构 一条随附材料信息
 * @author zhaosimiao 2018-6-5 14:21:20
 */
public class OrgOneMaterial implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	/*
	 * 材料名称
	 */
	private String materialName;
	/*
	 * 材料路径
	 */
	private String materialUrl;
	/*
	 * 材料大小
	 */
	private Integer materialSize;
	/*
	 * 材料格式
	 */
	private String materialFormat;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getMaterialUrl() {
		return materialUrl;
	}

	public void setMaterialUrl(String materialUrl) {
		this.materialUrl = materialUrl;
	}

	public Integer getMaterialSize() {
		return materialSize;
	}

	public void setMaterialSize(Integer materialSize) {
		this.materialSize = materialSize;
	}

	public String getMaterialFormat() {
		return materialFormat;
	}

	public void setMaterialFormat(String materialFormat) {
		this.materialFormat = materialFormat;
	}

    @Override
    public String toString() {
        return "OrgOneMaterial [id=" + id + ", materialName=" + materialName + ", materialUrl=" + materialUrl
                + ", materialSize=" + materialSize + ", materialFormat=" + materialFormat + "]";
    }

}
