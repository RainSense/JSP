package com.kh.wsp.board.model.vo;





public class Attachment {
	
	  private int fileNo;
	   private int prarentBoarNo;
	   private String fileOriginName;
	   private String fileChangeName;
	   private String filePath;
	   private int fileLevel;
	   private String fileStatus;
	
	
	   
	   public Attachment(int fileNo, int prarentBoarNo, String fileChangeName, String filePath) {
		super();
		this.fileNo = fileNo;
		this.prarentBoarNo = prarentBoarNo;
		this.fileChangeName = fileChangeName;
		this.filePath = filePath;
	}



	public Attachment() {
		   
	   }



	public int getFileNo() {
		return fileNo;
	}



	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}



	public int getPrarentBoarNo() {
		return prarentBoarNo;
	}



	public void setPrarentBoarNo(int prarentBoarNo) {
		this.prarentBoarNo = prarentBoarNo;
	}



	public String getFileOriginName() {
		return fileOriginName;
	}



	public void setFileOriginName(String fileOriginName) {
		this.fileOriginName = fileOriginName;
	}



	public String getFileChangeName() {
		return fileChangeName;
	}



	public void setFileChangeName(String fileChangeName) {
		this.fileChangeName = fileChangeName;
	}



	public String getFilePath() {
		return filePath;
	}



	public Attachment(int fileNo, int prarentBoarNo, String fileOriginName, String fileChangeName, String filePath,
			int fileLevel, String fileStatus) {
		super();
		this.fileNo = fileNo;
		this.prarentBoarNo = prarentBoarNo;
		this.fileOriginName = fileOriginName;
		this.fileChangeName = fileChangeName;
		this.filePath = filePath;
		this.fileLevel = fileLevel;
		this.fileStatus = fileStatus;
	}



	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}



	public int getFileLevel() {
		return fileLevel;
	}



	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}



	public String getFileStatus() {
		return fileStatus;
	}



	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}



	@Override
	public String toString() {
		return "Attachment [fileNo=" + fileNo + ", prarentBoarNo=" + prarentBoarNo + ", fileOriginName="
				+ fileOriginName + ", fileChangeName=" + fileChangeName + ", filePath=" + filePath + ", fileLevel="
				+ fileLevel + ", fileStatus=" + fileStatus + "]";
	}
	   
	   
	   
	
	
}
