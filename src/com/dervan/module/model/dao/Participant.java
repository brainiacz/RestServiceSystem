package com.dervan.module.model.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	private int partid;

	@Column(name="ADDRESS_LINE1")
	private String addr1;

	@Column(name="ADDRESS_LINE2")
	private String addr2;
	
	@Column(name="AGE")
	private String age;
	
	@Column(name="BLOOD_GRP")
	private String bloodgroup;

	@Column(name="CITY")
	private String city;
	
	@Column(name="DOB")
	private String dob;

	@Column(name="EMAIL_ID")
	private String email;

	@Column(name="EMER_PHONE")
	private String alternativeno;
	
	@Column(name="FNAME")
	private String firstname;

	@Column(name="GENDER")
	private String gender;

	@Column(name="ID_INT")
	private String identitynumber;

	@Column(name="ID_TYPE")
	private String identitytype;

	@Column(name="LNAME")
	private String lastname;

	@Column(name="MNAME")
	private String middlename;

	@Column(name="PHONE")
	private String contactno;

	@Column(name="PINCODE")
	private String pincode;

	@Column(name="SCHOOL")
	private String nameOfSchoolOrClub;

	@Column(name="SCHOOL_ADDRESS_LINE1")
	private String addressOfSchoolOrClub;

	@Column(name="SCHOOL_ADDRESS_LINE2")
	private String address2OfSchoolOrClub;

	@Column(name="SCHOOL_CITY")
	private String schoolcity;

	@Column(name="SCHOOL_PINCODE")
	private String schoolpincode;

	@Column(name="SCHOOL_STATE")
	private String schoolstate;

	@Column(name="STATE")
	private String state;
	
	@Column(name="bankDetails")
	private String bankdetails;
	
	@Temporal(TemporalType.DATE)
	@Column(name="InsertedDate")
	private Date inserteddate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="updatedDate")
	private Date updateddate;
	
	@Column(name="insertedUser")
	private String insertedUser;
	
	@Column(name="updatedUser")
	private String updatedUser;
	
	
	
	/**
	 * @return the bankdetails
	 */
	public String getBankdetails() {
		return bankdetails;
	}

	/**
	 * @param bankdetails the bankdetails to set
	 */
	public void setBankdetails(String bankdetails) {
		this.bankdetails = bankdetails;
	}

	/**
	 * @return the inserteddate
	 */
	public Date getInserteddate() {
		return inserteddate;
	}

	/**
	 * @param inserteddate the inserteddate to set
	 */
	public void setInserteddate(Date inserteddate) {
		this.inserteddate = inserteddate;
	}

	/**
	 * @return the updateddate
	 */
	public Date getUpdateddate() {
		return updateddate;
	}

	/**
	 * @param updateddate the updateddate to set
	 */
	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	/**
	 * @return the insertedUser
	 */
	public String getInsertedUser() {
		return insertedUser;
	}

	/**
	 * @param insertedUser the insertedUser to set
	 */
	public void setInsertedUser(String insertedUser) {
		this.insertedUser = insertedUser;
	}

	/**
	 * @return the updatedUser
	 */
	public String getUpdatedUser() {
		return updatedUser;
	}

	/**
	 * @param updatedUser the updatedUser to set
	 */
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	/**
	 * @return the partid
	 */
	public int getPartid() {
		return partid;
	}

	/**
	 * @param partid the partid to set
	 */
	public void setPartid(int partid) {
		this.partid = partid;
	}

	/**
	 * @return the addr1
	 */
	public String getAddr1() {
		return addr1;
	}

	/**
	 * @param addr1 the addr1 to set
	 */
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	/**
	 * @return the addr2
	 */
	public String getAddr2() {
		return addr2;
	}

	/**
	 * @param addr2 the addr2 to set
	 */
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the bloodgroup
	 */
	public String getBloodgroup() {
		return bloodgroup;
	}

	/**
	 * @param bloodgroup the bloodgroup to set
	 */
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the alternativeno
	 */
	public String getAlternativeno() {
		return alternativeno;
	}

	/**
	 * @param alternativeno the alternativeno to set
	 */
	public void setAlternativeno(String alternativeno) {
		this.alternativeno = alternativeno;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the identitynumber
	 */
	public String getIdentitynumber() {
		return identitynumber;
	}

	/**
	 * @param identitynumber the identitynumber to set
	 */
	public void setIdentitynumber(String identitynumber) {
		this.identitynumber = identitynumber;
	}

	/**
	 * @return the identitytype
	 */
	public String getIdentitytype() {
		return identitytype;
	}

	/**
	 * @param identitytype the identitytype to set
	 */
	public void setIdentitytype(String identitytype) {
		this.identitytype = identitytype;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the middlename
	 */
	public String getMiddlename() {
		return middlename;
	}

	/**
	 * @param middlename the middlename to set
	 */
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	/**
	 * @return the contactno
	 */
	public String getContactno() {
		return contactno;
	}

	/**
	 * @param contactno the contactno to set
	 */
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}

	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	/**
	 * @return the nameOfSchoolOrClub
	 */
	public String getNameOfSchoolOrClub() {
		return nameOfSchoolOrClub;
	}

	/**
	 * @param nameOfSchoolOrClub the nameOfSchoolOrClub to set
	 */
	public void setNameOfSchoolOrClub(String nameOfSchoolOrClub) {
		this.nameOfSchoolOrClub = nameOfSchoolOrClub;
	}

	/**
	 * @return the addressOfSchoolOrClub
	 */
	public String getAddressOfSchoolOrClub() {
		return addressOfSchoolOrClub;
	}

	/**
	 * @param addressOfSchoolOrClub the addressOfSchoolOrClub to set
	 */
	public void setAddressOfSchoolOrClub(String addressOfSchoolOrClub) {
		this.addressOfSchoolOrClub = addressOfSchoolOrClub;
	}

	/**
	 * @return the address2OfSchoolOrClub
	 */
	public String getAddress2OfSchoolOrClub() {
		return address2OfSchoolOrClub;
	}

	/**
	 * @param address2OfSchoolOrClub the address2OfSchoolOrClub to set
	 */
	public void setAddress2OfSchoolOrClub(String address2OfSchoolOrClub) {
		this.address2OfSchoolOrClub = address2OfSchoolOrClub;
	}

	/**
	 * @return the schoolcity
	 */
	public String getSchoolcity() {
		return schoolcity;
	}

	/**
	 * @param schoolcity the schoolcity to set
	 */
	public void setSchoolcity(String schoolcity) {
		this.schoolcity = schoolcity;
	}

	/**
	 * @return the schoolpincode
	 */
	public String getSchoolpincode() {
		return schoolpincode;
	}

	/**
	 * @param schoolpincode the schoolpincode to set
	 */
	public void setSchoolpincode(String schoolpincode) {
		this.schoolpincode = schoolpincode;
	}

	/**
	 * @return the schoolstate
	 */
	public String getSchoolstate() {
		return schoolstate;
	}

	/**
	 * @param schoolstate the schoolstate to set
	 */
	public void setSchoolstate(String schoolstate) {
		this.schoolstate = schoolstate;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	
	
		
}