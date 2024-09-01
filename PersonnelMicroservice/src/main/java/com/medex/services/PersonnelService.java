package com.medex.services;

import java.util.ArrayList;
import java.util.List;

import com.medex.communicationmodules.PersonnelInfo;
import com.medex.communicationmodules.Status;
import com.medex.database.PersonnelDB;
import com.medex.model.Personnel;
import com.medex.communicationmodules.PersonnelInfo;



//This is the "backend" of our resources. This is where the logic is executed; the logic is basic since the database handles itself very well.
public class PersonnelService {
	PersonnelDB personneldb = new PersonnelDB(); //(Instead of the pseudo-database)
	public PersonnelService() {} 
	
	//All what is below is just calling the functions belonging to the personnels' database/table.
	
	public List<PersonnelInfo>getAllPersonnels()
	{
		List<PersonnelInfo> p1 = new ArrayList<PersonnelInfo>();
		List<Personnel> p2 = personneldb.getPersonnels();
		for (Personnel p3 : p2)
		{
			p1.add(new PersonnelInfo(p3));
		}
		return p1;
	}
	
	public PersonnelInfo getPersonnel(int id)
	{
		Personnel p =  personneldb.getPersonnel(id);
		return new PersonnelInfo(p);
	}
	
	public PersonnelInfo addPersonnel(Personnel aPersonnel)
	{
		personneldb.insertPersonnel(aPersonnel); return new PersonnelInfo(aPersonnel);
	}
	
	public PersonnelInfo updatePersonnel(Personnel aPersonnel)
	{
		System.out.println(aPersonnel.getId() + " " + aPersonnel.getOrderID() + " " + aPersonnel.getName());
		if (personneldb.getPersonnel(aPersonnel.getId()) == null) return null;
		personneldb.updatePersonnel(aPersonnel);
		return new PersonnelInfo(aPersonnel);
	}
	
	public Status removePersonnel(int id)
	{
		if (personneldb.getPersonnel(id) == null) return new Status(false);
		personneldb.deletePersonnel(id);
		return new Status(true);
	}
	
	
	public Personnel getPersonnelLogin(String username, String password)
	{
		return personneldb.getPersonnelLogin(username, password); //Get all hosts.

	}
	
	
	
}


