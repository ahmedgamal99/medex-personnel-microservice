package com.medex.communicationmodules;

import javax.persistence.*;

import com.medex.model.Personnel;
//
//The personnel class
//Type = 1
@Entity //A 'serializable' entity
//Now, the fields that we will annotate will be stored in the hosts table.
public class PersonnelInfo {

	int id;
	String name;

	int orderID = -1;

	public PersonnelInfo() {}

	//Non default constructor
	
	public PersonnelInfo(Personnel p)
	{
		this.id = p.getId();
		this.name = p.getName();
		this.orderID = p.getOrderID();
	}
	
	public PersonnelInfo(int id, String name, int aorderID) {
		this.id = id;
		this.name = name;
		this.orderID = aorderID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	
}
