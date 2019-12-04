package com.trm.dao.organ;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trm.dao.common.BaseDao;
import com.trm.entity.TrmOrgan;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.organ.OrganReq;
import com.trm.model.organ.OrganSimDetail;
import com.trm.util.Datetime;
import com.trm.util.ParameterUtils;
import com.trm.util.paging.QueryPage;

/**
 * @description 
 */
@Repository("organDao")
public class OrganDaoImpl extends BaseDao implements OrganDao {

	public static Logger logger = LoggerFactory.getLogger(OrganDaoImpl.class);

	@SuppressWarnings("unchecked")
    @Override
	public CommonListResponse<OrganSimDetail> findAll(OrganReq requestParameter) throws BusinessException {
	    List<Object> list = new ArrayList<Object>();
	    
	    Date startT = requestParameter.getAddStartTime();
        Date endT = requestParameter.getAddEndTime();
        String addWhere = "";
        if(null != startT && null != endT){
            list.add(startT);
            list.add(Datetime.getDateAmountDays(endT,1));
            addWhere = " and a.createTime >= ? and a.createTime <= ? ";
        }
	    
	    String hql = "select new com.trm.model.organ.OrganSimDetail(a.id,a.orgName,a.logoImg) "
	            + "from TrmOrgan a where 1=1 "+addWhere+" and a.orgName like ? and a.orgProperty like ? order by a.id desc";
	    list.add(ParameterUtils.getLikeParam(requestParameter.getOrgName()));
        list.add(ParameterUtils.getLikeParam(requestParameter.getOrgProperty()));
        Object[] param = list.toArray();
        List<OrganSimDetail> resultList = null;
        CommonListResponse<OrganSimDetail> response = new CommonListResponse<OrganSimDetail>();
        //QueryPage query = new QueryPage(hql.toString(), param, requestParameter.getPageNum(), requestParameter.getNum(), this.getHibernateTemplate());
        //response.setPageTotal(query.getPages());
        //response.setList(query.getResult());
        QueryPage query = null;
        if (0 != requestParameter.getPageNum() && 0 != requestParameter.getNum()) {
            query = new QueryPage(hql.toString(), param, requestParameter.getPageNum(), requestParameter.getNum(), this.getHibernateTemplate());
            resultList = query.getResult();
            response.setPageTotal(query.getPages());
            response.setCount(query.getCount());
        } else {
            resultList = (List<OrganSimDetail>) this.getHibernateTemplate().find(hql, param);
            response.setPageTotal(1);
            response.setCount(resultList.size());
        }
        response.setList(resultList);
        return response;
	}
	
    @Override
    public TrmOrgan findDetailById(Integer id) throws BusinessException {
        String hql = "SELECT NEW com.trm.entity.TrmOrgan(a.orgName, a.url, a.logoImg,a.displayImg, a.establishDate, a.phone,a.address, "
                + "(SELECT b.name FROM SysDataDictionary b where b.code = a.orgProperty) as orgProperty, "
                + "a.orgBrief,a.research,a.isActive, a.creator, a.createTime,a.updater, a.updateTime, a.viewCount) from TrmOrgan a where a.id =:id ";
        TrmOrgan Detail = (TrmOrgan) this.currentSession().createQuery(hql).setParameter("id", id).uniqueResult();
        Detail.setId(id);
        return Detail;
    }
    
    @Override
	public boolean viewCount(Integer id, Integer viewCount) {
		boolean flag = false;
		String sql = "update TrmOrgan r set r.viewCount = ? where r.id = ?";
		int a = this.currentSession().createQuery(sql)
						.setParameter(0, viewCount)
						.setParameter(1, id)
						.executeUpdate();
		if(a == 1){
			flag = true;
		}
		return flag;
	}
    
    @SuppressWarnings("unchecked")
    @Override
	public List<OrganSimDetail> findOrganTop() throws BusinessException {
	    String sql = "select new com.trm.model.organ.OrganSimDetail(a.id,a.orgName,a.logoImg) from TrmOrgan a order by a.viewCount desc";
	    QueryPage query = new QueryPage(sql, null, 1, 3, this.getHibernateTemplate());
		return query.getResult();
	}
}
