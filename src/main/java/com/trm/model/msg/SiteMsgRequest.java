package com.trm.model.msg;

/**
 * 站内消息请求类
 * @author zhaosimiao 2017-6-20 09:41:52
 */
public class SiteMsgRequest {
	
	private Integer userId;
	
	/**
	 * 消息发送类型
	 * 1. 注册审核通过：           SITEMSG-USERPASS
	 * 2. 设备发布审核通过：   SITEMSG-DEVYPASS
	 * 3. 设备发布审核不通过：SITEMSG-DEVNPASS
	 * 4. 后端下架提醒：            SITEMSG-DEVNPLAY
	 * 5. 立即预约提醒：            SITEMSG-DEVORDER
	 */
	private String siteMsgType;
	
	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 注册/申请/上架/预约时间
	 */
	private String dateTime;
	
	/**
	 * 预约设备id
	 */
	private String equipId;
	
	/**
	 * 设备设施名称
	 */
	private String equipName;
	
	/**
	 * 预约用户名
	 */
	private String orderUser;
	
	/**
	 * 预约用户注册手机号码
	 */
	private String orderMobile;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getSiteMsgType() {
		return siteMsgType;
	}

	public void setSiteMsgType(String siteMsgType) {
		this.siteMsgType = siteMsgType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getEquipId() {
		return equipId;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}

	public String getEquipName() {
		return equipName;
	}

	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}

	public String getOrderUser() {
		return orderUser;
	}

	public void setOrderUser(String orderUser) {
		this.orderUser = orderUser;
	}

	public String getOrderMobile() {
		return orderMobile;
	}

	public void setOrderMobile(String orderMobile) {
		this.orderMobile = orderMobile;
	}

	@Override
	public String toString() {
		return "SiteMsgRequest [userId=" + userId + ", siteMsgType=" + siteMsgType + ", username=" + username
				+ ", dateTime=" + dateTime + ", equipId=" + equipId + ", equipName=" + equipName + ", orderUser="
				+ orderUser + ", orderMobile=" + orderMobile + "]";
	}

}
