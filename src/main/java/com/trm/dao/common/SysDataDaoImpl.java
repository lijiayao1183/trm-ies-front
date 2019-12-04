package com.trm.dao.common;

import com.trm.entity.SysDataDictionary;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.CommonRequest;
import com.trm.model.common.SysDataSimDetail;
import com.trm.util.paging.QueryPage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("sysDataDao")
public class SysDataDaoImpl extends BaseDao implements SysDataDao {
    
    @SuppressWarnings("unchecked")
    @Override
    public CommonListResponse<SysDataSimDetail> findAll(CommonRequest request) throws BusinessException {
        String hql = "select new com.trm.model.common.SysDataSimDetail(d.id,d.code,d.name,d.type,d.subType"
                + ",d.remarks ) from SysDataDictionary  as d where d.code  like ? order by d.sortNo";
        
        Object[] param = { "%" + request.getCode() + "%" };
        QueryPage query = null;
        
        List<SysDataSimDetail> resultList = null;
        CommonListResponse<SysDataSimDetail> response = new CommonListResponse<SysDataSimDetail>();
        
        if (0 != request.getPageNum() && 0 != request.getNum()) {
            query = new QueryPage(hql.toString(), param, request.getPageNum(), request.getNum(),
                    this.getHibernateTemplate());
            resultList = query.getResult();
            response.setPageTotal(query.getPages());
        } else {
            resultList = (List<SysDataSimDetail>) this.getHibernateTemplate().find(hql, param);
            response.setPageTotal(1);
        }
        response.setList(resultList);
        return response;
    }
    
    @Override
    public SysDataDictionary getByCode(String code) {
        String hql = "from SysDataDictionary where code =:code ";
        SysDataDictionary entity = (SysDataDictionary) this.currentSession().createQuery(hql).setParameter("code", code)
                .uniqueResult();
        return entity;
    }
    
    public List<SysDataDictionary> findServiceDomain(CommonRequest request) {
        String hql = "from SysDataDictionary where subType = '服务领域分类' and name like ?";
        List<SysDataDictionary> list = (List<SysDataDictionary>) this.currentSession().createQuery(hql)
                .setParameter(0, request.getName()).list();
        return list;
    }
    
}
