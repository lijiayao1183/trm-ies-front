/**
 * @Title: PublicStatistics.java
 * @Package: com.trm.model.information
 * @Description: 统计身份认证通过结果公示/资质审核通过结果公示
 * @Copyright: Copyright (c)
 * @Company: Digital Telemedia Co.,Ltd
 * @author huyuanbo  
 * @date 2017年9月11日 下午3:50:02
 * @version V1.0
 * @Revision  2017年9月11日 下午3:50:02 - first revision
 */
package com.trm.model.information;

public class PublicStatistics {
    /*
     * 身份认证通过统计
     */
    private Long creditCount;
    /*
     * 专利审核通过统计
     */
    private Long patentAdoptCount;

    public PublicStatistics() {
        super();
    }

    public PublicStatistics(Long creditCount, Long patentAdoptCount) {
        super();
        this.creditCount = creditCount;
        this.patentAdoptCount = patentAdoptCount;
    }

    public Long getCreditCount() {
        return creditCount;
    }

    public void setCreditCount(Long creditCount) {
        this.creditCount = creditCount;
    }

    public Long getPatentAdoptCount() {
        return patentAdoptCount;
    }

    public void setPatentAdoptCount(Long patentAdoptCount) {
        this.patentAdoptCount = patentAdoptCount;
    }

    @Override
    public String toString() {
        return "PublicStatistics [creditCount=" + creditCount + ", patentAdoptCount=" + patentAdoptCount + "]";
    }
    
}
