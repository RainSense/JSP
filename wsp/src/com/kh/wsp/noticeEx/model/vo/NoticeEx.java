package com.kh.wsp.noticeEx.model.vo;

import java.sql.Date;

public class NoticeEx {
	
	private String noticeTitle;
	   private String noticeContent;
	   private String memberId;
	   private int readCount;
	   private Date noticeCreateDate;
	   private Date noticeModifyDate;
	   private String noticeStatus;
	   
	   
	   public NoticeEx() {
		   
	   }
	   
	   
	public NoticeEx(String noticeTitle, String noticeContent, String memberId, int readCount, Date noticeCreateDate,
			Date noticeModifyDate, String noticeStatus) {
		super();
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.memberId = memberId;
		this.readCount = readCount;
		this.noticeCreateDate = noticeCreateDate;
		this.noticeModifyDate = noticeModifyDate;
		this.noticeStatus = noticeStatus;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public Date getNoticeCreateDate() {
		return noticeCreateDate;
	}
	public void setNoticeCreateDate(Date noticeCreateDate) {
		this.noticeCreateDate = noticeCreateDate;
	}
	public Date getNoticeModifyDate() {
		return noticeModifyDate;
	}
	public void setNoticeModifyDate(Date noticeModifyDate) {
		this.noticeModifyDate = noticeModifyDate;
	}
	public String getNoticeStatus() {
		return noticeStatus;
	}
	public void setNoticeStatus(String noticeStatus) {
		this.noticeStatus = noticeStatus;
	}
	@Override
	public String toString() {
		return "NoticeEx [noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent + ", memberId=" + memberId
				+ ", readCount=" + readCount + ", noticeCreateDate=" + noticeCreateDate + ", noticeModifyDate="
				+ noticeModifyDate + ", noticeStatus=" + noticeStatus + "]";
	}
	   
	   
	   
	   
	   

}
