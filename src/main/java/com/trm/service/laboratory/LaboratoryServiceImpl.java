package com.trm.service.laboratory;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trm.constants.SystemConstants;
import com.trm.dao.common.CommonDao;
import com.trm.dao.laboratory.LaboratoryDao;
import com.trm.entity.TrmKeyLaboratory;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.laboratory.LaboratoryDetail;
import com.trm.model.laboratory.LaboratoryReq;
import com.trm.model.laboratory.LaboratorySimDetail;
import com.trm.util.BeanUtils;

/**
 * @description
 */
@Service("laboratoryService")
@Transactional(rollbackFor = Exception.class)
public class LaboratoryServiceImpl implements LaboratoryService {

    public static Logger logger = LoggerFactory.getLogger(LaboratoryServiceImpl.class);

    @Autowired
    private LaboratoryDao laboratoryDao;

    @Autowired
    private CommonDao commonDao;

    @Override
    public CommonListResponse<LaboratorySimDetail> findAll(LaboratoryReq requestParameter) throws BusinessException {
        CommonListResponse<LaboratorySimDetail> result = laboratoryDao.findAll(requestParameter);
        // 信息为空时，抛出异常
        if (result.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("技术服务机构列表查询为空！");
            throw bs;
        }
        //String[] multiKeys = StringUtils.split(result.getList().get, SystemConstants.SYSTEM_COMMA);
        //List<Integer> list = new ArrayList<>();
        //for (String c : multiKeys) {
        //    list.add(Integer.valueOf(c));
        //}
        return result;
    }

    @Override
    public LaboratoryDetail findDetailById(Integer id) throws BusinessException {
        TrmKeyLaboratory entity = laboratoryDao.findDetailById(id);
        if (null == entity) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("技术服务机构详情查询为空！");
            throw bs;
        }
        LaboratoryDetail target = new LaboratoryDetail();
        BeanUtils.copyProperties(entity, target);
        return target;
    }
    
    @Override
    public boolean createEquip(LaboratoryDetail requestParameter) throws Exception {
        TrmKeyLaboratory entity = new TrmKeyLaboratory();
        BeanUtils.copyProperties(requestParameter, entity);
        entity.setIsActive(SystemConstants.FLAG_Y);
        return commonDao.createEntity(entity);
    }
    
    @Override
    public boolean deleteById(String id) throws Exception {
        //实体
        TrmKeyLaboratory entity = new TrmKeyLaboratory();
        //根据id查询实体
        List<Object> listEntity = commonDao.findListEntity(id, entity);
        // 物理删除
        return commonDao.deleteAll(listEntity);
    }
    
    @Override
    public boolean modifyEquip(LaboratoryDetail requestParameter) throws Exception {
        TrmKeyLaboratory info = laboratoryDao.findDetailById(requestParameter.getId());
        BeanUtils.copyProperties(requestParameter, info);
        return commonDao.modifyEntity(info);
    }
    
	@Override
	public boolean viewCount(Integer id, Integer viewCount) {
		return laboratoryDao.viewCount(id, viewCount);
	}
    
	@Override
	public List<LaboratorySimDetail> findLaboratoryTop() throws BusinessException {
		return laboratoryDao.findLaboratoryTop();
	}
}
