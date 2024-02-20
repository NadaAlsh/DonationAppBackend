package com.nada.DonationApp.config.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FireBaseConfig {

    @Value("${firebase.config.path}")
    private String firebaseConfigPath;

//    @Bean
//    public FirebaseApp firebaseApp() throws IOException{
//        InputStream serviceAccount = getClass().getResourceAsStream(firebaseConfigPath);
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .build();
//        return FirebaseApp.initializeApp(options);
//    }

//    @PostConstruct
//    public void init() throws IOException {
//        FileInputStream serviceAccount =
//                new FileInputStream("src/main/google-services.json");
//
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .build();
//
//        FirebaseApp.initializeApp(options);
//    }
}
