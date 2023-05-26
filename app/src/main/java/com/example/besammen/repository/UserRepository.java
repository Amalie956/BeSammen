package com.example.besammen.repository;
import androidx.annotation.NonNull;
import com.example.besammen.domain.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import java.util.HashMap;
import java.util.Map;
import com.google.firebase.firestore.FirebaseFirestore;

//Maheen
public class UserRepository {
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public void storeUserDataInFirestoreDatabase(User user){
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("userName", user.getUserName());
        hashMap.put("age", user.getAge());
        hashMap.put("gender", user.getGender());
        hashMap.put("userDiagnosis", user.getDiagnosis());

        db.collection("Users")
                .add(hashMap)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        System.out.println("added");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("error");
                        System.out.println(e);
                    }
                });
    }
}
