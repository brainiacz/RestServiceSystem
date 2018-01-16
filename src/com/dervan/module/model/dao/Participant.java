package com.dervan.module.model.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * The persistent class for the participant database table.
 * 
 */
@Entity
@NamedQuery(name="Participant.findAll", query="SELECT p FROM Participant p")
@JsonFormat(shape=JsonFormat.Shape.ARRAY)

@JsonInclude(Include.NON_NULL)
public class Participant implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PART_ID")
	private int partId;

	@Column(name="ADDRESS_LINE1")
	private String addressLine1;

	@Column(name="ADDRESS_LINE2")
	private String addressLine2;
	
	@Column(name="AGE")
	private int age;
	
	@Column(name="BLOOD_GRP")
	private String bloodGrp;

	@Column(name="CITY")
	private String city;
	
	@Column(name="DOB")
	private String dob;

	@Column(name="EMAIL_ID")
	private String emailId;

	@Column(name="EMER_PHONE")
	private String emerPhone;
	
	@Column(name="FNAME")
	private String fname;

	@Column(name="GENDER")
	private String gender;

	@Column(name="ID_INT")
	private String idInt;

	@Column(name="ID_TYPE")
	private String idType;

	@Column(name="LNAME")
	private String lname;

	@Column(name="MNAME")
	private String mname;

	@Column(name="PHONE")
	private String phone;

	@Column(name="PINCODE")
	private int pincode;

	@Column(name="SCHOOL")
	private String school;

	@Column(name="SCHOOL_ADDRESS_LINE1")
	private String schoolAddressLine1;

	@Column(name="SCHOOL_ADDRESS_LINE2")
	private String schoolAddressLine2;

	@Column(name="SCHOOL_CITY")
	private String schoolCity;

	@Column(name="SCHOOL_PINCODE")
	private int schoolPincode;

	@Column(name="SCHOOL_STATE")
	private String schoolState;

	@Column(name="STATE")
	private String state;

	
	public Participant( int partId, String addressLine1, String addressLine2, int age, String bloodGrp, String city,
			String dob, String emailId, String emerPhone, String fname, String gender, String idInt, String idType,
			String lname, String mname, String phone, int pincode, String school, String schoolAddressLine1,
			String schoolAddressLine2, String schoolCity, int schoolPincode, String schoolState, String state) {
		super();
		this.partId = partId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.age = age;
		this.bloodGrp = bloodGrp;
		this.city = city;
		this.dob = dob;
		this.emailId = emailId;
		this.emerPhone = emerPhone;
		this.fname = fname;
		this.gender = gender;
		this.idInt = idInt;
		this.idType = idType;
		this.lname = lname;
		this.mname = mname;
		this.phone = phone;
		this.pincode = pincode;
		this.school = school;
		this.schoolAddressLine1 = schoolAddressLine1;
		this.schoolAddressLine2 = schoolAddressLine2;
		this.schoolCity = schoolCity;
		this.schoolPincode = schoolPincode;
		this.schoolState = schoolState;
		this.state = state;
	}

	public Participant() {
	}

	public int getPartId() {
		return this.partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBloodGrp() {
		return this.bloodGrp;
	}

	public void setBloodGrp(String bloodGrp) {
		this.bloodGrp = bloodGrp;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	public String getDob() {
		return this.dob;
	}
	

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEmerPhone() {
		return this.emerPhone;
	}

	public void setEmerPhone(String emerPhone) {
		this.emerPhone = emerPhone;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdInt() {
		return this.idInt;
	}

	public void setIdInt(String idInt) {
		this.idInt = idInt;
	}

	public String getIdType() {
		return this.idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPincode() {
		return this.pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getSchoolAddressLine1() {
		return this.schoolAddressLine1;
	}

	public void setSchoolAddressLine1(String schoolAddressLine1) {
		this.schoolAddressLine1 = schoolAddressLine1;
	}

	public String getSchoolAddressLine2() {
		return this.schoolAddressLine2;
	}

	public void setSchoolAddressLine2(String schoolAddressLine2) {
		this.schoolAddressLine2 = schoolAddressLine2;
	}

	public String getSchoolCity() {
		return this.schoolCity;
	}

	public void setSchoolCity(String schoolCity) {
		this.schoolCity = schoolCity;
	}

	public int getSchoolPincode() {
		return this.schoolPincode;
	}

	public void setSchoolPincode(int schoolPincode) {
		this.schoolPincode = schoolPincode;
	}

	public String getSchoolState() {
		return this.schoolState;
	}

	public void setSchoolState(String schoolState) {
		this.schoolState = schoolState;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "{partId=" + partId + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", age=" + age + ", bloodGrp=" + bloodGrp + ", city=" + city + ", dob=" + dob + ", emailId=" + emailId
				+ ", emerPhone=" + emerPhone + ", fname=" + fname + ", gender=" + gender + ", idInt=" + idInt
				+ ", idType=" + idType + ", lname=" + lname + ", mname=" + mname + ", phone=" + phone + ", pincode="
				+ pincode + ", school=" + school + ", schoolAddressLine1=" + schoolAddressLine1
				+ ", schoolAddressLine2=" + schoolAddressLine2 + ", schoolCity=" + schoolCity + ", schoolPincode="
				+ schoolPincode + ", schoolState=" + schoolState + ", state=" + state + "}";
	}
	
}