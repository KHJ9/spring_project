package comV.javaV.arrayClass;

public class Indexinfo {
	String num; 
	String title; 
	String contents;
	String reg_date;
	
	public Indexinfo(String num, String title, String contents, String reg_date) {
		this.num = num;
		this.title = title;
		this.contents = contents;
		this.reg_date = reg_date;
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
	
}
