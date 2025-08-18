package com.example.department_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ServiceType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long serviceTypeId;
    private String serviceName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

	public Long getServiceTypeId() {
		return serviceTypeId;
	}

	public void setServiceTypeId(Long serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "ServiceType [serviceTypeId=" + serviceTypeId + ", serviceName=" + serviceName + ", department="
				+ department + "]";
	}
}
