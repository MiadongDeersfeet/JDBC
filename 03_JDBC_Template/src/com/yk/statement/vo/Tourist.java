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


	public String getTouristName() {
		return touristName;
	}


	public String getTouristNo() {
		return touristNo;
	}


	public String getPhone() {
		return phone;
	}


	public String getDestination() {
		return destination;
	}


	public Date getEnrollDate() {
		return enrollDate;
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
