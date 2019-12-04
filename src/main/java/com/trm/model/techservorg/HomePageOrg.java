package com.trm.model.techservorg;

import com.trm.model.common.CommonListResponse;

import java.io.Serializable;

/**
 * 
 * @author zhaosimiao 2018-2-27 15:23:03
 *
 * @param <T>
 */
@SuppressWarnings({ "serial", "rawtypes" })
public class HomePageOrg<T> extends CommonListResponse implements Serializable {
	/**
	 * 总量
	 */
    private Long orgNum;
    /**
     * 技术需求对接类
     */
    private Long orgNum1;
    /**
     * 科技评估类
     */
    private Long orgNum2;
    /**
     * 孵化器类
     */
    private Long orgNum3;
    /**
     * 科技投融资类
     */
    private Long orgNum4;
    /**
     * 管理咨询类
     */
    private Long orgNum5;

	public Long getOrgNum() {
		return orgNum;
	}

	public void setOrgNum(Long orgNum) {
		this.orgNum = orgNum;
	}

	public Long getOrgNum1() {
		return orgNum1;
	}

	public void setOrgNum1(Long orgNum1) {
		this.orgNum1 = orgNum1;
	}

	public Long getOrgNum2() {
		return orgNum2;
	}

	public void setOrgNum2(Long orgNum2) {
		this.orgNum2 = orgNum2;
	}

	public Long getOrgNum3() {
		return orgNum3;
	}

	public void setOrgNum3(Long orgNum3) {
		this.orgNum3 = orgNum3;
	}

	public Long getOrgNum4() {
		return orgNum4;
	}

	public void setOrgNum4(Long orgNum4) {
		this.orgNum4 = orgNum4;
	}

	public Long getOrgNum5() {
		return orgNum5;
	}

	public void setOrgNum5(Long orgNum5) {
		this.orgNum5 = orgNum5;
	}
  
}
