package com.example.citizen_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="requeststatus")
public class RequestStatus {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long statusId;
    private String statusName;
	public Long getStatusId() {
		return statusId;
	}
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	@Override
	public String toString() {
		return "RequestStatus [statusId=" + statusId + ", statusName=" + statusName + "]";
	}
}
