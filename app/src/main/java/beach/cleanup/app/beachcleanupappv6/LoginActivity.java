package beach.cleanup.app.beachcleanupappv6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.util.Patterns;

import androidx.appcompat.app.AppCompatActivity;

import beach.cleanup.app.beachcleanupappv6.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    // Set Bindings for both Activity and Database in which it is connected too

    ActivityLoginBinding binding;
    DatabaseHelper databaseHelper;


   // Set the Content View and What activity is being inflated.


    // Define minimum constant password length

    private static final int MIN_PASSWORD_LENGTH = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);


        // When button is pressed checks database for valid loginPassword and loginEmail.
        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.loginEmail.getText().toString();
                String password = binding.loginPassword.getText().toString();
                // If passwords/email is empty popup is shown "Please enter Email and Password"
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please Enter Email and Password", Toast.LENGTH_SHORT).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    // Check if the email matches the standard email pattern
                } else if (password.length() < MIN_PASSWORD_LENGTH) {
                    // Check if the password Length meets the min length requirement
                    Toast.makeText(LoginActivity.this, "Please Enter a password 8 Characters Long ", Toast.LENGTH_SHORT).show();
                } else {

                    // If the password and email are valid it intialls the Login Activity displaying "Login Successful" and redirects to MainActivity.
                    boolean checkCredentials = databaseHelper.checkEmailPassword(email, password);

                    if (checkCredentials) {
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        // If passwords aren't valid the Popup displays "Invalid Credentials"
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // When Login text is pressed the intent to start a SignUpactivity is intialized

        binding.signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}