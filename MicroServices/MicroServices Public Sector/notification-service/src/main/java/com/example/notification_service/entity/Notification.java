package com.example.notification_service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long notificationId;
    private Long requestId;
    private String message;
    private String status;
    private LocalDateTime sentDate;
	public Long getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}
	public Long getRequestId() {
		return requestId;
	}
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getSentDate() {
		return sentDate;
	}
	public void setSentDate(LocalDateTime sentDate) {
		this.sentDate = sentDate;
	}
	@Override
	public String toString() {
		return "Notification [notificationId=" + notificationId + ", requestId=" + requestId + ", message=" + message
				+ ", status=" + status + ", sentDate=" + sentDate + "]";
	}
}
