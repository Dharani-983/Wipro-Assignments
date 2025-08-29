package com.learning.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.learning.constants.Role;

public class UserResponse {
	
	private Long id;
    private String name;
    private String email;
    private Role role;
    private LocalDateTime createdAt;
    private List<CourseResponse> courses;
    private List<Long> assessments;
    
	public UserResponse() {
		
	}
	private List<Long> classroomSessionIds;
    private List<Long> assessmentIds;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public List<CourseResponse> getCourses() {
		return courses;
	}
	public void setCourses(List<CourseResponse> courses) {
		this.courses = courses;
	}
	public List<Long> getAssessments() {
		return assessments;
	}
	public void setAssessments(List<Long> assessments) {
		this.assessments = assessments;
	}
	public List<Long> getClassroomSessionIds() {
		return classroomSessionIds;
	}
	public void setClassroomSessionIds(List<Long> classroomSessionIds) {
		this.classroomSessionIds = classroomSessionIds;
	}
	public List<Long> getAssessmentIds() {
		return assessmentIds;
	}
	public void setAssessmentIds(List<Long> assessmentIds) {
		this.assessmentIds = assessmentIds;
	}
}
