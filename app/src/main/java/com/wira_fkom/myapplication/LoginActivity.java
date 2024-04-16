package com.wira_fkom.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.wira_fkom.myapplication.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mengambil input dari EditText
                String username = binding.usernameEditText.getText().toString();
                String password = binding.passwordEditText.getText().toString();

                // Memeriksa apakah input kosong
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Isi semua bidang", Toast.LENGTH_SHORT).show();
                } else {
                    // Jika input tidak kosong, kirim data ke RegisterSuccess
                    Intent intent = new Intent(LoginActivity.this, SuccessActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    startActivity(intent);
                }
            }
        });

//         Mengatur listener klik untuk tombol signup
        binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mulai aktivitas CreateActivity
                Intent intent = new Intent(LoginActivity.this, CreateActivity.class);
                startActivity(intent);
            }
        });
    }
}











//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Toast;
//import androidx.appcompat.app.AppCompatActivity;
//import com.wira_fkom.myapplication.databinding.ActivityLoginBinding;
//
//public class LoginActivity extends AppCompatActivity {
//    private ActivityLoginBinding binding;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivityLoginBinding.inflate(getLayoutInflater());
//        View view = binding.getRoot();
//        setContentView(view);
//
//        // Mengatur listener klik untuk tombol login
//        binding.loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Mendapatkan input dari EditText
//                String username = binding.usernameEditText.getText().toString();
//                String password = binding.passwordEditText.getText().toString();
//
//                // Misalnya, lakukan pengecekan sederhana untuk login
//                if (username.equals("admin") && password.equals("password")) {
//                    // Jika login berhasil, tampilkan pesan sukses dan arahkan ke SuccessActivity
//                    Toast.makeText(LoginActivity.this, "Berhasil login sebagai " + username, Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(LoginActivity.this, SuccessActivity.class);
//                    startActivity(intent);
//                } else {
//                    // Jika login gagal, tampilkan pesan kesalahan
//                    Toast.makeText(LoginActivity.this, "Username atau password salah", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        // Mengatur listener klik untuk tombol signup
//        binding.signupButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Mulai aktivitas CreateActivity
//                Intent intent = new Intent(LoginActivity.this, CreateActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
//}

