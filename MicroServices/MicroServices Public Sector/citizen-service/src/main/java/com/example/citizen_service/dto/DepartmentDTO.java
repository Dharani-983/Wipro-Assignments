package com.example.citizen_service.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="departmetdto")
public class DepartmentDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;
    private String departmentName;
    private String location;
	public DepartmentDTO(Long departmentId2, String string, String string2) {
		// TODO Auto-generated constructor stub
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
