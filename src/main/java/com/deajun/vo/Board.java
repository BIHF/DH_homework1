package com.deajun.vo;

import java.sql.Date;

public class Board {
	private double no;
	private String content;
	private Date time;
	
	
	public Board() {
		super();
	}
	
	public Board(double no, String content, Date time) {
		super();
		this.no = no;
		this.content = content;
		this.time = time;
	}
	
	
	public double getNo() {
		return no;
	}
	public void setNo(double no) {
		this.no = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
