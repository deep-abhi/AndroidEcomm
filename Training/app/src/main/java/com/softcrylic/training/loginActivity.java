package com.softcrylic.training;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.loopj.android.http.RequestParams;
import com.softcrylic.training.activity.main2Activity;

import org.json.JSONException;


public class loginActivity extends AppCompatActivity {

    private EditText editText1, editText2;
    private Button loginBtn;
    private static final String TAG = "GoogleActivity";
    private static final int RC_SIGN_IN = 9001;
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    public static String username ;
    public static String profilepicURL;
    RequestParams rp = new RequestParams();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }
    public void userLogin(View view)  {

        editText1 = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        String userName = editText1.getText().toString();
        String passWord = editText2.getText().toString();

        mAuth.signInWithEmailAndPassword(userName, passWord)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        String TAG= " ";
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(loginActivity.this, "sign-in success.",
                                    Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(loginActivity.this,main2Activity.class));
                        } else {
                            Toast.makeText(loginActivity.this, "Invalid Details.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    public void signUpScreen(View view)
    {
        Intent intent = new Intent(loginActivity.this,registration.class);
        startActivity(intent);
    }
    public void signIn(View view){
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                Log.w(TAG, "Google sign in failed", e);
            }
        }
    }

    private void firebaseAuthWithGoogle(final GoogleSignInAccount acct) {

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();

                            Toast.makeText(loginActivity.this, "Login Success.",
                                    Toast.LENGTH_SHORT).show();
                            getUserDetail(acct);
                        } else {
                            Toast.makeText(loginActivity.this, "Failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void getUserDetail(GoogleSignInAccount acct){

      username = acct.getDisplayName();
      profilepicURL = acct.getPhotoUrl().toString();

      startActivity(new Intent(loginActivity.this,main2Activity.class));

    }
}
