package com.trm.model.member;

/**
 * 
 * @author zhaosimiao 个人中心首页信息统计 2017-11-7 10:01:24
 *
 */
public class MyCase {

	/**
	 * 我的设备/关注/评论/消息   名称
	 */
	private String caseName;
	
	/**
	 * 我的设备/关注/评论/消息   数量
	 */
	private Long caseNum;
	
	public MyCase() {
		super();
	}

	public MyCase(String caseName, Long caseNum) {
		super();
		this.caseName = caseName;
		this.caseNum = caseNum;
	}

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public Long getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(Long caseNum) {
		this.caseNum = caseNum;
	}

	@Override
	public String toString() {
		return "MyCase [caseName=" + caseName + ", caseNum=" + caseNum + "]";
	}
	
}
