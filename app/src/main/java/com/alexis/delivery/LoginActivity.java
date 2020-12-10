package com.alexis.delivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private FirebaseUser mCurrentUser;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

    private TextView mCountry_extension;
    private TextInputEditText mPhoneNumber;

    private Button mSendOTP;
    private ProgressBar mProgressBar;
    private TextView mInformationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        mCurrentUser = mAuth.getCurrentUser();


        mCountry_extension = findViewById(R.id.text_view_254);
        mPhoneNumber = findViewById(R.id.editTextPhone1);
        mSendOTP = findViewById(R.id.button_send_otp);
        mProgressBar = findViewById(R.id.progressBar);
        mInformationText = findViewById(R.id.text_view_information_text);

        mSendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String countryExtension = mCountry_extension.getText().toString();
                String phoneNumber = mPhoneNumber.getText().toString();
                String completeNumber = countryExtension + phoneNumber;

                if (countryExtension.isEmpty() || phoneNumber.isEmpty()){
                    mInformationText.setText(R.string.information_text1);
                    mInformationText.setVisibility(View.VISIBLE);
                }else {
                    mProgressBar.setVisibility(View.VISIBLE);
                    mSendOTP.setEnabled(false);
                    mInformationText.setVisibility(View.INVISIBLE);

                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            completeNumber,        // Phone number to verify
                            60,                 // Timeout duration
                            TimeUnit.SECONDS,   // Unit of timeout
                            LoginActivity.this,               // Activity (for callback binding)
                            mCallbacks);        // OnVerificationStateChangedCallbacks
                }
            }
        });
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }
            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                mInformationText.setText(R.string.verification_failed);
                mInformationText.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.INVISIBLE);
                mSendOTP.setEnabled(true);
            }

            @Override
            public void onCodeSent(final String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
//                new android.os.Handler().postDelayed(
//                        new Runnable() {
//                            public void run() {
                Intent otpIntent = new Intent(LoginActivity.this, OtpConfirmationActivity.class);
                otpIntent.putExtra("AuthCredentials", s);
                startActivity(otpIntent);
            }
//                        },
//                        10000);
//            }
        };
    }
    @Override
    protected void onStart() {
        super.onStart();
        if (mCurrentUser != null){
            sendUserToHome();
        }
    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            sendUserToHome();
                            // Sign in success, update UI with the signed-in user's information
                            // ...
                        } else {
                            // Sign in failed, display a message and update the UI
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                mInformationText.setVisibility(View.VISIBLE);
                                mInformationText.setText(R.string.otp_verification_failed);
                            }
                        }
                        mSendOTP.setEnabled(true);
                        mProgressBar.setVisibility(View.INVISIBLE);
                    }
                });
    }
    public void sendUserToHome(){
        Intent homeIntent = new Intent(LoginActivity.this, MainActivity.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(homeIntent);
        finish();
    }
}
