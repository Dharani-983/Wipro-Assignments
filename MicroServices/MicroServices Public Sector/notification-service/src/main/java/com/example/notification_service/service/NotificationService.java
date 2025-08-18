package com.example.notification_service.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notification_service.entity.Notification;
import com.example.notification_service.repository.NotificationRepository;

@Service
public class NotificationService {
	@Autowired
	NotificationRepository notificationRepository;
	
	public Notification sendNotification(Long requestId, String message) {
        Notification n = new Notification();
        n.setRequestId(requestId);
        n.setMessage(message);
        n.setStatus("SENT");
        n.setSentDate(LocalDateTime.now());
        return notificationRepository.save(n);
    }
	public Notification saveNotification(Notification department) {
		// TODO Auto-generated method stub
		Notification n = notificationRepository.save(department);
		return n;
	}
	public List<Notification> getAllNotifications() {
		// TODO Auto-generated method stub
		return notificationRepository.findAll();
	}

	public Notification getNotificationById(Long id)  {
		// TODO Auto-generated method stub
		Optional<Notification> dept = notificationRepository.findById(id);
		if(dept.isPresent())
			return notificationRepository.findById(id).get();
		else
			return null;
		//	throw new CustomerNotFoundException("Customer not found with '"+id+"'");
	}

	public void deleteNotification(Long id) {
		// TODO Auto-generated method stub
		notificationRepository.deleteById(id);
		
	}
}
