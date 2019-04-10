package com.techelevator.model;

import java.sql.Date;
import java.time.LocalDate;

public class Pothole {
	private Long pothole_Id;
	private String street_Name;
	private int street_Number;
	private int zip_Code;
	private String city;
	private String state;
	private String country;
	private Date status_Date;
	private int status_Code;
	private Long lat;
	private Long lng;
	private int severity;
	private Date report_Date;
	private String report_User;
	private String img_Url;
	
	
	public Long getPothole_Id() {
		return pothole_Id;
	}
	public void setPothole_Id(Long pothole_Id) {
		this.pothole_Id = pothole_Id;
	}
	public String getStreet_Name() {
		return street_Name;
	}
	public void setStreet_Name(String street_Name) {
		this.street_Name = street_Name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getStatus_Date() {
		return status_Date;
	}
	public void setStatus_Date(Date date) {
		this.status_Date = date;
	}
	public int getStatus_Code() {
		return status_Code;
	}
	public void setStatus_Code(int status_Code) {
		this.status_Code = status_Code;
	}
	public Long getLat() {
		return lat;
	}
	public void setLat(Long lat) {
		this.lat = lat;
	}
	public Long getLng() {
		return lng;
	}
	public void setLng(Long lng) {
		this.lng = lng;
	}
	public int getSeverity() {
		return severity;
	}
	public void setSeverity(int severity) {
		this.severity = severity;
	}
	public Date getReport_Date() {
		return report_Date;
	}
	public void setReport_Date(Date report_Date) {
		this.report_Date = report_Date;
	}
	public String getImg_Url() {
		return img_Url;
	}
	public void setImg_Url(String img_Url) {
		this.img_Url = img_Url;
	}
	public int getStreet_Number() {
		return street_Number;
	}
	public void setStreet_Number(int street_Number) {
		this.street_Number = street_Number;
	}
	public int getZip_Code() {
		return zip_Code;
	}
	public void setZip_Code(int zip_Code) {
		this.zip_Code = zip_Code;
	}
	public String getReport_User() {
		return report_User;
	}
	public void setReport_User(String report_User) {
		this.report_User = report_User;
	}
	
	

}
