/**
 * @Title: TechnologyDaoImpl.java
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

import com.trm.dao.common.BaseDao;
import com.trm.entity.TrmTechnology;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName TechnologyDaoImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author LiuJC
 * @Date 2018年02月26 上午16:40
 * @version 1.0.0
 */
@Repository("technologyDao")
public class TechnologyDaoImpl extends BaseDao implements TechnologyDao {
    /**
     * 通过需求id 删除技术；
     * @param id
     * @return
     */
    public List<TrmTechnology> getAllTechnologyByDemanId(Integer id) {
        String hql = "from TrmTechnology where demandId = ? and isActive = 'Y'";
        List<TrmTechnology> list = (List<TrmTechnology>) this.currentSession().createQuery(hql).setParameter(0, id)
                .list();
        return list;
    }
    
    @Override
    public boolean delTechnogyByDemandId(Integer id) {
        String hql = "update TrmTechnology set isActive = 'N' where demandId = ?";
        int i = this.currentSession().createQuery(hql).setParameter(0, id).executeUpdate();
        return true;
    }
    
    public boolean batchDelTechnogyByDemandId(String[] ids) {
        for (int i = 0; i < ids.length; i++) {
            delTechnogyByDemandId(new Integer(ids[i]));
        }
        return true;
    }
}
