package com.softcrylic.training;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.loopj.android.http.RequestParams;
import com.softcrylic.training.activity.main2Activity;

public class registration extends AppCompatActivity {

    private FirebaseAuth mAuth;
    homepageActivity obj = new homepageActivity();
    private EditText editText1, editText2,editText3,editText4  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mAuth = FirebaseAuth.getInstance();
    }

    public void onPress(View view){
        Intent intent = new Intent(registration.this,loginActivity.class);
        startActivity(intent);
    }

    public void newUser(View view){

        editText1 = (EditText) findViewById(R.id.emailText);
        editText2 = (EditText) findViewById(R.id.passwordText);

        String email = editText1.getText().toString();
        String password = editText2.getText().toString();

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        String TAG ="";
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                          //  Toast.makeText(registration.this, "Account Created",
                            //        Toast.LENGTH_SHORT).show();
                            addUserDetail();
                        } else {
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(registration.this, "Already exists.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void addUserDetail(){

        editText3 = (EditText) findViewById(R.id.firstText);
        editText4 = (EditText) findViewById(R.id.lastText);

        String first = editText1.getText().toString();
        String last = editText2.getText().toString();
        String userName =  first + " "+ last;

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(userName)
                .setPhotoUri(Uri.parse("https://playwise.s3.amazonaws.com/uat/items/assets/imagecontent/QID-4-2923.jpg"))
                .build();
        user.updateProfile(profileUpdates)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(registration.this, "Profile Created.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(registration.this,main2Activity.class);
                            startActivity(intent);
                        }
                    }
                });
    }
}
