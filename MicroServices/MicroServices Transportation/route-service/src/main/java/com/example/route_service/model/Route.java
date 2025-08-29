package com.example.route_service.model;


import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long routeId;

    private String source;
    private String destination;
    private Double distanceKm;
    private Integer estimatedDurationMin;

    @ElementCollection
    private List<String> stops;

//    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonIgnore
    private LocalDateTime createdAt;

//    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonIgnore
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now(); // ✅ ensure not null
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
	public Long getRouteId() {
		return routeId;
	}
	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Double getDistanceKm() {
		return distanceKm;
	}
	public void setDistanceKm(Double distanceKm) {
		this.distanceKm = distanceKm;
	}
	public Integer getEstimatedDurationMin() {
		return estimatedDurationMin;
	}
	public void setEstimatedDurationMin(Integer estimatedDurationMin) {
		this.estimatedDurationMin = estimatedDurationMin;
	}
	public List<String> getStops() {
		return stops;
	}
	public void setStops(List<String> stops) {
		this.stops = stops;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", source=" + source + ", destination=" + destination + ", distanceKm="
				+ distanceKm + ", estimatedDurationMin=" + estimatedDurationMin + ", stops=" + stops + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
}
