package com.application.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	String student_id;
	String student_name;
	String branch;
	String address;
	String mobile_no;

	public Student() {
	}

	public Student(String student_id, String student_name, String branch, String address, String mobile_no) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.branch = branch;
		this.address = address;
		this.mobile_no = mobile_no;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", branch=" + branch
				+ ", address=" + address + ", mobile_no=" + mobile_no + "]";
	}

}
