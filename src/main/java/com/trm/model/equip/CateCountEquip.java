/**
 * @Title: CateCountEquip.java
 * @Package: com.trm.model.equip
 * @Description: TODO(用一句话描述该文件做什么)
 * @Copyright: Copyright (c)
 * @Company: Digital Telemedia Co.,Ltd
 * @author LiuJC
 * @date 2018年02月24 上午10:03
 * @version V1.0
 * @Revision 2018年02月24 上午10:03
 */

package com.trm.model.equip;

import java.io.Serializable;

/**
 * @ClassName CateCountEquip
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author LiuJC
 * @Date 2018年02月24 上午10:03
 * @version 1.0.0
 */
@SuppressWarnings("serial")
public class CateCountEquip extends CountEquip implements Serializable {
    private Long equipNum;
    private Long faciNum;
    
    public CateCountEquip() {
    }
    
    public CateCountEquip(Long equipNum, Long faciNum) {
        this.equipNum = equipNum;
        this.faciNum = faciNum;
    }
    
    public CateCountEquip(String date, Long num, Long equipNum, Long faciNum) {
        super(date, num);
        this.equipNum = equipNum;
        this.faciNum = faciNum;
    }
    
    /** @return the equipNum */
    public Long getEquipNum() {
        return equipNum;
    }
    
    /** @param equipNum the equipNum to set */
    public void setEquipNum(Long equipNum) {
        this.equipNum = equipNum;
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
