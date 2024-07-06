package com.example.firebaseConfig;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class DataService {

    // Firestore instance for database operations
    private static Firestore db;

    // Static block to initialize Firebase when the class is loaded
    static {
        try {
            initializeFirebase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        private static void initializeFirebase() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("src\\main\\resources\\javafx-firebasestore-c3012-firebase-adminsdk-iu034-d2c6730c43.json");

        // Configure Firebase options with the credentials
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        // Initialize Firebase app with the options
        FirebaseApp.initializeApp(options);
        // Get Firestore instance
        db = FirestoreClient.getFirestore();
    }

    // Method to add data to a specified collection and document
    public void addData(String collection, String document, Map<String, Object> data) throws ExecutionException, InterruptedException {
        DocumentReference docRef = db.collection(collection).document(document);
        ApiFuture<WriteResult> result = docRef.set(data);
        // Block until the write operation is complete
        result.get();
    }

    // Method to retrieve data from a specified collection and document
    public DocumentSnapshot getData(String collection, String document) throws ExecutionException, InterruptedException {
        try {
            DocumentReference docRef = db.collection(collection).document(document);
            ApiFuture<DocumentSnapshot> future = docRef.get();
            // Block until the read operation is complete and return the document snapshot
            return future.get();
        } catch (Exception e) {
            // Print the stack trace for debugging
            e.printStackTrace();
            // Re-throw the exception or handle it based on your application's needs
            throw e;
        }
    }

    // Method to authenticate a user by comparing the provided password with the stored password
    public boolean authenticateUser(String username, String password) throws ExecutionException, InterruptedException {
        // Retrieve the document for the user with the given username
        DocumentSnapshot document = db.collection("users").document(username).get().get();
        if (document.exists()) {
            // Get the stored password from the document
            String storedPassword = document.getString("password");
            // Compare the provided password with the stored password
            return password.equals(storedPassword);
        }
        return false;
    }

	public boolean createUser(String username, String password) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'createUser'");
	}

    public String signIn(String email, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'signIn'");
    }
}
