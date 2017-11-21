package cn.shi.leasplat.entity;

import java.io.Serializable;

public class File implements Serializable{
	private Integer id;
	private String path;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "File [id=" + id + ", path=" + path + "]";
	}
	
}
