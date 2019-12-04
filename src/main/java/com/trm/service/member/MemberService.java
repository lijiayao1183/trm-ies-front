package com.trm.service.member;

import java.util.List;

import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonResponse;
import com.trm.model.member.MemberDetail;
import com.trm.model.member.MyCase;
import com.trm.model.member.SubMemListDetail;
import com.trm.model.member.SubMemListRequest;
import com.trm.model.member.SubMemListResponse;
import com.trm.model.member.SubMemberDetail;

/**
 * 个人中心-基本信息
 * @author zhaosimiao
 * @Date 2017-10-10 13:36:36
 */
public interface MemberService {
	
	/**
	 * 管理用户查询所创建用户列表
	 * @param id
	 * @return
	 */
	public SubMemListResponse<SubMemListDetail> getUsersList(SubMemListRequest request) throws BusinessException ;
	
    public MemberDetail getUserinfoById(Integer userId);
    
    public CommonResponse changeUserinfo(MemberDetail detail)throws Exception;
    
    public List<MyCase> getMyCases(Integer userId);
    
    public List<MyCase> getCases();
    
    public SubMemberDetail getSubMemberById(Integer id);
    
    /**
     * 创建子用户
     * add by zhaosimiao 2017-11-24 10:36:16
     * @param detail
     * @return
     * @throws Exception
     */
    public CommonResponse createSubMember(SubMemberDetail detail)throws Exception;
    
    public CommonResponse modifySubMember(SubMemberDetail detail)throws Exception;
    
    public CommonResponse deleteSubMember(String id) throws Exception;
    
    public CommonResponse resetPwd(Integer id);
    
	public boolean checkUser(String username);
}
