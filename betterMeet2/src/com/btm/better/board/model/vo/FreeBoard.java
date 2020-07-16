package com.btm.better.board.model.vo;

import java.sql.Date;

public class FreeBoard {

	
	private int freeBoardNo;
	private String freeBoardTitle;
	private String freeBoardContent;
	private String freeBoardWriter;
	private String freeBoardTag;
	private int readCount;
	private Date freeBoardCreateDt;
	private Date freeBoardModifyDt;
	private String status;
	private int freeBoardLike;
	private int freeBoardReplyCount;
	
	
	
	public String getFreeBoardTag() {
		return freeBoardTag;
	}




	public FreeBoard(int freeBoardNo, String freeBoardTitle, String freeBoardWriter, String freeBoardTag, int readCount,
			Date freeBoardCreateDt, int freeBoardLike, int freeBoardReplyCount) {
		super();
		this.freeBoardNo = freeBoardNo;
		this.freeBoardTitle = freeBoardTitle;
		this.freeBoardWriter = freeBoardWriter;
		this.freeBoardTag = freeBoardTag;
		this.readCount = readCount;
		this.freeBoardCreateDt = freeBoardCreateDt;
		this.freeBoardLike = freeBoardLike;
		this.freeBoardReplyCount = freeBoardReplyCount;
	}




	public void setFreeBoardTag(String freeBoardTag) {
		this.freeBoardTag = freeBoardTag;
	}




	public FreeBoard(int freeBoardNo, String freeBoardTitle, String freeBoardWriter, int readCount,
			Date freeBoardCreateDt, int freeBoardLike, int freeBoardReplyCount) {
		super();
		this.freeBoardNo = freeBoardNo;
		this.freeBoardTitle = freeBoardTitle;
		this.freeBoardWriter = freeBoardWriter;
		this.readCount = readCount;
		this.freeBoardCreateDt = freeBoardCreateDt;
		this.freeBoardLike = freeBoardLike;
		this.freeBoardReplyCount = freeBoardReplyCount;
	}
	
	
	

	public FreeBoard() {
	}
	
	public int getFreeBoardNo() {
		return freeBoardNo;
	}
	public void setFreeBoardNo(int freeBoardNo) {
		this.freeBoardNo = freeBoardNo;
	}
	public String getFreeBoardTitle() {
		return freeBoardTitle;
	}
	public void setFreeBoardTitle(String freeBoardTitle) {
		this.freeBoardTitle = freeBoardTitle;
	}
	public String getFreeBoardContent() {
		return freeBoardContent;
	}
	public void setFreeBoardContent(String freeBoardContent) {
		this.freeBoardContent = freeBoardContent;
	}
	public String getFreeBoardWriter() {
		return freeBoardWriter;
	}
	public void setFreeBoardWriter(String freeBoardWriter) {
		this.freeBoardWriter = freeBoardWriter;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public Date getFreeBoardCreateDt() {
		return freeBoardCreateDt;
	}
	public void setFreeBoardCreateDt(Date freeBoardCreateDt) {
		this.freeBoardCreateDt = freeBoardCreateDt;
	}
	public Date getFreeBoardModifyDt() {
		return freeBoardModifyDt;
	}
	public void setFreeBoardModifyDt(Date freeBoardModifyDt) {
		this.freeBoardModifyDt = freeBoardModifyDt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getFreeBoardLike() {
		return freeBoardLike;
	}
	public void setFreeBoardLike(int freeBoardLike) {
		this.freeBoardLike = freeBoardLike;
	}
	public int getFreeBoardReplyCount() {
		return freeBoardReplyCount;
	}
	public void setFreeBoardReplyCount(int freeBoardReplyCount) {
		this.freeBoardReplyCount = freeBoardReplyCount;
	}
	@Override
	public String toString() {
		return "FreeBoard [freeBoardNo=" + freeBoardNo + ", freeBoardTitle=" + freeBoardTitle + ", freeBoardContent="
				+ freeBoardContent + ", freeBoardWriter=" + freeBoardWriter + ", freeBoardTag=" + freeBoardTag
				+ ", readCount=" + readCount + ", freeBoardCreateDt=" + freeBoardCreateDt + ", freeBoardModifyDt="
				+ freeBoardModifyDt + ", status=" + status + ", freeBoardLike=" + freeBoardLike
				+ ", freeBoardReplyCount=" + freeBoardReplyCount + "]";
	}
	
	
	
	
}
