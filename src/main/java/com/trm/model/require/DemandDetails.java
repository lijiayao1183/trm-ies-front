/**
 * @Title: DemandDetails.java
 * @Package: com.trm.model.require
 * @Description: TODO(用一句话描述该文件做什么)
 * @Copyright: Copyright (c)
 * @Company: Digital Telemedia Co.,Ltd
 * @author LiuJC
 * @date 2018年02月26 上午16:00
 * @version V1.0
 * @Revision 2018年02月26 上午16:00
 */

package com.trm.model.require;

import com.trm.entity.TrmDemand;
import com.trm.entity.TrmTechnology;

import java.util.List;

/**
 * @ClassName DemandDetails
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author LiuJC
 * @Date 2018年02月26 上午16:00
 * @version 1.0.0
 */
public class DemandDetails {
    private TrmDemand trmDemand;
    private List<TrmTechnology> technologies;
    private String domain;
    
    /** @return the domain */
    public String getDomain() {
        return domain;
    }
    
    /** @param domain the domain to set */
    public void setDomain(String domain) {
        this.domain = domain;
    }
    
    /** @return the trmDemand */
    public TrmDemand getTrmDemand() {
        return trmDemand;
    }
    
    /** @param trmDemand the trmDemand to set */
    public void setTrmDemand(TrmDemand trmDemand) {
        this.trmDemand = trmDemand;
    }
    
    /** @return the technologies */
    public List<TrmTechnology> getTechnologies() {
        return technologies;
    }
    
    /** @param technologies the technologies to set */
    public void setTechnologies(List<TrmTechnology> technologies) {
        this.technologies = technologies;
    }
    
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DemandDetails{");
        sb.append("technologies=").append(technologies);
        sb.append(", trmDemand=").append(trmDemand);
        sb.append('}');
        return sb.toString();
    }
}
