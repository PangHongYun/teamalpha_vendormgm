package com.cognizant.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "Department.findbyDepartmentNameAndComId", query = "SELECT d FROM Department d where d.dept_name=:dept_name AND d.com_id=:com_id"),
		@NamedQuery(name = "Department.findbyDepartmentId", query = "SELECT d FROM Department d where d.id=:id") })
public class Department extends Base {

	private static final long serialVersionUID = 7796929384286814899L;
	Long com_id;
	String dept_name;

	public Long getCom_id() {
		return com_id;
	}

	public void setCom_id(Long com_id) {
		this.com_id = com_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

}
