package com.example.library.notification.service;

import com.example.library.notification.model.NotificationModel;
import com.example.library.notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public void sendNotification(String message, String recipient) {
        NotificationModel notification = new NotificationModel();
        notification.setMessage(message);
        notification.setRecipient(recipient);
        notification.setSentAt(new Date());
        notificationRepository.save(notification);
    }
}