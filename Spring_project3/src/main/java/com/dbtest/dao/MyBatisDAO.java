package com.dbtest.dao;

public class MyBatisDAO {

	private String num, title, contents, reg_date, reg_id, file_name, hit;

	@Override
	public String toString() {
		return "MyBatisDAO [num=" + num + ", title=" + title + ", contents=" + contents + ", reg_date=" + reg_date
				+ ", reg_id=" + reg_id + ", file_name=" + file_name + ", hit=" + hit + "]";
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getReg_id() {
		return reg_id;
	}

	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}
	
}
