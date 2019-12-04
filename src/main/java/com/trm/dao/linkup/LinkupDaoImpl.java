package com.trm.dao.linkup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trm.dao.common.BaseDao;
import com.trm.entity.TrmLinkup;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.linkup.LinkupDetailResponse;
import com.trm.model.linkup.LinkupListDetail;
import com.trm.model.linkup.LinkupReply;
import com.trm.model.linkup.LinkupRequest;
import com.trm.model.linkup.LinkupSimBack;
import com.trm.util.Datetime;
import com.trm.util.ParameterUtils;
import com.trm.util.paging.QueryPage;

/**
 * 互动交流
 * @author zhaosimiao 2017-12-12 11:01:11
 */
@Repository("linkupDao")
public class LinkupDaoImpl extends BaseDao implements LinkupDao {

	public static Logger logger = LoggerFactory.getLogger(LinkupDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public CommonListResponse<LinkupListDetail> findLinkups(LinkupRequest request) throws BusinessException {
		
		String hql = "select new com.trm.model.linkup.LinkupListDetail(a.id, a.title, b.orgName, "
				+ " b.department, b.username, a.createTime, a.replyDate, a.replyStatus)"
				+ " from TrmLinkup a, TrmMember b"
				+ " where a.userId = b.id"
				+ " and a.replyStatus = 'Y'"
				+ " order by a.updateTime desc";
		
		CommonListResponse<LinkupListDetail> response = new CommonListResponse<LinkupListDetail>();
		
		QueryPage query = new QueryPage(hql.toString(), null, request.getPageNum(), request.getNum(), this.getHibernateTemplate());
		
		response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CommonListResponse<LinkupListDetail> getMyLinkups(LinkupRequest request) throws BusinessException {
		
		// 1. 定义 查询语句
		String leaveTimeHql = "";
		String replyTimeHql = "";
		String hql = "";
		
		//　2. 定义查询参数
		List<Object> list = new ArrayList<Object>();
		// 用户id
		Integer userId  = request.getUserId();
		list.add(userId);
		list.add(userId);
		String unitName = request.getUnitName();
		String unitNameHql = "";
		String department = request.getDepartment();
		String departmentHql = "";
		if(StringUtils.isNotEmpty(unitName)) {
			unitNameHql = " and b.orgName = ?";
			list.add(ParameterUtils.getEqualParam(unitName));
		}
		if(StringUtils.isNotEmpty(department)) {
			departmentHql = " and b.department = ?";
			list.add(ParameterUtils.getEqualParam(department));
		}
		// 标题
		String title = request.getTitle();
		list.add(ParameterUtils.getLikeParam(title));
		// 回复状态
		String replyStatus = request.getReplyStatus();
		list.add(ParameterUtils.getLikeParam(replyStatus));
		// 用户名
		String username = request.getUsername();
		list.add(ParameterUtils.getLikeParam(username));
		// 联系人
		String linkMan = request.getLinkMan();
		list.add(ParameterUtils.getLikeParam(linkMan));
		// 留言开始时间-结束时间
		Date leaveStartTime = request.getLeaveStartTime();
		Date leaveEndTime = request.getLeaveEndTime();
		if(leaveStartTime != null && leaveEndTime == null) {
			list.add(leaveStartTime);
			leaveTimeHql = " and a.createTime >= ?";
		}
		else if(leaveStartTime == null && leaveEndTime != null) {
			list.add(Datetime.getDateAmountDays(leaveEndTime,1));
			leaveTimeHql = " and a.createTime <= ?";
		}
		else if(leaveStartTime != null && leaveEndTime != null) {
			list.add(leaveStartTime);
			list.add(Datetime.getDateAmountDays(leaveEndTime,1));
			leaveTimeHql = " and (a.createTime between ? and ?)";
		}
		
		// 回复开始时间-结束时间
		Date replyStartTime = request.getReplyStartTime();
		Date replyEndTime = request.getReplyEndTime();
		
		if(replyStartTime != null && replyEndTime == null) {
			list.add(replyStartTime);
			replyTimeHql = " and a.replyDate >= ?";
		}
		else if(replyStartTime == null && replyEndTime != null) {
			list.add(Datetime.getDateAmountDays(replyEndTime,1));
			replyTimeHql = " and a.replyDate <= ?";
		}
		else if(replyStartTime != null && replyEndTime != null) {
			list.add(replyStartTime);
			list.add(Datetime.getDateAmountDays(replyEndTime,1));
			replyTimeHql = " and (a.replyDate between ? and ?)";
		}

		hql = "select new com.trm.model.linkup.LinkupListDetail(a.id, a.title, b.orgName, "
				+ " b.department, b.username, a.createTime, a.replyDate, a.replyStatus)"
				+ " from TrmLinkup a, TrmMember b"
				+ " where a.userId = b.id"
				+ " and (a.userId = ? or b.masterId = ?)"
				+ unitNameHql
				+ departmentHql
				+ " and a.title like ?"
				+ " and a.replyStatus like ?"
				+ " and b.username like ?"
				+ " and b.linkPerson like ?"
				+ leaveTimeHql
				+ replyTimeHql
				+ " order by a.updateTime desc";
		
		Object[] param = list.toArray();
		
		// 3. 定义返回参数
		CommonListResponse<LinkupListDetail> response = new CommonListResponse<LinkupListDetail>();
		
		// 4. 执行查询语句
		QueryPage query = new QueryPage(hql.toString(), param, request.getPageNum(), request.getNum(), this.getHibernateTemplate());
		
		response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        
		return response;
	}

	@Override
	public TrmLinkup getLinkupById(Integer id) throws BusinessException {
		String hql = "from TrmLinkup where id =:id ";
		TrmLinkup detail = (TrmLinkup) this.currentSession().createQuery(hql).setParameter("id", id).uniqueResult();
        return detail;
	}

	@Override
	public LinkupDetailResponse getLinkup(Integer id) throws BusinessException {
		String hql = "select new com.trm.model.linkup.LinkupDetailResponse(a.id, b.username, b.linkPerson, "
				+ " b.orgName, b.department, b.phone, b.email, "
				+ " a.title, a.leaveMsg, a.createTime, a.replyMsg, a.replyStatus, a.replyDate, a.replyPerson)"
				+ " from TrmLinkup a, TrmMember b"
				+ " where a.userId = b.id"
				+ " and a.id =:id";
		LinkupDetailResponse detail = (LinkupDetailResponse) this.currentSession().createQuery(hql).setParameter("id", id).uniqueResult();
        return detail;
	}
	
	@Override
	public boolean replyLinkup(LinkupReply reply) throws Exception {
		boolean flag = false;
		String hql = "update TrmLinkup a set a.replyStatus = ?, a.replyPerson = ?, a.replyMsg = ?, a.replyDate = ? where a.id = ? ";
		int count = this.currentSession().createQuery(hql)
						.setParameter(0, reply.getReplyStatus())
						.setParameter(1, reply.getReplyPerson())
						.setParameter(2, reply.getReplyMsg())
						.setParameter(3, reply.getReplyDate())
						.setParameter(4, reply.getId())
						.executeUpdate();
		if(count == 1){
			flag = true;
		}
		return flag;
	}

	@Override
	public LinkupSimBack getMySimBack(Integer userId) throws BusinessException {
		String hql = "select new com.trm.model.linkup.LinkupSimBack(b.username, b.linkPerson, "
				+ " b.orgName, b.department, b.phone, b.email)"
				+ " from TrmMember b"
				+ " where b.id=:id";
		LinkupSimBack detail = (LinkupSimBack) this.currentSession().createQuery(hql).setParameter("id", userId).uniqueResult();
        return detail;
	}

}
