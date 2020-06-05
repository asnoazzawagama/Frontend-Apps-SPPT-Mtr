package com.example.pbb_mataram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pbb_mataram.ui.ApiInterface;
import com.example.pbb_mataram.ui.NewModel;
import com.example.pbb_mataram.ui.RetroModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONException;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DaftarTunggakanActivity extends AppCompatActivity {
    private TextView data1,data2,data3,data4,data5,status_tunggakan;
    private EditText et_nop,et_tahun;
    String nop,tahun, nopY;
    private BottomNavigationView bottomNavigationViewX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_tunggakan);
//        data1 = (TextView) findViewById(R.id.tv_1_status);
        data2 = (TextView) findViewById(R.id.tv_2_status);
        data3 = (TextView) findViewById(R.id.tv_3_status);
//        data4 = (TextView) findViewById(R.id.tv_4_status);
        data5 = (TextView) findViewById(R.id.tv_5_status);
        status_tunggakan = (TextView) findViewById(R.id.status_tunggakan);
        et_nop = (EditText) findViewById(R.id.nop);
        et_tahun = (EditText) findViewById(R.id.tahun);

        Bundle extras = getIntent().getExtras();
        nopY = extras.getString("username");
//        nameApps = (TextView) findViewById(R.id.nop);
//        if (extras!=null){
//            nameApps.setText("(NOP: "+nopY+")");
//            Log.d( "onCreate: ",nopY);
//        }

        bottomNavigationViewX = findViewById(R.id.bottomNavigationView2);

        bottomNavigationViewX.setSelectedItemId(R.id.nav_tunggakan);

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
                        intent = new Intent(getApplicationContext(),PenyampaianSPPTActivity.class);
                        intent.putExtra("username", nopY);
                        startActivity(intent);
                        return false;
                    case R.id.nav_pembayaran:
                        intent = new Intent(getApplicationContext(),PembayaranActivity.class);
                        intent.putExtra("username", nopY);
                        startActivity(intent);
                        return false;
                    case R.id.nav_tunggakan:
                        return true;
                }
                return false;
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

    public void status_tunggakan(View view) {
        run();
    }
    public void checkbox_status(View view){
        Calendar calendar = Calendar.getInstance();
        String currDate = DateFormat.getDateInstance().format(calendar.getTime());
        int year = calendar.get(Calendar.YEAR);
        String yearCurr = Integer.toString(year);

        EditText etDate = findViewById(R.id.tahun);
        etDate.setText(yearCurr);
        etDate.setEnabled(true);
    }
    private void run() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface api = retrofit.create(ApiInterface.class);
//        int x = Integer.parseInt(et_nop.getText().toString());
        if (!et_nop.getText().toString().equals("")||!et_tahun.getText().toString().equals("")){
            nop = et_nop.getText().toString();
            tahun = et_tahun.getText().toString();
        }
        else{
            showCustomDialog();
        }
        Call<NewModel> call = api.getRetro(nop,tahun,"pbbm21");

        call.enqueue(new Callback<NewModel>() {


            @Override
            public void onResponse(Call<NewModel> call, Response<NewModel> response) {
//                if (response.isSuccessful()){
                    RetroModel retroModel = response.body().getData();
                    String status = response.body().getMessage();
//                    data1.setText(retroModel.getNop());
                    data2.setText("NAMA:"+retroModel.getWpNama());
                    data3.setText("ALAMAT:"+retroModel.getWpAlamat());
//                    data4.setText("NO REFERENSI PEMBAYAYARAN:"+retroModel.getPaymentRefNumber());
                    data5.setText("KODE BANK:"+retroModel.getPaymentBankCode());
                    status_tunggakan.setText(status);
            }

            @Override
            public void onFailure(Call<NewModel> call, Throwable t) {
                showCustomDialog();
            }
        });
    }
}
