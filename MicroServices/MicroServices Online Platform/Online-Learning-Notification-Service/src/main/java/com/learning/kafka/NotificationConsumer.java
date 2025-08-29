package com.learning.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.learning.dto.NotificationRequest;
import com.learning.service.NotificationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationConsumer {

	@Autowired
    NotificationService notificationService;

    @KafkaListener(topics = "notifications", groupId = "notification-group")
    public void consume(NotificationRequest request) {
        notificationService.createNotification(request);
    }
}
