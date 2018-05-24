package com.sandywinata.isg.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.sandywinata.isg.R;
import com.sandywinata.isg.config.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sandywinata.isg.config.Constants.mAuth;

public class Login extends AppCompatActivity {
    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.login)
    Button btnLogin;
    @BindView(R.id.Skip)
    TextView skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(Login.this, MainActivity.class));
            finish();
        }
    }

    @OnClick(R.id.Skip)
    public void skip() {
        startActivity(new Intent(Login.this, MainActivity.class));
        finish();
    }

    @OnClick(R.id.login)
    public void login() {

        if(etEmail.getText().toString().isEmpty()) {
            etEmail.setError("Required!");
            return;
        }
        if(etPassword.getText().toString().isEmpty()) {
            etPassword.setError("Required!");
            return;
        }

        String studentId = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        loginProcess(studentId, password);
    }

    private void loginProcess(final String email, final String password) {
        Constants.refStudent.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (final DataSnapshot ds : dataSnapshot.getChildren()) {
                    final String studentId = (String) ds.child("studentId").getValue();
                    final String emails = (String) ds.child("email").getValue();
                    final String nama = (String) ds.child("name").getValue();

                    if (email.equals(studentId)) {
                        Log.d("student", studentId+"\n"+nama+"\n"+emails);
                        mAuth.signInWithEmailAndPassword(emails, password)
                                .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            FirebaseUser user = mAuth.getCurrentUser();

                                            SharedPreferences.Editor editor = getSharedPreferences("userSession", MODE_PRIVATE).edit();
                                            editor.putString("studentId", studentId);
                                            editor.putString("email", emails);
                                            editor.putString("nama", nama);
                                            editor.apply();

                                            Log.d("", "signInWithEmail:success");
                                            FirebaseUser curUser = Constants.mAuth.getCurrentUser();
                                            Constants.currentUser = curUser;

                                            Intent intent = new Intent(Login.this, MainActivity.class);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            mAuth.createUserWithEmailAndPassword(emails, password)
                                                    .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                                            if (task.isSuccessful()) {
                                                                FirebaseUser user = mAuth.getCurrentUser();
                                                                SharedPreferences.Editor editor = getSharedPreferences("userSession", MODE_PRIVATE).edit();
                                                                editor.putString("studentId", studentId);
                                                                editor.putString("email", emails);
                                                                editor.putString("nama", nama);
                                                                editor.apply();

                                                                Log.d("", "signInWithEmail:success");
                                                                FirebaseUser curUser = Constants.mAuth.getCurrentUser();
                                                                Constants.currentUser = curUser;

                                                                Intent intent = new Intent(Login.this, MainActivity.class);
                                                                startActivity(intent);
                                                                finish();
                                                            } else {
                                                                Toast.makeText(Login.this, "Authentication failed.",
                                                                        Toast.LENGTH_SHORT).show();
                                                            }
                                                        }
                                                    });
                                        }
                                    }
                                });
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("", "Failed to read value.", databaseError.toException());
            }
        });
    }
}
