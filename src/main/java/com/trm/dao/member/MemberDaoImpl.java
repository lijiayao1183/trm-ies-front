package com.trm.dao.member;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.common.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trm.dao.common.BaseDao;
import com.trm.entity.TrmMember;
import com.trm.entity.exception.BusinessException;
import com.trm.model.member.MyCase;
import com.trm.model.member.SubMemHeadInfo;
import com.trm.model.member.SubMemListDetail;
import com.trm.model.member.SubMemListRequest;
import com.trm.model.member.SubMemListResponse;
import com.trm.model.member.SubMemberDetail;
import com.trm.util.ParameterUtils;
import com.trm.util.paging.QueryPage;

/**
 * 个人中心-基本信息
 * @author zhaosimiao
 * @Date 2017-10-10 13:36:36
 */
@Repository("memberDao")
public class MemberDaoImpl extends BaseDao implements MemberDao {
    
    public static Logger logger = LoggerFactory.getLogger(MemberDaoImpl.class);

	@Override
	public TrmMember getInReviewUser(String creditId) {
		String hql = "from TrmMember where creditId =:creditId and audStatus = 'R0'";
        TrmMember entity = (TrmMember) this.currentSession().createQuery(hql).setParameter("creditId", creditId).uniqueResult();
        return entity;
	}

    @Override
    public TrmMember getUserinfo(Integer id) {
        String hql = "from TrmMember where id =:id ";
        TrmMember entity = (TrmMember) this.currentSession().createQuery(hql).setParameter("id", id).uniqueResult();
        return entity;
    }
    
    @Override
    public TrmMember getUserinfoById(Integer id) {
        // modify by zhaosimiao 2017-11-8 16:30:52
        String hql = "select new com.trm.entity.TrmMember(id, username, password, nickName, "
                + "phone, email, qq, weChat, headPortrait, problem, answer, userType, orgName, orgProperty, "
                + "isListed, isHighNew, " + "(select name from SysDataDictionary where master = code) as master, "
                + "orgBrief, licensePdf, promisePdf, linkPerson, "
                + "department, numberId, province, city, area, address, audStatus, audDate, audOpinion, "
                + "audPerson, remark, isActive, creator, createTime, updater, updateTime, "
                + "isNtblisted, isWepermited, isWeqkept, "
                + "(select name from SysDataDictionary where masterType = code) as masterType, creditId "
                + ") from TrmMember where id =:id ";
        TrmMember entity = (TrmMember) this.currentSession().createQuery(hql).setParameter("id", id).uniqueResult();
        return entity;
    }
    
    @Override
    public SubMemberDetail getSubMemberById(Integer id) {
        String hql = "select new com.trm.model.member.SubMemberDetail(id, unitId, departId, masterId, username, "
                + " linkPerson, password, phone, email, userType, orgName, department)"
                + " from TrmMember where id =:id ";
        SubMemberDetail detail = (SubMemberDetail) this.currentSession().createQuery(hql).setParameter("id", id)
                .uniqueResult();
        return detail;
    }
    
    @Override
    public List<MyCase> getMyCases(Integer userId) {
        
        String equip_hql = "select new com.trm.model.member.MyCase('我的设备' as caseName, count(id) as caseNum)"
                + " from TrmEquip where orgId =:userId and isActive = 'Y'";
        String care_hql = "select new com.trm.model.member.MyCase('我的关注' as caseName, count(id) as caseNum)"
                + " from TrmEqpReq where orgId =:userId and focusStatus = 'Y' and regId = '0'";
        String eval_hql = "select new com.trm.model.member.MyCase('我的评论' as caseName, count(id) as caseNum)"
                + " from TrmEvaluation where regId =:userId";
        String msg_hql = "select new com.trm.model.member.MyCase('我的消息' as caseName, count(id) as caseNum)"
                + " from TrmMsgHistory where regId =:userId";
        String req_hql = "select new com.trm.model.member.MyCase('我的需求' as caseName, count(id) as caseNum)"
                + " from TrmDemand where memberId =:userId and isActive = 'Y'";
        String user_hql = "select new com.trm.model.member.MyCase('我的用户' as caseName, count(id)-1 as caseNum)"
                + " from TrmMember where masterId =:userId";
        String link_hql = "select new com.trm.model.member.MyCase('我的互动' as caseName, count(a.id) as caseNum)"
                + " from TrmLinkup a, TrmMember b where a.userId = b.id and b.masterId =:userId";
        
        List<MyCase> myCaseList = new ArrayList<MyCase>();
        
        MyCase equip = (MyCase) this.currentSession().createQuery(equip_hql).setParameter("userId", userId)
                .uniqueResult();
        MyCase care = (MyCase) this.currentSession().createQuery(care_hql).setParameter("userId", userId)
                .uniqueResult();
        MyCase eval = (MyCase) this.currentSession().createQuery(eval_hql).setParameter("userId", userId)
                .uniqueResult();
        MyCase msg = (MyCase) this.currentSession().createQuery(msg_hql).setParameter("userId", userId).uniqueResult();
        MyCase req = (MyCase) this.currentSession().createQuery(req_hql).setParameter("userId", userId).uniqueResult();
        MyCase user = (MyCase) this.currentSession().createQuery(user_hql).setParameter("userId", userId)
                .uniqueResult();
        MyCase link = (MyCase) this.currentSession().createQuery(link_hql).setParameter("userId", userId)
                .uniqueResult();
        
        myCaseList.add(equip);
        myCaseList.add(care);
        myCaseList.add(eval);
        myCaseList.add(msg);
        myCaseList.add(req);
        myCaseList.add(user);
        myCaseList.add(link);
        
        return myCaseList;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public SubMemListResponse<SubMemListDetail> getUsersList(SubMemListRequest request) throws BusinessException {
        List<Object> list = new ArrayList<Object>();
        String username = request.getUsername();
        String usernameHql = "";
        if (StringHelper.isNotEmpty(username)) {
            list.add(ParameterUtils.getLikeParam(username));
            usernameHql = " and a.username like ? ";
        }
        String department = request.getDepartment();
        String departmentHql = "";
        if (StringHelper.isNotEmpty(department)) {
            list.add(ParameterUtils.getEqualParam(department));
            departmentHql = " and a.department = ? ";
        }
        Integer masterId = request.getMasterId();
        list.add(masterId);
        
        Object[] param = list.toArray();
        
        String hql =
                "select new com.trm.model.member.SubMemListDetail(a.id, a.username, a.linkPerson, a.phone, a.email, a.department, a.createTime)"
                        + " from TrmMember a where 1=1" + usernameHql + departmentHql + " and a.masterId = ?"
                        + " order by a.updateTime desc";
        
        SubMemListResponse<SubMemListDetail> response = new SubMemListResponse<SubMemListDetail>();
        QueryPage query = new QueryPage(hql.toString(), param, request.getPageNum(), request.getNum(),
                this.getHibernateTemplate());
        response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        
        // 查询头部展示信息
        String headInfoHql =
                "select new com.trm.model.member.SubMemHeadInfo(a.username as handler, a.orgName as unitName, a.department)"
                        + " from TrmMember a" + " where a.id = ?";
        SubMemHeadInfo headInfo = (SubMemHeadInfo) this.currentSession().createQuery(headInfoHql)
                .setParameter(0, masterId).uniqueResult();
        response.setHeadInfo(headInfo);
        
        return response;
    }
    
    @Override
    public List<MyCase> getCases() {
        
        String dayusers = "select new com.trm.model.member.MyCase('dayusers' as caseName, count(id) as caseNum) from TrmMember where audStatus = 'R1' and loginDate between current_date() and current_date() + 1";
        String users = "select new com.trm.model.member.MyCase('users' as caseName, count(id) as caseNum) from TrmMember where audStatus = 'R1'";
        String equips = "select new com.trm.model.member.MyCase('equips' as caseName, count(id) as caseNum) from TrmEquip where audStatus = 'F2' and isDisplay = 'Y'";
        String requires = "select new com.trm.model.member.MyCase('requires' as caseName, count(id) as caseNum) from TrmRequire where audStatus = 'F2'";
        
        List<MyCase> myCaseList = new ArrayList<MyCase>();
        
        MyCase dayuser = (MyCase) this.currentSession().createQuery(dayusers).uniqueResult();
        MyCase user = (MyCase) this.currentSession().createQuery(users).uniqueResult();
        MyCase equip = (MyCase) this.currentSession().createQuery(equips).uniqueResult();
        MyCase require = (MyCase) this.currentSession().createQuery(requires).uniqueResult();
        
        myCaseList.add(dayuser);
        myCaseList.add(user);
        myCaseList.add(equip);
        myCaseList.add(require);
        
        return myCaseList;
    }
    
    @Override
    public boolean updateSubMember(SubMemberDetail detail) {
        boolean flag = false;
        String sql = "update TrmMember a set a.linkPerson = ?,a.phone = ?,a.email = ?,a.department = ? where a.id = ?";
        int a = this.currentSession().createQuery(sql).setParameter(0, detail.getLinkPerson())
                .setParameter(1, detail.getPhone()).setParameter(2, detail.getEmail())
                .setParameter(3, detail.getDepartment()).setParameter(4, detail.getId()).executeUpdate();
        if (a == 1) {
            flag = true;
        }
        return flag;
    }
    
    @Override
    public boolean resetPwd(Integer id) {
        boolean flag = false;
        String sql = "update TrmMember a set a.password = 'E99A18C428CB38D5F260853678922E03' where a.id = ?";
        int a = this.currentSession().createQuery(sql).setParameter(0, id).executeUpdate();
        if (a == 1) {
            flag = true;
        }
        return flag;
    }
    
    @Override
    public boolean deletePwd(Integer id) {
        boolean flag = false;
        String sql = "update TrmMember a set a.password = '' where a.id = ?";
        int a = this.currentSession().createQuery(sql).setParameter(0, id).executeUpdate();
        if (a == 1) {
            flag = true;
        }
        return flag;
    }

}
