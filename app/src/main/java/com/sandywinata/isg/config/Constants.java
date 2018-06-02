package com.sandywinata.isg.config;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.sandywinata.isg.model.UserModel;

public class Constants extends Application {
    //firebase database
    public final static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public final static DatabaseReference refUser = database.getReference("user");
    public final static DatabaseReference refAcademicCal = database.getReference("academic");
    public final static DatabaseReference refContact = database.getReference("contact");
    public final static DatabaseReference refStudent = database.getReference("student");
    public final static DatabaseReference refPOI = database.getReference("poi");
    public final static DatabaseReference refAttraction = database.getReference("attraction");
    public final static DatabaseReference refWelcome = database.getReference("welcome");
    public final static DatabaseReference refInternational = database.getReference("international");
    public final static DatabaseReference refCampus = database.getReference("campus");
    public final static DatabaseReference refStarting = database.getReference("starting");
    public final static DatabaseReference refProgram = database.getReference("program");
    public final static DatabaseReference refTodo = database.getReference("todo");
    public final static DatabaseReference refBanner = database.getReference("banner");
    public final static DatabaseReference refConversation = database.getReference("conversation");
    public final static DatabaseReference refPoints = database.getReference("points");

    //firebase auth
    public final static FirebaseAuth mAuth = FirebaseAuth.getInstance();
    public static FirebaseUser currentUser;

    //firebase storage
    public static FirebaseStorage storage = FirebaseStorage.getInstance();
    public static StorageReference storageRef = storage.getReference();

    public static UserModel getLoginUser(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("userSession", MODE_PRIVATE);
        String name = prefs.getString("nama", ""); //mengambil sharedpreferences nama
        String role = prefs.getString("role", ""); //mengambil sharedpreferences profile_pic
        String email = prefs.getString("email", ""); //mengambil sharedpreferences email
        return new UserModel(name, email, role);
    }

    public final static String[] campus = {"ZhongGuanCun","LiangXiang"};
}
