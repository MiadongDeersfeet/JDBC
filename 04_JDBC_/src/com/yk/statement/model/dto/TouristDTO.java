package com.yk.statement.model.dto;

import java.util.Objects;

public class TouristDTO {
	private String phone;
	private String newDestination;
	
	public TouristDTO() {
		super();
	}

	public TouristDTO(String phone, String newDestination) {
		super();
		this.phone = phone;
		this.newDestination = newDestination;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNewDestination() {
		return newDestination;
	}

	public void setNewDestination(String newDestination) {
		this.newDestination = newDestination;
	}

	@Override
	public int hashCode() {
		return Objects.hash(newDestination, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TouristDTO other = (TouristDTO) obj;
		return Objects.equals(newDestination, other.newDestination) && Objects.equals(phone, other.phone);
	}
	
	
	
}