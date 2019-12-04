package com.trm.trmserver.model;

/**
 * TrmPolicyInnovationNotice entity. @author MyEclipse Persistence Tools
 */

public class TrmPolicyInnovationNotice implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String noticeType;
	private String activityName;
	private String activityAddr;
	private String activityType;
	private String activityStartDate;
	private String activityEndDate;
	private String applyStartDate;
	private String applyEndDate;
	private String activityContent;
	private String activitySpeaker;
	private String activitySpeakerUnit;
	private String activitySpeakerProfessional;
	private String activitySpeakerPosition;
	private String activityTrainObjects;
	private String activityInObjects;
	private String activityExplain;
	private String activityCondition;
	private String activityGoal;
	private String activityPlaces;
	private String activitySponsor;
	private double activityExpenses;
	private String activityLinkman;
	private String activityTel;
	private String activityEmail;
	private String mark;
	private String province;
	private String city;
	private String area;
	private String publishDate;
	private String available;
	private String createrUser;
	private String createDate;
	private String createTime;
	private String updateUser;
	private String updateDate;
	private String updateTime;

	// Constructors

	/** default constructor */
	public TrmPolicyInnovationNotice() {
	}

	/** full constructor */
	public TrmPolicyInnovationNotice(String noticeType, String activityName,
			String activityAddr, String activityType, String activityStartDate,
			String activityEndDate, String applyStartDate, String applyEndDate,
			String activityContent, String activitySpeaker,
			String activitySpeakerUnit, String activitySpeakerProfessional,
			String activitySpeakerPosition, String activityTrainObjects,
			String activityInObjects, String activityExplain,
			String activityCondition, String activityGoal,
			String activityPlaces, String activitySponsor,
			double activityExpenses, String activityLinkman,
			String activityTel, String activityEmail, String mark,
			String province, String city, String area, String publishDate,
			String available, String createrUser, String createDate,
			String createTime, String updateUser, String updateDate,
			String updateTime) {
		this.noticeType = noticeType;
		this.activityName = activityName;
		this.activityAddr = activityAddr;
		this.activityType = activityType;
		this.activityStartDate = activityStartDate;
		this.activityEndDate = activityEndDate;
		this.applyStartDate = applyStartDate;
		this.applyEndDate = applyEndDate;
		this.activityContent = activityContent;
		this.activitySpeaker = activitySpeaker;
		this.activitySpeakerUnit = activitySpeakerUnit;
		this.activitySpeakerProfessional = activitySpeakerProfessional;
		this.activitySpeakerPosition = activitySpeakerPosition;
		this.activityTrainObjects = activityTrainObjects;
		this.activityInObjects = activityInObjects;
		this.activityExplain = activityExplain;
		this.activityCondition = activityCondition;
		this.activityGoal = activityGoal;
		this.activityPlaces = activityPlaces;
		this.activitySponsor = activitySponsor;
		this.activityExpenses = activityExpenses;
		this.activityLinkman = activityLinkman;
		this.activityTel = activityTel;
		this.activityEmail = activityEmail;
		this.mark = mark;
		this.province = province;
		this.city = city;
		this.area = area;
		this.publishDate = publishDate;
		this.available = available;
		this.createrUser = createrUser;
		this.createDate = createDate;
		this.createTime = createTime;
		this.updateUser = updateUser;
		this.updateDate = updateDate;
		this.updateTime = updateTime;
	}

	
	public TrmPolicyInnovationNotice(Integer id, String noticeType, String activityName, String activityAddr,
			String activityType, String activityStartDate, String activityEndDate, String applyStartDate,
			String applyEndDate, String activityContent, String activitySpeaker, String activitySpeakerUnit,
			String activitySpeakerProfessional, String activitySpeakerPosition, String activityTrainObjects,
			String activityInObjects, String activityExplain, String activityCondition, String activityGoal,
			String activityPlaces, String activitySponsor, double activityExpenses, String activityLinkman,
			String activityTel, String activityEmail, String mark, String province, String city, String area,
			String publishDate, String available, String createrUser, String createDate, String createTime,
			String updateUser, String updateDate, String updateTime) {
		this.id = id;
		this.noticeType = noticeType;
		this.activityName = activityName;
		this.activityAddr = activityAddr;
		this.activityType = activityType;
		this.activityStartDate = activityStartDate;
		this.activityEndDate = activityEndDate;
		this.applyStartDate = applyStartDate;
		this.applyEndDate = applyEndDate;
		this.activityContent = activityContent;
		this.activitySpeaker = activitySpeaker;
		this.activitySpeakerUnit = activitySpeakerUnit;
		this.activitySpeakerProfessional = activitySpeakerProfessional;
		this.activitySpeakerPosition = activitySpeakerPosition;
		this.activityTrainObjects = activityTrainObjects;
		this.activityInObjects = activityInObjects;
		this.activityExplain = activityExplain;
		this.activityCondition = activityCondition;
		this.activityGoal = activityGoal;
		this.activityPlaces = activityPlaces;
		this.activitySponsor = activitySponsor;
		this.activityExpenses = activityExpenses;
		this.activityLinkman = activityLinkman;
		this.activityTel = activityTel;
		this.activityEmail = activityEmail;
		this.mark = mark;
		this.province = province;
		this.city = city;
		this.area = area;
		this.publishDate = publishDate;
		this.available = available;
		this.createrUser = createrUser;
		this.createDate = createDate;
		this.createTime = createTime;
		this.updateUser = updateUser;
		this.updateDate = updateDate;
		this.updateTime = updateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityAddr() {
		return activityAddr;
	}

	public void setActivityAddr(String activityAddr) {
		this.activityAddr = activityAddr;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getActivityStartDate() {
		return activityStartDate;
	}

	public void setActivityStartDate(String activityStartDate) {
		this.activityStartDate = activityStartDate;
	}

	public String getActivityEndDate() {
		return activityEndDate;
	}

	public void setActivityEndDate(String activityEndDate) {
		this.activityEndDate = activityEndDate;
	}

	public String getApplyStartDate() {
		return applyStartDate;
	}

	public void setApplyStartDate(String applyStartDate) {
		this.applyStartDate = applyStartDate;
	}

	public String getApplyEndDate() {
		return applyEndDate;
	}

	public void setApplyEndDate(String applyEndDate) {
		this.applyEndDate = applyEndDate;
	}

	public String getActivityContent() {
		return activityContent;
	}

	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}

	public String getActivitySpeaker() {
		return activitySpeaker;
	}

	public void setActivitySpeaker(String activitySpeaker) {
		this.activitySpeaker = activitySpeaker;
	}

	public String getActivitySpeakerUnit() {
		return activitySpeakerUnit;
	}

	public void setActivitySpeakerUnit(String activitySpeakerUnit) {
		this.activitySpeakerUnit = activitySpeakerUnit;
	}

	public String getActivitySpeakerProfessional() {
		return activitySpeakerProfessional;
	}

	public void setActivitySpeakerProfessional(String activitySpeakerProfessional) {
		this.activitySpeakerProfessional = activitySpeakerProfessional;
	}

	public String getActivitySpeakerPosition() {
		return activitySpeakerPosition;
	}

	public void setActivitySpeakerPosition(String activitySpeakerPosition) {
		this.activitySpeakerPosition = activitySpeakerPosition;
	}

	public String getActivityTrainObjects() {
		return activityTrainObjects;
	}

	public void setActivityTrainObjects(String activityTrainObjects) {
		this.activityTrainObjects = activityTrainObjects;
	}

	public String getActivityInObjects() {
		return activityInObjects;
	}

	public void setActivityInObjects(String activityInObjects) {
		this.activityInObjects = activityInObjects;
	}

	public String getActivityExplain() {
		return activityExplain;
	}

	public void setActivityExplain(String activityExplain) {
		this.activityExplain = activityExplain;
	}

	public String getActivityCondition() {
		return activityCondition;
	}

	public void setActivityCondition(String activityCondition) {
		this.activityCondition = activityCondition;
	}

	public String getActivityGoal() {
		return activityGoal;
	}

	public void setActivityGoal(String activityGoal) {
		this.activityGoal = activityGoal;
	}

	public String getActivityPlaces() {
		return activityPlaces;
	}

	public void setActivityPlaces(String activityPlaces) {
		this.activityPlaces = activityPlaces;
	}

	public String getActivitySponsor() {
		return activitySponsor;
	}

	public void setActivitySponsor(String activitySponsor) {
		this.activitySponsor = activitySponsor;
	}

	public double getActivityExpenses() {
		return activityExpenses;
	}

	public void setActivityExpenses(double activityExpenses) {
		this.activityExpenses = activityExpenses;
	}

	public String getActivityLinkman() {
		return activityLinkman;
	}

	public void setActivityLinkman(String activityLinkman) {
		this.activityLinkman = activityLinkman;
	}

	public String getActivityTel() {
		return activityTel;
	}

	public void setActivityTel(String activityTel) {
		this.activityTel = activityTel;
	}

	public String getActivityEmail() {
		return activityEmail;
	}

	public void setActivityEmail(String activityEmail) {
		this.activityEmail = activityEmail;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public String getCreaterUser() {
		return createrUser;
	}

	public void setCreaterUser(String createrUser) {
		this.createrUser = createrUser;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	
}