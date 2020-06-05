package com.example.pbb_mataram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.pbb_mataram.ui.ApiInterface;
import com.example.pbb_mataram.ui.LoginInterface;
import com.example.pbb_mataram.ui.LoginModel;
import com.example.pbb_mataram.ui.NewModel;
import com.example.pbb_mataram.ui.Profil;
import com.example.pbb_mataram.ui.ProfilModel;
import com.example.pbb_mataram.ui.RetroModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileActivity extends AppCompatActivity {
    String usernameY,passwordY;
    TextView nama, nop, alamat, password;
    private BottomNavigationView bottomNavigationViewX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Bundle extras = getIntent().getExtras();
        usernameY = extras.getString("username");
        passwordY = extras.getString("password");
        nama = (TextView) findViewById(R.id.nama);
        nop = (TextView) findViewById(R.id.nop);
        alamat = (TextView) findViewById(R.id.alamat);
        nama.setText(usernameY);
//        nameApps = (TextView) findViewById(R.id.nop);
        run();

        bottomNavigationViewX = findViewById(R.id.bottomNavigationView);

        bottomNavigationViewX.setSelectedItemId(R.id.nav_logout);

        bottomNavigationViewX.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
//                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        intent.putExtra("username", usernameY);
                        startActivity(intent);
                        return false;
                    case R.id.nav_bantuan:
                        Intent i = new Intent(getApplicationContext(),BantuanActivity.class);
                        i.putExtra("username", usernameY);
                        startActivity(i);
                        return false;
                    case R.id.nav_logout:
                        return true;
                }
                return false;
            }
        });
    }
    private void run() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LoginInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LoginInterface api = retrofit.create(LoginInterface.class);

        Call<ProfilModel> call = api.getProfil("asno","2019");

        call.enqueue(new Callback<ProfilModel>() {


            @Override
            public void onResponse(Call<ProfilModel> call, Response<ProfilModel> response) {
//                if (response.isSuccessful()){
                Profil profil = response.body().getProfil();
//                    data1.setText(retroModel.getNop());
                nama.setText(profil.getNama());
                nop.setText(profil.getNop());
                alamat.setText(profil.getAlamat());
            }

            @Override
            public void onFailure(Call<ProfilModel> call, Throwable t) {

//                showCustomDialog();
            }
        });
    }
}

