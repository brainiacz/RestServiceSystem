package com.dervan.module.model.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the pay_rep_dtls database table.
 * 
 */
@Entity
@Table(name="pay_rep_dtls")
@NamedQuery(name="PayRepDtl.findAll", query="SELECT p FROM PayRepDtl p")
public class PayRepDtl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PAY_ID")
	private int payId;

	@Column(name="KYC_CHECK")
	private String kycCheck;

	@Column(name="PART_TEAM_ID")
	private int partTeamId;

	@Column(name="PAY_AMT")
	private int payAmt;

	@Temporal(TemporalType.DATE)
	@Column(name="PAY_DT")
	private Date payDt;

	@Column(name="PAY_FLAG")
	private String payFlag;

	@Column(name="PAY_USR")
	private String payUsr;

	@Column(name="PAYMENT_WAIVED_FLG")
	private String paymentWaivedFlg;

	@Column(name="RECEIPT_NBR")
	private int receiptNbr;

	@Column(name="REPORT_USR", insertable=false)
	private String reportUsr;

	@Temporal(TemporalType.DATE)
	@Column(name="REPORTED_DT")
	private Date reportedDt;

	@Column(name="REPORTED_FLG")
	private String reportedFlg;

	@Column(name="PAYMENT_MODE")
	private String paymentMode;
	
	@Column(name="REF_NUMBER")
	private String referenceNumber;
	
	public PayRepDtl() {
	}

	public int getPayId() {
		return this.payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}

	public String getKycCheck() {
		return this.kycCheck;
	}

	public void setKycCheck(String kycCheck) {
		this.kycCheck = kycCheck;
	}

	public int getPartTeamId() {
		return this.partTeamId;
	}

	public void setPartTeamId(int partTeamId) {
		this.partTeamId = partTeamId;
	}

	public int getPayAmt() {
		return this.payAmt;
	}

	public void setPayAmt(int payAmt) {
		this.payAmt = payAmt;
	}

	public Date getPayDt() {
		return this.payDt;
	}

	public void setPayDt(Date payDt) {
		this.payDt = payDt;
	}

	public String getPayFlag() {
		return this.payFlag;
	}

	public void setPayFlag(String payFlag) {
		this.payFlag = payFlag;
	}

	public String getPayUsr() {
		return this.payUsr;
	}

	public void setPayUsr(String payUsr) {
		this.payUsr = payUsr;
	}

	public String getPaymentWaivedFlg() {
		return this.paymentWaivedFlg;
	}

	public void setPaymentWaivedFlg(String paymentWaivedFlg) {
		this.paymentWaivedFlg = paymentWaivedFlg;
	}

	public int getReceiptNbr() {
		return this.receiptNbr;
	}

	public void setReceiptNbr(int receiptNbr) {
		this.receiptNbr = receiptNbr;
	}

	public String getReportUsr() {
		return this.reportUsr;
	}

	public void setReportUsr(String reportUsr) {
		this.reportUsr = reportUsr;
	}

	public Date getReportedDt() {
		return this.reportedDt;
	}

	public void setReportedDt(Date reportedDt) {
		this.reportedDt = reportedDt;
	}

	public String getReportedFlg() {
		return this.reportedFlg;
	}

	public void setReportedFlg(String reportedFlg) {
		this.reportedFlg = reportedFlg;
	}

	/**
	 * @return the paymentMode
	 */
	public String getPaymentMode() {
		return paymentMode;
	}

	/**
	 * @param paymentMode the paymentMode to set
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	/**
	 * @return the referenceNumber
	 */
	public String getReferenceNumber() {
		return referenceNumber;
	}

	/**
	 * @param referenceNumber the referenceNumber to set
	 */
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	
	
}