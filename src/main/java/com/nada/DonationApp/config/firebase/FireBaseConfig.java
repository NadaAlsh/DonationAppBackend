//package com.nada.DonationApp.config.firebase;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import com.google.firebase.cloud.FirestoreClient;
//
//import java.io.IOException;
////@Configuration
////public class FireBaseConfig {
//
//// Use the application default credentials
//GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
//FirebaseOptions options = new FirebaseOptions.Builder()
//        .setCredentials(credentials)
//        .setProjectId(projectId)
//        .build();
//    FirebaseApp.
//Firestore db = FirestoreClient.getFirestore();
//
//initializeApp(options);
//
//public FireBaseConfig() throws IOException {
//}
//
//
////    @Value("${firebase.config.path}")
////    private String firebaseConfigPath;
//
////    @Bean
////    public FirebaseApp firebaseApp() throws IOException{
////        InputStream serviceAccount = getClass().getResourceAsStream(firebaseConfigPath);
////        FirebaseOptions options = new FirebaseOptions.Builder()
////                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
////                .build();
////        return FirebaseApp.initializeApp(options);
////    }
//
////    @PostConstruct
////    public void init() throws IOException {
////        FileInputStream serviceAccount =
////                new FileInputStream("src/main/google-services.json");
////
////        FirebaseOptions options = new FirebaseOptions.Builder()
////                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
////                .build();
////
////        FirebaseApp.initializeApp(options);
////    }
//}
