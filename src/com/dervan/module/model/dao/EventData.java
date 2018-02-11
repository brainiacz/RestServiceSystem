package com.dervan.module.model.dao;

import java.io.Serializable;

public class EventData implements Serializable{
	
	private String eventid;
	private String text;
	private String minage;
	private String name;
	/**
	 * @return the eventid
	 */
	public String getEventid() {
		return eventid;
	}
	/**
	 * @param eventid the eventid to set
	 */
	public void setEventid(String eventid) {
		this.eventid = eventid;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the minage
	 */
	public String getMinage() {
		return minage;
	}
	/**
	 * @param minage the minage to set
	 */
	public void setMinage(String minage) {
		this.minage = minage;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
