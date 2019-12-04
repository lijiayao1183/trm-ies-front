/**
 * @Title: EquipDayReq.java
 * @Package: com.trm.model.equip
 * @Description: TODO(用一句话描述该文件做什么)
 * @Copyright: Copyright (c)
 * @Company: Digital Telemedia Co.,Ltd
 * @author LiuJC
 * @date 2018年02月24 上午13:05
 * @version V1.0
 * @Revision 2018年02月24 上午13:05
 */

package com.trm.model.equip;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @ClassName EquipDayReq
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author LiuJC
 * @Date 2018年02月24 上午13:05
 * @version 1.0.0
 */
public class EquipDayReq {
    
    @Pattern(regexp = "[0-9]{4}-[0-9]{2}-[0-9]{2}", message = "日期格式如:yyyy-MM-dd")
    @NotBlank(message = "请填写日期")
    private String day;
    @NotNull(message = "请填写数量")
    private Integer num;
    
    /** @return the day */
    public String getDay() {
        return day;
    }
    
    /** @param day the day to set */
    public void setDay(String day) {
        this.day = day;
    }
    
    /** @return the num */
    public Integer getNum() {
        return num;
    }
    
    /** @param num the num to set */
    public void setNum(Integer num) {
        this.num = num;
    }
}
