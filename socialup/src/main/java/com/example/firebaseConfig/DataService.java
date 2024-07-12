package com.example.firebaseConfig;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
        FileInputStream serviceAccount = new FileInputStream("src\\main\\resources\\javafx-firebasestore-c3012-firebase-adminsdk-iu034-8cd249e22d.json");

        // Configure Firebase options with the credentials
        @SuppressWarnings("deprecation")
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        // Initialize Firebase app with the options
        FirebaseApp.initializeApp(options);
        // Get Firestore instance
        db = FirestoreClient.getFirestore();
    }

    // Method to update a field in a Firestore document
    public void updateField(String collection, String document, String field, Object value) throws InterruptedException, ExecutionException {
        DocumentReference docRef = db.collection(collection).document(document);
        ApiFuture<WriteResult> update = docRef.update(field, value);
        update.get(); // Block until the operation is complete
    }

    // Method to upload a file to Firebase Storage and return the download URL
    public String uploadFileToStorage(File file, String storagePath) throws IOException {
        // You can customize the bucket name and file path as needed
        String bucketName = "gs://javafx-firebasestore-c3012.appspot.com";
        Storage storage = StorageOptions.getDefaultInstance().getService();

        // Create blob to store the file
        BlobId blobId = BlobId.of(bucketName, storagePath);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/jpeg").build();

        // Upload file to Firebase Storage
        byte[] bytes = Files.readAllBytes(file.toPath());
        storage.create(blobInfo, bytes);

        // Construct the public URL for downloading
        String fileUrl = "https://storage.googleapis.com/" + bucketName + "/" + storagePath;

        return fileUrl;
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

    // Example method to upload a file to Firebase Storage
    public void uploadFile(String filePath, String fileName) throws IOException {
        FileInputStream serviceAccount = new FileInputStream("src\\main\\resources\\javafx-firebasestore-c3012-firebase-adminsdk-iu034-8cd249e22d.json");

        // Configure Firebase options with the credentials
        @SuppressWarnings("deprecation")
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        // Initialize Firebase app with the options
        FirebaseApp.initializeApp(options);

        // Upload file to Firebase Storage
        String bucketName = "gs://javafx-firebasestore-c3012.appspot.com";
        Storage storage = StorageOptions.newBuilder().setCredentials(GoogleCredentials.fromStream(new FileInputStream("src\\main\\resources\\javafx-firebasestore-c3012-firebase-adminsdk-iu034-8cd249e22d.json"))).build().getService();
        BlobId blobId = BlobId.of(bucketName, fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/png").build();
        Path path = Paths.get(filePath);
        byte[] bytes = Files.readAllBytes(path);
        storage.create(blobInfo, bytes);
    }

    // Method to delete a file from Firebase Storage
    public void deleteFileFromStorage(String storagePath) {
        // You can customize the bucket name as needed
        String bucketName = "gs://javafx-firebasestore-c3012.appspot.com";
        Storage storage = StorageOptions.getDefaultInstance().getService();

        // Delete file from Firebase Storage
        BlobId blobId = BlobId.of(bucketName, storagePath);
        storage.delete(blobId);
    }

    // Method to delete a document from Firestore
    public void deleteDocument(String collection, String document) throws ExecutionException, InterruptedException {
        DocumentReference docRef = db.collection(collection).document(document);
        ApiFuture<WriteResult> delete = docRef.delete();
        delete.get(); // Block until the delete operation is complete
    }

    // Method to perform batch writes in Firestore
    public void batchWrite(Map<String, Map<String, Object>> batchData) throws ExecutionException, InterruptedException {
        // Initialize batch
        WriteBatch batch = db.batch();

        // Iterate over batch data
        for (String collection : batchData.keySet()) {
            Map<String, Object> data = batchData.get(collection);
            for (String document : data.keySet()) {
                // Create document reference
                DocumentReference docRef = db.collection(collection).document(document);
                // Set data in batch
                batch.set(docRef, data.get(document));
            }
        }

        // Commit batch
        ApiFuture<List<WriteResult>> future = batch.commit();
        future.get(); // Block until batch is committed
    }

    // Method to query Firestore based on a field, operator, and value
    public List<DocumentSnapshot> queryFirestore(String collection, String field, String operator, Object value) throws ExecutionException, InterruptedException {
        List<DocumentSnapshot> documents = new ArrayList<>();
        CollectionReference collRef = db.collection(collection);

        // Construct query based on operator
        Query query;
        switch (operator) {
            case "==":
                query = collRef.whereEqualTo(field, value);
                break;
            case "<":
                query = collRef.whereLessThan(field, value);
                break;
            // Add more cases for other operators as needed
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }

        // Execute query and retrieve documents
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            documents.add(document);
        }

        return documents;
    }
}