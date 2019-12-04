/**
 * @Title: DemandIndex.java
 * @Package: com.trm.model.require
 * @Description: TODO(用一句话描述该文件做什么)
 * @Copyright: Copyright (c)
 * @Company: Digital Telemedia Co.,Ltd
 * @author LiuJC
 * @date 2018年02月27 上午09:55
 * @version V1.0
 * @Revision 2018年02月27 上午09:55
 */

package com.trm.model.require;

/**
 * @ClassName DemandIndex
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author LiuJC
 * @Date 2018年02月27 上午09:55
 * @version 1.0.0
 */
public class DemandIndex {
    private Integer id;
    private String code;
    private String name;
    private String type;
    private String domain;
    
    public DemandIndex() {
    }
    
    public DemandIndex(Integer id, String code, String name, String type, String domain) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.domain = domain;
    }
    
    /** @return the id */
    public Integer getId() {
        return id;
    }
    
    /** @param id the id to set */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /** @return the code */
    public String getCode() {
        return code;
    }
    
    /** @param code the code to set */
    public void setCode(String code) {
        this.code = code;
    }
    
    /** @return the name */
    public String getName() {
        return name;
    }
    
    /** @param name the name to set */
    public void setName(String name) {
        this.name = name;
    }
    
    /** @return the type */
    public String getType() {
        return type;
    }
    
    /** @param type the type to set */
    public void setType(String type) {
        this.type = type;
    }
    
    /** @return the domain */
    public String getDomain() {
        return domain;
    }
    
    /** @param domain the domain to set */
    public void setDomain(String domain) {
        this.domain = domain;
    }
}
