/**
 * @Title: TechnologyDao.java
 * @Package: com.trm.dao.require
 * @Description: TODO(用一句话描述该文件做什么)
 * @Copyright: Copyright (c)
 * @Company: Digital Telemedia Co.,Ltd
 * @author LiuJC
 * @date 2018年02月26 上午16:40
 * @version V1.0
 * @Revision 2018年02月26 上午16:40
 */

package com.trm.dao.require;

import com.trm.entity.TrmTechnology;

import java.util.List;

/**
 * @ClassName TechnologyDao
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author LiuJC
 * @Date 2018年02月26 上午16:40
 * @version 1.0.0
 */
public interface TechnologyDao {
    /**
     * 通过需求id 删除技术；
     * @param id
     * @return
     */
    List<TrmTechnology> getAllTechnologyByDemanId(Integer id);
    
    boolean delTechnogyByDemandId(Integer id);
    
    boolean batchDelTechnogyByDemandId(String[] ids);
}
