package com.trm.service.linkup;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trm.constants.SystemConstants;
import com.trm.dao.common.CommonDao;
import com.trm.dao.linkup.LinkupDao;
import com.trm.dao.member.MemberDao;
import com.trm.entity.TrmLinkup;
import com.trm.entity.TrmMember;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.CommonResponse;
import com.trm.model.linkup.LinkupDetail;
import com.trm.model.linkup.LinkupDetailResponse;
import com.trm.model.linkup.LinkupListDetail;
import com.trm.model.linkup.LinkupReply;
import com.trm.model.linkup.LinkupRequest;
import com.trm.model.linkup.LinkupSimBack;
import com.trm.util.BeanUtils;
import com.trm.util.Datetime;
import com.trm.util.SessionUtil;

/**
 * 互动交流
 * @author zhaosimiao 2017-12-12 14:42:16
 */
@Service("linkupService")
@Transactional(rollbackFor = Exception.class)
public class LinkupServiceImpl implements LinkupService {

    public static Logger logger = LoggerFactory.getLogger(LinkupServiceImpl.class);
    
    @Autowired
    private LinkupDao linkupDao;
    
    @Autowired
    private MemberDao memberDao;
    
    @Autowired
    private CommonDao commonDao;
    
    @Override
	public CommonListResponse<LinkupListDetail> findLinkups(LinkupRequest request) throws BusinessException {
		CommonListResponse<LinkupListDetail> response = linkupDao.findLinkups(request);
		if (response.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("互动交流列表查询为空！");
            throw bs;
        }
		return response;
	}
    
	@Override
	public CommonListResponse<LinkupListDetail> getMyLinkups(LinkupRequest request) throws BusinessException {
		CommonListResponse<LinkupListDetail> response = linkupDao.getMyLinkups(request);
		if (response.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("互动交流列表查询为空！");
            throw bs;
        }
		return response;
	}

	@Override
	public LinkupDetailResponse getLinkup(Integer id) throws BusinessException {
		LinkupDetailResponse response = linkupDao.getLinkup(id);
        if (null == response) {
            BusinessException bs = new BusinessException();
            bs.setExceptionMsg("该id对应的互动交流信息不存在！");
            throw bs;
        }
		return response;
	}

	@Override
	public TrmLinkup getLinkupById(Integer id) throws BusinessException {
		TrmLinkup entity = linkupDao.getLinkupById(id);
        if (null == entity) {
            BusinessException bs = new BusinessException();
            bs.setExceptionMsg("该id对应的互动交流信息不存在！");
            throw bs;
        }
		return entity;
	}

	@Override
	public CommonResponse replyLinkup(LinkupReply reply) throws Exception {
		CommonResponse response = new CommonResponse();
		Date replyDate = Datetime.getLocalDate();
		reply.setReplyDate(replyDate);
		boolean flag = linkupDao.replyLinkup(reply);
		if(flag) {
			response.setCodeAndMsg("0000", "互动交流回复成功！");
		}
		else {
			response.setCodeAndMsg("9999", "互动交流回复失败！");
		}
		return response;
	}

	@Override
	public LinkupSimBack getMySimBack(Integer userId) throws BusinessException {
		LinkupSimBack response = linkupDao.getMySimBack(userId);
        if (null == response) {
            BusinessException bs = new BusinessException();
            bs.setExceptionMsg("该id对应的互动交流回显信息不存在！");
            throw bs;
        }
		return response;
	}

	@Override
	public CommonResponse createLinkup(LinkupDetail detail) throws Exception {
		CommonResponse response = new CommonResponse();
		Integer userId = SessionUtil.getUserIdFromSession();
    	if(null == userId) {
    		response.setCodeAndMsg("E0", "用户未登录，不能发布军民融合需求！");
    		return response;
    	}
		TrmMember member = memberDao.getUserinfo(userId);
		detail.setUserId(userId);
		detail.setUnitId(member.getUnitId());
		detail.setDepartId(member.getDepartId());
		detail.setIsActive("Y");
		// 默认回复状态为N
		detail.setReplyStatus("N");
		
		TrmLinkup entity = new TrmLinkup();
		BeanUtils.copyProperties(detail, entity);
		boolean createFlag = commonDao.createEntity(entity);
		if(createFlag) {
			response.setCodeAndMsg("0000", "互动交流新增成功！");
		}
		else {
			response.setCodeAndMsg("9999", "互动交流新增失败！");
		}
		return response;
	}

	
}
