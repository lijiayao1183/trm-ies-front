package com.trm.model.msg;

public class MsgHistory {

	private Integer id;
	private Integer regId;
	private Integer msgId;
	private String msgName;
	private String content;
	private String readingState;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRegId() {
		return regId;
	}
	public void setRegId(Integer regId) {
		this.regId = regId;
	}
	public Integer getMsgId() {
		return msgId;
	}
	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}
	public String getMsgName() {
		return msgName;
	}
	public void setMsgName(String msgName) {
		this.msgName = msgName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReadingState() {
		return readingState;
	}
	public void setReadingState(String readingState) {
		this.readingState = readingState;
	}
	
	@Override
	public String toString() {
		return "MsgHistory [id=" + id + ", regId=" + regId + ", msgId=" + msgId + ", msgName=" + msgName + ", content="
				+ content + ", readingState=" + readingState + "]";
	}

}