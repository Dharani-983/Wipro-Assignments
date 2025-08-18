package com.example.citizen_service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="requests")
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long requestId;
    private String title;
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private RequestStatus status;
    
//    @ManyToOne
//    @Transient
//    @JoinColumn(name = "citizen_id", nullable = false)
//    private Citizen citizen;

    private Long assignedEmployeeId; 
    private Long departmentId;     
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
	public Long getRequestId() {
		return requestId;
	}
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public RequestStatus getStatus() {
		return status;
	}
	public void setStatus(RequestStatus status) {
		this.status = status;
	}
//	public Citizen getCitizen() {
//		return citizen;
//	}
//	public void setCitizen(Citizen citizen) {
//		this.citizen = citizen;
//	}
	public Long getAssignedEmployeeId() {
		return assignedEmployeeId;
	}
	public void setAssignedEmployeeId(Long assignedEmployeeId) {
		this.assignedEmployeeId = assignedEmployeeId;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", title=" + title + ", description=" + description + ", status="
				+ status + ", assignedEmployeeId=" + assignedEmployeeId + ", departmentId="
				+ departmentId + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}
}
