package com.wira_fkom.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.wira_fkom.myapplication.databinding.ActivityCreateBinding;


public class CreateActivity extends AppCompatActivity {
    private ActivityCreateBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mengambil input dari EditText
                String username = binding.usernameEditText.getText().toString();
                String email = binding.emailEditText.getText().toString();
                String password = binding.passwordEditText.getText().toString();

                // Memeriksa apakah input kosong
                if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(CreateActivity.this, "Isi semua bidang", Toast.LENGTH_SHORT).show();
                } else {
                    // Jika input tidak kosong, kirim data ke RegisterSuccess
                    Intent intent = new Intent(CreateActivity.this, RegisterSuccess.class);
                    intent.putExtra("username", username);
                    intent.putExtra("email", email);
                    intent.putExtra("password", password);
                    startActivity(intent);
                }
            }
        });
    }
}