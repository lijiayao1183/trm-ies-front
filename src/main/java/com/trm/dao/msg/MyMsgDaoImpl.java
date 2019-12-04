package com.trm.dao.msg;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.common.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trm.constants.SystemConstants;
import com.trm.dao.common.BaseDao;
import com.trm.entity.TrmMsgHistory;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.msg.MyMsgDetail;
import com.trm.model.msg.MyMsgRequest;
import com.trm.model.news.NewsListResponse;
import com.trm.util.Datetime;
import com.trm.util.ParameterUtils;
import com.trm.util.paging.QueryPage;

/**
 * @description 
 */
@Repository("myMsgDao")
public class MyMsgDaoImpl extends BaseDao implements MyMsgDao {

	public static Logger logger = LoggerFactory.getLogger(MyMsgDaoImpl.class);

	@SuppressWarnings("unchecked")
    @Override
	public CommonListResponse<MyMsgDetail> findAll(MyMsgRequest requestParameter) throws BusinessException {
	    List<Object> list = new ArrayList<Object>();
	    Date startT = requestParameter.getCreateStartTime();
        Date endT = requestParameter.getCreateEndTime();
        String where = "";
        if(null != startT && null != endT){
            list.add(startT);
            list.add(Datetime.getDateAmountDays(endT,1));
            where += " and createTime >= ? and createTime <= ? ";
        }
        
        String readingState = requestParameter.getReadingState();
        if(StringHelper.isNotEmpty(readingState)){
            list.add(readingState);
            where += " and readingState = ? ";
        }
        String content = requestParameter.getContent();
        if(StringHelper.isNotEmpty(content)){
            list.add(ParameterUtils.getLikeParam(content));
            where += " and content like ? ";
        }
	    String hql = "select new com.trm.model.msg.MyMsgDetail(id, msgName, content, readingState, createTime) "
                + "from TrmMsgHistory where 1=1 " + where + "and regId = ? order by id desc";
	    list.add(requestParameter.getUserId());
        Object[] param = list.toArray();

        NewsListResponse<MyMsgDetail> response = new NewsListResponse<MyMsgDetail>();
        QueryPage query = new QueryPage(hql.toString(), param, requestParameter.getPageNum(), requestParameter.getNum(), this.getHibernateTemplate());
        response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        return response;
	}
	
    @Override
    public TrmMsgHistory findDetailById(Integer id) throws BusinessException {
        String hql = "from TrmMsgHistory where id =:id ";
        TrmMsgHistory Detail = (TrmMsgHistory) this.currentSession().createQuery(hql).setParameter("id", id).uniqueResult();
        return Detail;
    }
    
    @Override
    public boolean updateById(String id) throws Exception {
        String[] multiKeys = StringUtils.split(id, SystemConstants.SYSTEM_COMMA);
        List<Integer> list = new ArrayList<>();
        for (String c : multiKeys) {
            list.add(Integer.valueOf(c));
        }
        String hql = "update TrmMsgHistory set readingState = 'Y' where id in (:id) ";
        int a = this.currentSession().createQuery(hql).setParameterList("id", list).executeUpdate();
        boolean flag = false;
        if(a > 0){
            flag = true;
        }
        return flag;
    }
}
