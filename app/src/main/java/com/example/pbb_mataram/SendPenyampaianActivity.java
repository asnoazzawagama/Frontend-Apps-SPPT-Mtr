package com.example.pbb_mataram;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pbb_mataram.ui.SendPenyampaianApiInterface;
import com.example.pbb_mataram.ui.SendPenyampaianListModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SendPenyampaianActivity extends AppCompatActivity {
    TextView send_nop,send_payment_flag,tv_nop,tv_payment;
    private RecyclerView recyclerView;
    String nopY,namaY,tahunY,alamatY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_penyampaian);

        tv_nop = (TextView) findViewById(R.id.tv_nop);
        tv_payment = (TextView) findViewById(R.id.tv_payment);

        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            nopY = extras.getString("nop");
            namaY = extras.getString("nama");
            tahunY = extras.getString("tahun");
            alamatY = extras.getString("alamat");
//            nopX = Integer.parseInt(nopY);
//            nameApps.setText("(NOP: "+nopY+")");

        }

        initViews();
        run();
    }
    private void initViews(){

        recyclerView = (RecyclerView)findViewById(R.id.rv_list_send_penyampaian);
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
                .baseUrl(SendPenyampaianApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SendPenyampaianApiInterface api = retrofit.create(SendPenyampaianApiInterface.class);

        Call<SendPenyampaianListModel> call = api.postPenyampaian(nopY,namaY,tahunY,alamatY,"Tersampaikan");

        call.enqueue(new Callback<SendPenyampaianListModel>() {


            @Override
            public void onResponse(Call<SendPenyampaianListModel> call, Response<SendPenyampaianListModel> response) {

//                AdapterSendPenyampaian adapter = new AdapterSendPenyampaian(response.body().getSppt());
//                recyclerView.setAdapter(adapter);

                    Intent intent = new Intent(getApplicationContext(),PenyampaianSPPTActivity.class);
                    intent.putExtra("username", nopY);
                    startActivity(intent);

                    Toast.makeText(getBaseContext(),"Penyampaian SPPT Berhasil",Toast.LENGTH_LONG).show();

                    Log.d( "onResponse: ", response.toString());

//                String status = response.body().getStatus();
                //Sppt sppt = (Sppt) response.body().getSppt();

//                tv_nop.setText(sppt.getNop());
//                tv_payment.setText(sppt.getPaymentFlag());
//                List<Sppt> spptList = response.body().getSppt();
//                AdapterSendPenyampaian adapter;
//                adapter = new AdapterSendPenyampaian(spptList);
//                recyclerView.setAdapter(adapter);

//                AdapterSendPenyampaian adapter = new AdapterSendPenyampaian(response.body().getStatus());
//                recyclerView.setAdapter(adapter);
//                Toast.makeText(getBaseContext(),response.message(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<SendPenyampaianListModel> call, Throwable t) {
                Intent intent = new Intent(getApplicationContext(),PenyampaianSPPTActivity.class);
                intent.putExtra("username", nopY);
                startActivity(intent);

                Toast.makeText(getBaseContext(),"Penyampaian SPPT Gagal, Harap Periksa Kembali Data Anda ",Toast.LENGTH_LONG).show();

            }

        });
    }
}
