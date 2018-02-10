package com.dervan.module.model.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the receipt_master database table.
 * 
 */
@Entity
@Table(name="receipt_master")
@NamedQuery(name="ReceiptMaster.findAll", query="SELECT r FROM ReceiptMaster r")
public class ReceiptMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="ASSIGNED_DT", insertable=false)
	private Date assignedDt;

	@Column(name="ASSIGNED_FLG")
	private String assignedFlg;

	@Column(name="ASSIGNED_PART_ID")
	private int assignedPartId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RECEIPT_ID")
	private int receiptId;

	@Column(name="RECEIPT_NBR")
	private int receiptNbr;

	public ReceiptMaster() {
	}

	public Date getAssignedDt() {
		return this.assignedDt;
	}

	public void setAssignedDt(Date assignedDt) {
		this.assignedDt = assignedDt;
	}

	public String getAssignedFlg() {
		return this.assignedFlg;
	}

	public void setAssignedFlg(String assignedFlg) {
		this.assignedFlg = assignedFlg;
	}

	public int getAssignedPartId() {
		return this.assignedPartId;
	}

	public void setAssignedPartId(int assignedPartId) {
		this.assignedPartId = assignedPartId;
	}

	public int getReceiptId() {
		return this.receiptId;
	}

	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}

	public int getReceiptNbr() {
		return this.receiptNbr;
	}

	public void setReceiptNbr(int receiptNbr) {
		this.receiptNbr = receiptNbr;
	}

}