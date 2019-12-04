package com.trm.service.organ;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trm.constants.SystemConstants;
import com.trm.dao.common.CommonDao;
import com.trm.dao.organ.OrganDao;
import com.trm.entity.TrmEquip;
import com.trm.entity.TrmOrgan;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.organ.OrganDetail;
import com.trm.model.organ.OrganReq;
import com.trm.model.organ.OrganSimDetail;
import com.trm.util.BeanUtils;

/**
 * @description
 */
@Service("organService")
@Transactional(rollbackFor = Exception.class)
public class OrganServiceImpl implements OrganService {

    public static Logger logger = LoggerFactory.getLogger(OrganServiceImpl.class);

    @Autowired
    private OrganDao organDao;

    @Autowired
    private CommonDao commonDao;

    @Override
    public CommonListResponse<OrganSimDetail> findAll(OrganReq requestParameter) throws BusinessException {
        CommonListResponse<OrganSimDetail> result = organDao.findAll(requestParameter);
        // 信息为空时，抛出异常
        if (result.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("机构（推荐）配置列表查询为空！");
            throw bs;
        }
        return result;
    }

    @Override
    public OrganDetail findDetailById(Integer id) throws BusinessException {
        TrmOrgan entity = organDao.findDetailById(id);
        if (null == entity) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("机构（推荐）配置详情查询为空！");
            throw bs;
        }
        OrganDetail target = new OrganDetail();
        BeanUtils.copyProperties(entity, target);
        return target;
    }
    
    @Override
    public boolean createEquip(OrganDetail requestParameter) throws Exception {
        TrmOrgan entity = new TrmOrgan();
        BeanUtils.copyProperties(requestParameter, entity);
        entity.setIsActive(SystemConstants.FLAG_Y);
        return commonDao.createEntity(entity);
    }
    
    @Override
    public boolean deleteById(String id) throws Exception {
        //实体
        TrmEquip entity = new TrmEquip();
        //根据id查询实体
        List<Object> listEntity = commonDao.findListEntity(id, entity);
        // 物理删除
        return commonDao.deleteAll(listEntity);
    }
    
    @Override
    public boolean modifyEquip(OrganDetail requestParameter) throws Exception {
        TrmOrgan info = organDao.findDetailById(requestParameter.getId());
        BeanUtils.copyProperties(requestParameter, info);
        return commonDao.modifyEntity(info);
    }
    
	@Override
	public boolean viewCount(Integer id, Integer viewCount) {
		return organDao.viewCount(id, viewCount);
	}
	
	@Override
	public List<OrganSimDetail> findOrganTop() throws BusinessException {
		return organDao.findOrganTop();
	}
	
}
