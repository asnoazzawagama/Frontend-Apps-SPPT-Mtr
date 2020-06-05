package com.example.pbb_mataram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.pbb_mataram.ui.AdapterPenyampaian;
import com.example.pbb_mataram.ui.ApiInterface;
import com.example.pbb_mataram.ui.PenyampaianApiInterface;
import com.example.pbb_mataram.ui.SearchListModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NextPenyampaianActivity extends AppCompatActivity {
    private String nop,tahun,username;
    private BottomNavigationView bottomNavigationViewX;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_penyampaian);

        initViews();
        run();

        Bundle extras = getIntent().getExtras();
        username = extras.getString("username");

        bottomNavigationViewX = findViewById(R.id.bottomNavigationView2);

        bottomNavigationViewX.setSelectedItemId(R.id.nav_penyampaian);

        bottomNavigationViewX.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        intent.putExtra("username", username);
                        startActivity(intent);
                        return false;
                    case R.id.nav_penyampaian:
                        return true;
                    case R.id.nav_pembayaran:
                        Intent i = new Intent(getApplicationContext(),PembayaranActivity.class);
                        i.putExtra("username", username);
                        startActivity(i);
                        return false;
                    case R.id.nav_tunggakan:
                        Intent in = new Intent(getApplicationContext(),DaftarTunggakanActivity.class);
                        in.putExtra("username", username);
                        startActivity(in);
                        return false;
                }
                return false;
            }
        });
    }
    private void initViews(){

        recyclerView = (RecyclerView)findViewById(R.id.rv_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

    }
    private void showCustomDialog() {
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.my_dialog_err, viewGroup, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void run(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PenyampaianApiInterface api = retrofit.create(PenyampaianApiInterface.class);
        Bundle extras = getIntent().getExtras();
        String nopX = extras.getString("nop");
        String tahunX = extras.getString("tahun");

        Call<SearchListModel> call = api.getPenyampaian(nopX,tahunX,"pbbm21");

        call.enqueue(new Callback<SearchListModel>() {


            @Override
            public void onResponse(Call<SearchListModel> call, Response<SearchListModel> response) {

                AdapterPenyampaian adapter = new AdapterPenyampaian(response.body().getItem());
                recyclerView.setAdapter(adapter);
//                Toast.makeText(getBaseContext(),response.message(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<SearchListModel> call, Throwable t) {
//                Toast.makeText(getBaseContext(),t.getMessage(),Toast.LENGTH_LONG).show();
//                Log.e("RETROFIT GET", t.getMessage());
//                showCustomDialog();
            }

        });
    }
}
