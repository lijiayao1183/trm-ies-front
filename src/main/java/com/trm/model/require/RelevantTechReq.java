/**
 * @Title: RelevantTechReq.java
 * @Package: com.trm.model.require
 * @Description: TODO(用一句话描述该文件做什么)
 * @Copyright: Copyright (c)
 * @Company: Digital Telemedia Co.,Ltd
 * @author LiuJC
 * @date 2018年02月26 上午11:28
 * @version V1.0
 * @Revision 2018年02月26 上午11:28
 */

package com.trm.model.require;

/**
 * @ClassName RelevantTechReq
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author LiuJC
 * @Date 2018年02月26 上午11:28
 * @version 1.0.0
 */
public class RelevantTechReq {
    private String techName;
    private String techContent;
    private String techPhone;
    
    public RelevantTechReq() {
    }
    
    /** @return the techName */
    public String getTechName() {
        return techName;
    }
    
    /** @param techName the techName to set */
    public void setTechName(String techName) {
        this.techName = techName;
    }
    
    /** @return the techContent */
    public String getTechContent() {
        return techContent;
    }
    
    /** @param techContent the techContent to set */
    public void setTechContent(String techContent) {
        this.techContent = techContent;
    }
    
    /** @return the techPhone */
    public String getTechPhone() {
        return techPhone;
    }
    
    /** @param techPhone the techPhone to set */
    public void setTechPhone(String techPhone) {
        this.techPhone = techPhone;
    }
}
