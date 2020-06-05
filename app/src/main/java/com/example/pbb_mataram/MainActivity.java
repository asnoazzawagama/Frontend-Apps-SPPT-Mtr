package com.example.pbb_mataram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView mTextViewResult;
    SearchView mySearchView;
    ListView myList;
    ArrayList<String> ListPBB;
    ArrayAdapter<String> adapter;
    private Object RequestQueue;
    TextView nop, username;
    Animation atg;
    ImageView imageView2;
    Button btn_logout;
    String nopY,usernameY,passwordY;
    private BottomNavigationView bottomNavigationViewX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        nop = (TextView) findViewById(R.id.nop);
        username = (TextView) findViewById(R.id.username);
        usernameY = extras.getString("username");
        passwordY = extras.getString("password");
        username.setText("Username");
        username.setText(usernameY);


        TextView teks1 = findViewById(R.id.text_);
        TextView teks2 = findViewById(R.id.username);
//        imageView2 = (ImageView) findViewById(R.id.imageView2);
        btn_logout = (Button) findViewById(R.id.btn_logout);
        atg = AnimationUtils.loadAnimation(this, R.anim.atg);

//        imageView2.startAnimation(atg);
        btn_logout.startAnimation(atg);
        teks1.setAnimation(atg);


        Typeface MLight = Typeface.createFromAsset(getAssets(), "font/Aquawax-Pro-DemiBold-trial.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "font/ahellya.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "font/Naville-Regular DEMO.ttf");

        teks1.setTypeface(MLight);
        teks2.setTypeface(MLight);

        bottomNavigationViewX = findViewById(R.id.bottomNavigationView);

        bottomNavigationViewX.setSelectedItemId(R.id.nav_home);

        bottomNavigationViewX.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        return true;
                    case R.id.nav_bantuan:
//                        startActivity(new Intent(getApplicationContext(),BantuanActivity.class));
                        final String user = username.getText().toString().trim();
                        Intent intent = new Intent(getApplicationContext(),BantuanActivity.class);
                        intent.putExtra("username", user);
                        startActivity(intent);
                        return false;
                    case R.id.nav_logout:
                        Intent i = new Intent(MainActivity.this, LoginActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                }
                return false;
            }
        });

    }

    public void page_penyampaian_sppt(View view) {
        final String user = username.getText().toString().trim();
        Intent intent = new Intent(getApplicationContext(),PenyampaianSPPTActivity.class);
        intent.putExtra("username", user);
        startActivity(intent);
    }
    public void page_pembayaran(View view){
        final String user = username.getText().toString().trim();
        Intent intent = new Intent(getApplicationContext(),PembayaranActivity.class);
        intent.putExtra("username", user);
        startActivity(intent);
    }
    public void page_daftar_tunggakan(View view){
        final String user = username.getText().toString().trim();
        Intent intent = new Intent(getApplicationContext(),DaftarTunggakanActivity.class);
        intent.putExtra("username", user);
        startActivity(intent);
    }
    public void page_bantuan(View view){
//        Intent intent = new Intent(MainActivity.this, BantuanActivity.class);
        final String user = username.getText().toString().trim();
        Intent intent = new Intent(getApplicationContext(),BantuanActivity.class);
        intent.putExtra("username", user);
        startActivity(intent);
    }
    public void getstarted(View view) {
        final String user = username.getText().toString().trim();
        Intent intent = new Intent(getApplicationContext(),PenyampaianSPPTActivity.class);
        intent.putExtra("username", user);
        startActivity(intent);
    }


}
