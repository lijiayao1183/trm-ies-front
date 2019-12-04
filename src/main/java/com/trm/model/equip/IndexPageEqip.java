/**
 * @Title: IndexPageEqip.java
 * @Package: com.trm.model.equip
 * @Description: TODO(用一句话描述该文件做什么)
 * @Copyright: Copyright (c)
 * @Company: Digital Telemedia Co.,Ltd
 * @author LiuJC
 * @date 2018年02月23 上午13:18
 * @version V1.0
 * @Revision 2018年02月23 上午13:18
 */

package com.trm.model.equip;

import com.trm.model.common.CommonListResponse;

import java.io.Serializable;

/**
 * @ClassName IndexPageEqip
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author LiuJC
 * @Date 2018年02月23 13:18
 * @version 1.0.0
 */
public class IndexPageEqip<T> extends CommonListResponse implements Serializable {
    private Long eqipNum;
    private Long faciNum;
    
    /** @return the eqipNum */
    public Long getEqipNum() {
        return eqipNum;
    }
    
    /** @param eqipNum the eqipNum to set */
    public void setEqipNum(Long eqipNum) {
        this.eqipNum = eqipNum;
    }
    
    /** @return the faciNum */
    public Long getFaciNum() {
        return faciNum;
    }
    
    /** @param faciNum the faciNum to set */
    public void setFaciNum(Long faciNum) {
        this.faciNum = faciNum;
    }
}
