package com.model.shared;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;



public class Device implements Serializable{

	private BigInteger id;
	private String name;
	private String description;

	public Device() {
		
	}
	
	public Device(BigInteger id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", name=" + name + ", " +  "description=" + description + "]";
	}

}
