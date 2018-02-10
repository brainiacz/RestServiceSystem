package com.dervan.module.model.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the master_codes database table.
 * 
 */
@Entity
@Table(name="master_codes")
@NamedQuery(name="MasterCode.findAll", query="SELECT m FROM MasterCode m")
public class MasterCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODE_ID")
	private int codeId;

	private String code;

	@Column(name="CODE_DESC")
	private String codeDesc;

	@Column(name="CODE_TYPE")
	private String codeType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="INSERT_DATE_TIME", insertable=false)
	private Date insertDateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATE_TIME", insertable=false)
	private Date updateDateTime;

	private String value;

	public MasterCode() {
	}

	public int getCodeId() {
		return this.codeId;
	}

	public void setCodeId(int codeId) {
		this.codeId = codeId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeDesc() {
		return this.codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}

	public String getCodeType() {
		return this.codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public Date getInsertDateTime() {
		return this.insertDateTime;
	}

	public void setInsertDateTime(Date insertDateTime) {
		this.insertDateTime = insertDateTime;
	}

	public Date getUpdateDateTime() {
		return this.updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}