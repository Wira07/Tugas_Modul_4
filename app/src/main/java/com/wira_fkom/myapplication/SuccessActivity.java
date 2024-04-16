package com.wira_fkom.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.wira_fkom.myapplication.databinding.ActivitySuccessBinding;

public class SuccessActivity extends AppCompatActivity {
    private ActivitySuccessBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySuccessBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Menerima data dari Intent
        Intent intent = getIntent();
        if (intent != null) {
            String username = intent.getStringExtra("username");
            String password = intent.getStringExtra("password");

            // Menampilkan data yang diterima di EditText
            binding.editTextUsername.setText(username);
            binding.editTextPassword.setText(password);

            // Menyimpan data ke SharedPreferences
            saveCredentials(username, password);
        }

        // Mengatur listener klik untuk tombol "kembali"
        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kembali ke halaman login
                Intent intent = new Intent(SuccessActivity.this, LoginActivity.class);

                // Menambahkan flag untuk membersihkan tumpukan aktivitas
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                startActivity(intent);
            }
        });
    }

    private void saveCredentials(String username, String password) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();
    }
}






//package com.wira_fkom.myapplication;
//
//import android.content.Context;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Toast;
//import androidx.appcompat.app.AppCompatActivity;
//import com.wira_fkom.myapplication.databinding.ActivitySuccessBinding;
//
//public class SuccessActivity extends AppCompatActivity {
//    private ActivitySuccessBinding binding;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivitySuccessBinding.inflate(getLayoutInflater());
//        View view = binding.getRoot();
//        setContentView(view);
//
//        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String username = binding.editTextUsername.getText().toString();
//                String password = binding.editTextPassword.getText().toString();
//
//                // Simpan username dan password ke SharedPreferences
//                saveCredentials(username, password);
//
//                // Tampilkan pesan sukses
//                Toast.makeText(SuccessActivity.this, "Username dan password berhasil disimpan!", Toast.LENGTH_SHORT).show();
//
//                // Kembali ke halaman login
//                Intent intent = new Intent(SuccessActivity.this, LoginActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//    }
//    private void saveCredentials(String username, String password) {
//        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("username", username);
//        editor.putString("password", password);
//        editor.apply();
//    }
//}