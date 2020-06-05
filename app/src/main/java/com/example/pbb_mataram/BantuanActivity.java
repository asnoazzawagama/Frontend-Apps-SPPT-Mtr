package com.example.pbb_mataram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BantuanActivity extends AppCompatActivity {

    String nopY;
    private BottomNavigationView bottomNavigationViewX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan);
        Bundle extras = getIntent().getExtras();
        nopY = extras.getString("username");
//        nameApps = (TextView) findViewById(R.id.nop);
        if (extras!=null){
//            nameApps.setText("(NOP: "+nopY+")");
            Log.d( "onCreate: ",nopY);
        }

        bottomNavigationViewX = findViewById(R.id.bottomNavigationView);

        bottomNavigationViewX.setSelectedItemId(R.id.nav_bantuan);

        bottomNavigationViewX.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
//                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        intent.putExtra("username", nopY);
                        startActivity(intent);
                        return false;
                    case R.id.nav_bantuan:
                        return true;
                    case R.id.nav_logout:
                        Intent i = new Intent(BantuanActivity.this, LoginActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                }
                return false;
            }
        });
    }
}
