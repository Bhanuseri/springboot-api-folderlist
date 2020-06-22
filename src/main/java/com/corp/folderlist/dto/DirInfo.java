package com.corp.folderlist.dto;

import java.io.Serializable;

public class DirInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public String name;
	public String size;
	public String path;
	public int flag = 0;//flag zero represents file and 1 for directory
	public String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	
	
}
