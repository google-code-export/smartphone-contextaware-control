package com.kcacelestia.managedapp.packet;

import java.util.List;

public class Packet {
	private String cmd;
	private String regnum;
	private String passwd;
	private List<lecture> lec;
	private List<blacklist> black;
	private List<whitelist> white;
	
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
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
	public List<lecture> getLec() {
		return lec;
	}
	public void setLec(List<lecture> lec) {
		this.lec = lec;
	}
	public List<blacklist> getBlack() {
		return black;
	}
	public void setBlack(List<blacklist> black) {
		this.black = black;
	}
	public List<whitelist> getWhite() {
		return white;
	}
	public void setWhite(List<whitelist> white) {
		this.white = white;
	}
	
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

// 개놈아