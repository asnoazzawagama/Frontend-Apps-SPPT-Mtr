package com.example.pbb_mataram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pbb_mataram.ui.AdapterPembayaran;
import com.example.pbb_mataram.ui.ApiInterface;
import com.example.pbb_mataram.ui.PembayaranApiInterface;
import com.example.pbb_mataram.ui.SearchApiInterface;
import com.example.pbb_mataram.ui.SearchListModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PembayaranActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private RecyclerView recyclerView;
    private RecyclerView data;
    private Adapter adapter;
    private String nop,tahun,nopY;
    private EditText input_tahun,input_nop;
    private BottomNavigationView bottomNavigationViewX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);
        input_nop = (EditText) findViewById(R.id.input_nop);
//        initViews();
//        run();
        Bundle extras = getIntent().getExtras();
        nopY = extras.getString("username");
//        nameApps = (TextView) findViewById(R.id.nop);
//        if (extras!=null){
//            nameApps.setText("(NOP: "+nopY+")");
//            Log.d( "onCreate: ",nopY);
//        }

        bottomNavigationViewX = findViewById(R.id.bottomNavigationView2);

        bottomNavigationViewX.setSelectedItemId(R.id.nav_pembayaran);

        bottomNavigationViewX.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        intent.putExtra("username", nopY);
                        startActivity(intent);
                        return false;
                    case R.id.nav_penyampaian:
                        Intent i = new Intent(getApplicationContext(),PenyampaianSPPTActivity.class);
                        i.putExtra("username", nopY);
                        startActivity(i);
                        return false;
                    case R.id.nav_pembayaran:
                        return true;
                    case R.id.nav_tunggakan:
                        Intent in = new Intent(getApplicationContext(),DaftarTunggakanActivity.class);
                        in.putExtra("username", nopY);
                        startActivity(in);
                        return false;
                }
                return false;
            }
        });
    }
    private void initViews(){

        recyclerView = (RecyclerView)findViewById(R.id.rv_list_pembayaran);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
    }
    private void run(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PembayaranApiInterface api = retrofit.create(PembayaranApiInterface.class);
        nop = input_nop.getText().toString().trim();

        Call<SearchListModel> call = api.getPembayaran(nop,"pbbm21");

        call.enqueue(new Callback<SearchListModel>() {


            @Override
            public void onResponse(Call<SearchListModel> call, Response<SearchListModel> response) {
                AdapterPembayaran adapter = new AdapterPembayaran(response.body().getItem());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<SearchListModel> call, Throwable t) {
                Toast.makeText(getBaseContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                Log.e("RETROFIT GET", t.getMessage());
            }

        });
    }
    public void pembayaran(View view) {
        nop = input_nop.getText().toString().trim();
        Intent intent = new Intent(getApplicationContext(),NextPembayaranActivity.class);
        intent.putExtra("nop",nop);
        startActivity(intent);
        //run();
    }
}
