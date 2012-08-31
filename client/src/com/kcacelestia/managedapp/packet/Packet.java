package com.kcacelestia.managedapp.packet;

public class Packet {
	private String regnum;
	private String passwd;
	private lecture lec;
	private blacklist black;
	
	public String getRegnum() {
		return regnum;
	}
	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public lecture getLec() {
		return lec;
	}
	public void setLec(lecture lec) {
		this.lec = lec;
	}
	public blacklist getBlack() {
		return black;
	}
	public void setBlack(blacklist black) {
		this.black = black;
	}
	public whitelist getWhite() {
		return white;
	}
	public void setWhite(whitelist white) {
		this.white = white;
	}
	private whitelist white;
}

class lecture{
	private String name;
	private String professor;
	private String starttime;
	private String endtime;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
}

class blacklist{
	private String name;
	private String packages;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPackages() {
		return packages;
	}
	public void setPackages(String packages) {
		this.packages = packages;
	}
}

class whitelist{
	private String name;
	private String packages;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPackages() {
		return packages;
	}
	public void setPackages(String packages) {
		this.packages = packages;
	}
}