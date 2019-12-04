package com.trm.service.msg;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trm.constants.SystemConstants;
import com.trm.dao.common.CommonDao;
import com.trm.dao.msg.MyMsgDao;
import com.trm.entity.TrmMsgHistory;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.msg.MyMsgDetail;
import com.trm.model.msg.MyMsgRequest;
import com.trm.model.session.SessionBean;
import com.trm.util.BeanUtils;
import com.trm.util.SessionUtil;

/**
 * @description
 */
@Service("myMsgService")
@Transactional(rollbackFor = Exception.class)
public class MyMsgServiceImpl implements MyMsgService {

    public static Logger logger = LoggerFactory.getLogger(MyMsgServiceImpl.class);

    @Autowired
    private MyMsgDao myMsgDao;

    @Autowired
    private CommonDao commonDao;

    @Override
    public CommonListResponse<MyMsgDetail> findAll(MyMsgRequest requestParameter) throws BusinessException {
        SessionBean sb = SessionUtil.getSesssionBean();
        Integer userid = sb.getId();
        requestParameter.setUserId(userid);
        if (null == userid) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("没有登录，请登录后再试！");
            throw bs;
        }
        CommonListResponse<MyMsgDetail> result = myMsgDao.findAll(requestParameter);
        // 信息为空时，抛出异常
        if (result.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("我的消息列表查询为空！");
            throw bs;
        }
        return result;
    }

    @Override
    public MyMsgDetail findDetailById(Integer id) throws BusinessException {
        SessionBean sb = SessionUtil.getSesssionBean();
        Integer userid = sb.getId();
        if (null == userid) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("没有登录，请登录后再试！");
            throw bs;
        }
        TrmMsgHistory entity = myMsgDao.findDetailById(id);
        if (null == entity) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("我的消息详情查询为空！");
            throw bs;
        }
        MyMsgDetail target = new MyMsgDetail();
        BeanUtils.copyProperties(entity, target);
        return target;
    }

    @Override
    public boolean deleteById(String id) throws Exception {
        SessionBean sb = SessionUtil.getSesssionBean();
        Integer userid = sb.getId();
        if (null == userid) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("没有登录，请登录后再试！");
            throw bs;
        }
        //实体
        TrmMsgHistory entity = new TrmMsgHistory();
        //根据id查询实体
        List<Object> listEntity = commonDao.findListEntity(id, entity);
        // 物理删除
        return commonDao.deleteAll(listEntity);
    }

    @Override
    public boolean updateById(String id) throws Exception {
        SessionBean sb = SessionUtil.getSesssionBean();
        Integer userid = sb.getId();
        if (null == userid) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("没有登录，请登录后再试！");
            throw bs;
        }
        return myMsgDao.updateById(id);
    }
}
