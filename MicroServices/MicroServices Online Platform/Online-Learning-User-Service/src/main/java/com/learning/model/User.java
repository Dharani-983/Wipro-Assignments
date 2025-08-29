package com.learning.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.learning.constants.Role;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @ElementCollection
    @CollectionTable(name = "user_courses",joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "course_id")
    private List<Long> courses = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "user_assessments", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "assessment_id")
    private List<Long> assessments = new ArrayList<>();

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Long> getCourses() {
		return courses;
	}

	public void setCourses(List<Long> courses) {
		this.courses = courses;
	}

	public List<Long> getAssessments() {
		return assessments;
	}

	public void setAssessments(List<Long> assessments) {
		this.assessments = assessments;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", email=" + email + ", name=" + name + ", role=" + role
				+ ", createdAt=" + createdAt + ", courses=" + courses + ", assessments=" + assessments + "]";
	} 
}
