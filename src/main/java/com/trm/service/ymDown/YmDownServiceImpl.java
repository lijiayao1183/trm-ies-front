package com.trm.service.ymDown;


import com.trm.constants.SystemConstants;
import com.trm.dao.ymDown.YmDownDao;
import com.trm.entity.exception.BusinessException;
import com.trm.model.ymDown.YmDownRequest;
import com.trm.model.common.CommonListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ymDownService")
@Transactional(rollbackFor = Exception.class)
public class YmDownServiceImpl implements YmDownService {

    public static Logger logger = LoggerFactory.getLogger(YmDownServiceImpl.class);

    @Autowired
    private YmDownDao ymDownDao;

    @Override
    public CommonListResponse<YmDownRequest> getAllFile(YmDownRequest request) throws BusinessException {

        CommonListResponse<YmDownRequest> response = ymDownDao.getAllFile(request);

        if (response.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("下载中心分页查询列表为空!!!!!!!!!!!!!");
        }

        return response;
    }
}
