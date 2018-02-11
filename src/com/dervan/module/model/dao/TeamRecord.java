package com.dervan.module.model.dao;

import java.io.Serializable;

public class TeamRecord implements Serializable{
	
	private TeamRecordInner record;

	/**
	 * @return the record
	 */
	public TeamRecordInner getRecord() {
		return record;
	}

	/**
	 * @param record the record to set
	 */
	public void setRecord(TeamRecordInner record) {
		this.record = record;
	}
	
	
	
}
