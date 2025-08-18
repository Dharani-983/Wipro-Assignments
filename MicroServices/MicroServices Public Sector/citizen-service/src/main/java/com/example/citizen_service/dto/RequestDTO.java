package com.example.citizen_service.dto;

import java.time.LocalDateTime;

import com.example.citizen_service.entity.Citizen;
import com.example.citizen_service.entity.RequestStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="requestdto")
public class RequestDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long requestId;
    private String title;
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "status_id")
    private RequestStatus status;
    
    @ManyToOne
    @JoinColumn(name = "citizen_id")
    private Citizen citizen;
    
    @Column(name = "citizen_id", insertable = false, updatable = false)
    private Long citizenId;
	private Long assignedEmployeeId; 
    private Long departmentId;     
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
   
    public Long getCitizenId() {
		return citizenId;
	}
	public void setCitizenId(Long citizenId) {
		this.citizenId = citizenId;
	}
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
	public Citizen getCitizen() {
		return citizen;
	}
	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}
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
}
