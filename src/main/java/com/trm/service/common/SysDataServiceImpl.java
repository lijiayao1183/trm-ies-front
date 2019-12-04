package com.trm.service.common;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trm.constants.SystemConstants;
import com.trm.dao.common.SysDataDao;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.CommonRequest;
import com.trm.model.common.SysDataSimDetail;
import com.trm.model.common.UnitResponse;
import com.trm.util.BeanUtils;
import com.trm.util.CommonUtil;

@Service("sysDataService")
@Transactional(rollbackFor = Exception.class)
public class SysDataServiceImpl implements SysDataService {
    static Logger logger = LoggerFactory.getLogger(SysDataServiceImpl.class);

    @Autowired
    private SysDataDao sysDataDao;

    @Override
    public CommonListResponse<SysDataSimDetail> findAll(CommonRequest request) throws BusinessException {
        CommonListResponse<SysDataSimDetail> response = sysDataDao.findAll(request);
        if (response.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("查询数据字典列表信息为空");
            throw bs;
        }
        return response;
    }

    @Override
    public List<UnitResponse> unitLinkage() throws BusinessException {
        CommonRequest request = new CommonRequest();
        request.setCode("UNIT");
        CommonListResponse<SysDataSimDetail> response = sysDataDao.findAll(request);
        if (response.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("查询联动数据字典列表信息为空");
            throw bs;
        }
        List<UnitResponse> parentList = null;
        List<UnitResponse> subList = null;
        List<SysDataSimDetail> list = response.getList();
        parentList = getsubList(list, "0");
        if (CommonUtil.isNotNull(parentList)){
            for(UnitResponse menu : parentList){
                subList = getsubList(list, menu.getCode());
                if (CommonUtil.isNotNull(subList)){
                    menu.setSubList(subList);
                }
            }
        }
                
        return parentList;
    }
    
    /**
     * 获取父节点下的节点列表
     * @param list
     * @param parent 父级code
     * @author huyuanbo
     * @return
     */
    private static List<UnitResponse> getsubList(List<SysDataSimDetail> list,String parent){
        if (!CommonUtil.isNotNull(list,parent)){
            logger.error("req params is valid!");
            return null;
        }
        List<UnitResponse> result = new ArrayList<>();
        UnitResponse menuRes = null;
        try {
            for (SysDataSimDetail menu : list) {
                //判断父节点，构建子节点LIST
                if (menu.getSubType().equals(parent)) {
                    menuRes = new UnitResponse();
                    BeanUtils.copyProperties(menu, menuRes);
                    result.add(menuRes);
                }
            }
            return result;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }
}
