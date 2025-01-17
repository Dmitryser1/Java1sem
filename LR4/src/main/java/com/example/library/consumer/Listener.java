package com.example.library.consumer;

import com.example.library.notification.model.NotificationModel;
import com.example.library.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
    @Autowired
    private NotificationService notificationService;

    @JmsListener(destination = "notificationQueue")
    public void receiveMessage(NotificationModel notification) {
        notificationService.sendNotification(notification.getMessage(), notification.getRecipient());
    }
}