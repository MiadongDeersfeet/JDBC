package com.yk.statement.vo;

import java.sql.Date;
import java.util.Objects;

public class Tourist {
	private int touristId;
	private String touristName;
	private String touristNo;
	private String phone;
	private String destination;
	private Date enrollDate;
	
	public Tourist() {
		super();
	}

	public Tourist(String touristName, String touristNo, String phone, String destination) {
	    super();
	    this.touristName = touristName;
	    this.touristNo = touristNo;
	    this.phone = phone;
	    this.destination = destination;
	}
	
	public Tourist(int touristId, String touristName, String touristNo, String phone, String destination,
			Date enrollDate) {
		super();
		this.touristId = touristId;
		this.touristName = touristName;
		this.touristNo = touristNo;
		this.phone = phone;
		this.destination = destination;
		this.enrollDate = enrollDate;
	}

	public int getTouristId() {
		return touristId;
	}

	public void setTouristId(int touristId) {
		this.touristId = touristId;
	}

	public String getTouristName() {
		return touristName;
	}

	public void setTouristName(String touristName) {
		this.touristName = touristName;
	}

	public String getTouristNo() {
		return touristNo;
	}

	public void setTouristNo(String touristNo) {
		this.touristNo = touristNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "Tourist [touristId=" + touristId + ", touristName=" + touristName + ", touristNo=" + touristNo
				+ ", phone=" + phone + ", destination=" + destination + ", enrollDate=" + enrollDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(enrollDate, destination, phone, touristId, touristName, touristNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tourist other = (Tourist) obj;
		return Objects.equals(enrollDate, other.enrollDate) && Objects.equals(destination, other.destination)
				&& Objects.equals(phone, other.phone) && touristId == other.touristId
				&& Objects.equals(touristName, other.touristName) && Objects.equals(touristNo, other.touristNo);
	}
	
	

	
}
