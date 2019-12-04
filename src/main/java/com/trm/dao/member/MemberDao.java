package com.trm.dao.member;

import java.util.List;

import com.trm.entity.TrmMember;
import com.trm.entity.exception.BusinessException;
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
public interface MemberDao {
	
	/**
	 * 获取正在审核中的注册用户
	 * @param creditId
	 * @return
	 */
	public TrmMember getInReviewUser(String creditId);
	
	/**
	 * 管理用户查询所创建用户列表
	 * @param id
	 * @return
	 */
	public SubMemListResponse<SubMemListDetail> getUsersList(SubMemListRequest request) throws BusinessException ;

	public TrmMember getUserinfo(Integer id);
	
	public TrmMember getUserinfoById(Integer id);
	
	public List<MyCase> getMyCases(Integer userId);
	
	public List<MyCase> getCases();
	
	public SubMemberDetail getSubMemberById(Integer id);
	
	public boolean updateSubMember(SubMemberDetail detail);
	
	public boolean resetPwd(Integer id);
	
	public boolean deletePwd(Integer id);
	
}
