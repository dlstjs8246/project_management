package com.yi.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectVO {
	private int no;
	private String name;
	private String content;
	private Date startDate;
	private Date endDate;
	private String status;
	public ProjectVO() {
		
	}
	
	public ProjectVO(int no) {
		this.no = no;
	}

	public ProjectVO(String name, String content, Date startDate, Date endDate, String status) {
		this.name = name;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		try {
			this.startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		try {
			this.endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		if(status.length()==1) {
			this.status = status;
		}
		else {
			switch(status) {
			case "준비":
				this.status = "r";
				break;
			case "진행중":
				this.status = "e";
				break;
			case "종료":
				this.status = "f";
				break;
			case "보류":
				this.status = "p";
				break;
			}
		}
		
	}
	@Override
	public String toString() {
		return String.format("ProjectVO [no=%s, name=%s, content=%s, startDate=%s, endDate=%s, status=%s]", no, name,
				content, startDate, endDate, status);
	}
	
	
}
