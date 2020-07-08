package com.ks.bm.member.model.vo;

public class Member {
	
	private int memberNo;
	private String memberEmail;
	private String memberName;
	private String memberPwd;
	private String memberGrade;
	
	
	public Member() {
		
	}
	
	
	
	
	
	
	
	public Member(String memberEmail, String memberName, String memberGrade) {
		super();
		this.memberEmail = memberEmail;
		this.memberName = memberName;
		this.memberGrade = memberGrade;
	}







	public String getMemberGrade() {
		return memberGrade;
	}







	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}














	public Member(String memberEmail, String memberName) {
		super();
		this.memberEmail = memberEmail;
		this.memberName = memberName;
	}




	public Member(int memberNo, String memberEmail, String memberName, String memberPwd) {
		super();
		this.memberNo = memberNo;
		this.memberEmail = memberEmail;
		this.memberName = memberName;
		this.memberPwd = memberPwd;
	}



	public int getMemberNo() {
		return memberNo;
	}



	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}



	public String getMemberEmail() {
		return memberEmail;
	}



	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}



	public String getMemberName() {
		return memberName;
	}



	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}



	public String getMemberPwd() {
		return memberPwd;
	}



	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}



	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberEmail=" + memberEmail + ", memberName=" + memberName
				+ ", memberPwd=" + memberPwd + "]";
	}
	
	
	
	
	

}
