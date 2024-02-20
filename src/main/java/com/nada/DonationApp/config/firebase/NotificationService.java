package com.nada.DonationApp.config.firebase;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;

public class NotificationService {

    public void sendNotification(String token, String title, String body){
        Message message = Message.builder()
                .putData("title", title)
                .putData("body", body)
                .setToken(token)
                .build();

        try {
            FirebaseMessaging.getInstance().send(message);
            System.out.println("Notification sent successfully");
        } catch (FirebaseMessagingException e){
            System.out.println("Failed to send notification: " +e.getMessage());
        }
    }
}
