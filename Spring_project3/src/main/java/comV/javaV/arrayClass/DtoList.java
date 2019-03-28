package comV.javaV.arrayClass;

public class DtoList {
	String num;
	String title;
	String contents;
	String file_name;
	String reg_date;
	int hit;
	
	public DtoList(String num, String title, String contents, String file_name, String reg_date, int hit) {
		this.num = num;
		this.title = title;
		this.contents = contents;
		this.file_name = file_name;
		this.reg_date = reg_date;
		this.hit = hit;
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
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
}
