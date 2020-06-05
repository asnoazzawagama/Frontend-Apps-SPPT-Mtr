package com.example.pbb_mataram;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pbb_mataram.ui.ApiInterface;
import com.example.pbb_mataram.ui.LoginInterface;
import com.example.pbb_mataram.ui.LoginModel;
import com.example.pbb_mataram.ui.NewModel;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    private EditText cek_username,cek_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        cek_username = (EditText) findViewById(R.id.cek_username);
        cek_password = (EditText) findViewById(R.id.cek_password);
    }
    public void login(View view) {
//        userLogin();
        final String nama = cek_username.getText().toString().trim();
        final String password = cek_password.getText().toString().trim();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("username",nama);
        intent.putExtra("password",password);
        startActivity(intent);
    }

    private void userLogin() {
        final String nama = cek_username.getText().toString().trim();
        final String password = cek_password.getText().toString().trim();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LoginInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LoginInterface api = retrofit.create(LoginInterface.class);

        if (nama.isEmpty()){
            cek_username.setError("Username Tidak Boleh Kosong");
            cek_username.requestFocus();
            return;
        }
        if (password.isEmpty()){
            cek_password.setError("Password Tidak Boleh Kosong");
            cek_password.requestFocus();
            return;
        }
        if (password.length()<=5){
            cek_password.setError("Password Minimal 5 Karakter");
            cek_password.requestFocus();
            return;
        }

        Call<LoginModel> call = api.getLogin(nama,password);

        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {


                if (response.isSuccessful()){
                    LoginModel loginResponse = response.body();
                    if (loginResponse.getMessage().equals("Login Berhasil")){
                        Toast.makeText(LoginActivity.this,"Login Berhasil",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("username",nama);
                        intent.putExtra("password",password);
                        startActivity(intent);
                    }
                    else if (loginResponse.getMessage().equals("Password Salah")){
                        Toast.makeText(LoginActivity.this,"Password Salah",Toast.LENGTH_LONG).show();
                    }
                    else if (loginResponse.getMessage().equals("Login Gagal")){
                        Toast.makeText(LoginActivity.this,"Login Gagal, Pastikan Data Anda sudah benar",Toast.LENGTH_LONG).show();
                    }
                    Log.e("onResponse: ",loginResponse.getMessage() );
                }
                else {
                    Toast.makeText(LoginActivity.this,"Ulang Kembali, Pastikan Data Anda Benar",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("password",password);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"Pastikan sudah terkoneksi dengan internet",Toast.LENGTH_LONG).show();
            }
        });

    }
    private void showCustomDialog() {
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.my_dialog_err, viewGroup, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
