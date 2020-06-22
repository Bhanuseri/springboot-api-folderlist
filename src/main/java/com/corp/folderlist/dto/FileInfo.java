package com.corp.folderlist.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

public class FileInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public String name;
	public String size;
	public String path;
	public String type;
	public String abspath;
	public String parent;
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
	public String getAbspath() {
		return abspath;
	}
	public void setAbspath(String abspath) {
		this.abspath = abspath;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
