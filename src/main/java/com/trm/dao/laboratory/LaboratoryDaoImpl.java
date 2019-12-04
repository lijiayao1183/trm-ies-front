package com.trm.dao.laboratory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trm.dao.common.BaseDao;
import com.trm.entity.TrmKeyLaboratory;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.laboratory.LaboratoryReq;
import com.trm.model.laboratory.LaboratorySimDetail;
import com.trm.util.Datetime;
import com.trm.util.ParameterUtils;
import com.trm.util.paging.QueryPage;

/**
 * @description 
 */
@Repository("laboratoryDao")
public class LaboratoryDaoImpl extends BaseDao implements LaboratoryDao {

	public static Logger logger = LoggerFactory.getLogger(LaboratoryDaoImpl.class);

	@SuppressWarnings("unchecked")
    @Override
	public CommonListResponse<LaboratorySimDetail> findAll(LaboratoryReq requestParameter) throws BusinessException {
	    List<Object> list = new ArrayList<Object>();
	    Date startT = requestParameter.getCreateStartTime();
        Date endT = requestParameter.getCreateEndTime();
        String createTimeWhere = "";
        if(null != startT && null != endT){
            list.add(startT);
            list.add(Datetime.getDateAmountDays(endT,1));
            createTimeWhere = " and a.createTime >= ? and a.createTime <= ? ";
        }
	    String hql = "select new com.trm.model.laboratory.LaboratorySimDetail(a.id, a.labName, a.img) "
	            + "from TrmKeyLaboratory a where 1=1 "+createTimeWhere+"and a.labName like ? and a.unitName like ? order by a.createTime desc";
	    list.add(ParameterUtils.getLikeParam(requestParameter.getLabName()));
        list.add(ParameterUtils.getLikeParam(requestParameter.getUnitName()));
        Object[] param = list.toArray();

        CommonListResponse<LaboratorySimDetail> response = new CommonListResponse<LaboratorySimDetail>();
        QueryPage query = new QueryPage(hql.toString(), param, requestParameter.getPageNum(), requestParameter.getNum(), this.getHibernateTemplate());
        response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        return response;
	}
	
    @Override
    public TrmKeyLaboratory findDetailById(Integer id) throws BusinessException {
        String hql = "from TrmKeyLaboratory where id =:id ";
        TrmKeyLaboratory Detail = (TrmKeyLaboratory) this.currentSession().createQuery(hql).setParameter("id", id).uniqueResult();
        return Detail;
    }
    
	@Override
	public boolean viewCount(Integer id, Integer viewCount) {
		boolean flag = false;
		String sql = "update TrmKeyLaboratory r set r.viewCount = ? where r.id = ?";
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
	public List<LaboratorySimDetail> findLaboratoryTop() throws BusinessException {
		String sql = "select new com.trm.model.laboratory.LaboratorySimDetail(a.id, a.labName, a.img) from TrmKeyLaboratory a order by a.viewCount desc";
		QueryPage query = new QueryPage(sql, null, 1, 2, this.getHibernateTemplate());
		return query.getResult();
	}
}
