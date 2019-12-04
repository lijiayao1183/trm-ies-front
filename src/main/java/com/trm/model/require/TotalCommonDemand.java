/**
 * @Title: TotalCommonDemand.java
 * @Package: com.trm.model.require
 * @Description: TODO(用一句话描述该文件做什么)
 * @Copyright: Copyright (c)
 * @Company: Digital Telemedia Co.,Ltd
 * @author LiuJC
 * @date 2018年02月27 上午10:04
 * @version V1.0
 * @Revision 2018年02月27 上午10:04
 */

package com.trm.model.require;

import com.trm.model.common.CommonListResponse;

import java.io.Serializable;

/**
 * @ClassName TotalCommonDemand
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author LiuJC
 * @Date 2018年02月27 上午10:04
 * @version 1.0.0
 */
public class TotalCommonDemand<T> extends CommonListResponse implements Serializable {
    private Long techNum;
    private Long prodNum;
    private Long moneyNum;
    
    /** @return the techNum */
    public Long getTechNum() {
        return techNum;
    }
    
    /** @param techNum the techNum to set */
    public void setTechNum(Long techNum) {
        this.techNum = techNum;
    }
    
    /** @return the prodNum */
    public Long getProdNum() {
        return prodNum;
    }
    
    /** @param prodNum the prodNum to set */
    public void setProdNum(Long prodNum) {
        this.prodNum = prodNum;
    }
    
    /** @return the moneyNum */
    public Long getMoneyNum() {
        return moneyNum;
    }
    
    /** @param moneyNum the moneyNum to set */
    public void setMoneyNum(Long moneyNum) {
        this.moneyNum = moneyNum;
    }
}
