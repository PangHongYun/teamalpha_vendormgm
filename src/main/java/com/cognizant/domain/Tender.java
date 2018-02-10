package com.cognizant.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "createTender.getTenderProject", query = "SELECT t FROM Tender t WHERE t.Project_Name=:Project_Name AND t.id=:id"),
		@NamedQuery(name = "createTender.findProjectID", query = "SELECT t FROM Tender t WHERE t.id=:id")
})
public class Tender extends Base{

	String Project_Dept;

	String Project_Description;

	String Project_Incharge;

	String Project_Name;

	public Tender() {
		super();
	}

	public Tender(Long Project_ID, String Project_Name,
			String Project_Description, String Project_Incharge,
			String Project_Dept) {
		super();
		this.Project_Name = Project_Name;
		this.Project_Description = Project_Description;
		this.Project_Incharge = Project_Incharge;
		this.Project_Dept = Project_Dept;

	}

	public String getProject_Dept() {
		return Project_Dept;
	}

	public String getProject_Description() {
		return Project_Description;
	}


	public String getProject_Incharge() {
		return Project_Incharge;
	}

	public String getProject_Name() {
		return Project_Name;
	}

	public void setProject_Dept(String project_Dept) {
		Project_Dept = project_Dept;
	}

	public void setProject_Description(String project_Description) {
		Project_Description = project_Description;
	}

	

	public void setProject_Incharge(String project_Incharge) {
		Project_Incharge = project_Incharge;
	}

	public void setProject_Name(String project_Name) {
		Project_Name = project_Name;
	}

	@Override
	public String toString() {
		return "Tender [Project_Dept=" + Project_Dept
				+ ", Project_Description=" + Project_Description
				+ ", Project_Incharge=" + Project_Incharge + ", Project_Name="
				+ Project_Name + "]";
	}

}
