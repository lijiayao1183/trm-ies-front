package com.trm.dao.ymDown;

import com.trm.dao.common.BaseDao;
import com.trm.entity.exception.BusinessException;
import com.trm.model.ymDown.YmDownRequest;
import com.trm.model.common.CommonListResponse;
import com.trm.util.paging.QueryPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("ymDownDao")
public class YmDownDaoImpl extends BaseDao implements YmDownDao {

    public static Logger logger = LoggerFactory.getLogger(YmDownDaoImpl.class);

    @SuppressWarnings("unchecked")
    @Override
    public CommonListResponse<YmDownRequest> getAllFile(YmDownRequest request) throws BusinessException {

        List<Object> list = new ArrayList<Object>();
        Object[] param = list.toArray();

        String hql = "select new com.trm.model.ymDown.YmDownRequest(y.id, y.title, y.filePath, y.createTime)"
                + " from YmDown y"
                + " Where y.audStatus = 'A2'"
                + " order by y.createTime DESC";

        CommonListResponse<YmDownRequest> response = new CommonListResponse<YmDownRequest>();

        QueryPage queryPage = new QueryPage(hql.toString(),param,request.getPageNum(),request.getNum(),
                this.getHibernateTemplate());

        response.setPageTotal(queryPage.getPages());
        response.setList(queryPage.getResult());
        response.setCount(queryPage.getCount());

        return response;
    }
}
