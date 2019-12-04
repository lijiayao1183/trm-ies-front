/**
 * @Title: CountEquip.java
 * @Package: com.trm.model.equip
 * @Description: TODO(用一句话描述该文件做什么)
 * @Copyright: Copyright (c)
 * @Company: Digital Telemedia Co.,Ltd
 * @author LiuJC
 * @date 2018年02月24 上午09:54
 * @version V1.0
 * @Revision 2018年02月24 上午09:54
 */

package com.trm.model.equip;

/**
 * @ClassName CountEquip
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author LiuJC
 * @Date 2018年02月24 上午09:54
 * @version 1.0.0
 */
public class CountEquip {
    protected String date;
    protected Long num;
    
    public CountEquip() {
    }
    
    public CountEquip(String date, Long num) {
        this.date = date;
        this.num = num;
    }
    
    /** @return the date */
    public String getDate() {
        return date;
    }
    
    /** @param date the date to set */
    public void setDate(String date) {
        this.date = date;
    }
    
    /** @return the num */
    public Long getNum() {
        return num;
    }
    
    /** @param num the num to set */
    public void setNum(Long num) {
        this.num = num;
    }
}
