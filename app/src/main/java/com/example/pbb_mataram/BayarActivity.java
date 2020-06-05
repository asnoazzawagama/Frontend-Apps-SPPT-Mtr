package com.example.pbb_mataram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pbb_mataram.ui.ApiInterface;
import com.example.pbb_mataram.ui.CetakModel;
import com.example.pbb_mataram.ui.NewModel;
import com.example.pbb_mataram.ui.PembayaranApiInterface;
import com.example.pbb_mataram.ui.RetroModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;
import android.os.Handler;
import java.util.logging.LogRecord;

public class BayarActivity extends AppCompatActivity {
    private static final int PERMISSION_STORAGE_CODE = 1000;
    TextView lblPrinterName, wp_nama,alamat,kelurahan,rt,rw,kabkota,kecamatan,tgltempo,tagihan,tarifdenda,biayadenda,biayaadmin,tottagihan;
    EditText input_uang,input_kembali;
    Button btnPrint,btnDisconnect,btnConnect;
    String thn,NOP,nopY;
    private BottomNavigationView bottomNavigationViewX;

    BluetoothAdapter bluetoothAdapter;
    BluetoothSocket bluetoothSocket;
    BluetoothDevice bluetoothDevice;
    OutputStream outputStream;
    InputStream inputStream;
    Thread thread;
    byte[] readBuffer;
    int readBufferPosition;
    volatile boolean stopWorker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayar);

        btnPrint = (Button) findViewById(R.id.btn_cetak);
//        btnConnect = (Button) findViewById(R.id.btnConnect);
//        btnDisconnect = (Button) findViewById(R.id.btnDisconnect);
//        lblPrinterName = (TextView) findViewById(R.id.lblPrinterName);

        wp_nama = (TextView) findViewById(R.id.wp_nama);
        alamat = (TextView) findViewById(R.id.alamat);
        kelurahan = (TextView) findViewById(R.id.kelurahan);
        rt = (TextView) findViewById(R.id.rt);
        rw = (TextView) findViewById(R.id.rw);
        kabkota = (TextView) findViewById(R.id.kabupaten);
        kecamatan = (TextView) findViewById(R.id.kecamatan);
        tgltempo = (TextView) findViewById(R.id.tgl_tempo);
        tagihan = (TextView) findViewById(R.id.tagihan);
        tarifdenda = (TextView) findViewById(R.id.denda);
        biayadenda = (TextView) findViewById(R.id.denda_perbulan);
        biayaadmin = (TextView) findViewById(R.id.biaya_admin);
        tottagihan = (TextView) findViewById(R.id.tottagihan);

        input_uang = (EditText) findViewById(R.id.input_uang);
        input_kembali = (EditText) findViewById(R.id.input_kembali);

        Bundle extras = getIntent().getExtras();
        nopY = extras.getString("username");

        if (extras!=null){
            thn = extras.getString("tahun");
            NOP = extras.getString("nop");
//            tahun_bayar.setText(NOP+" "+thn);

            run();
        }

//        btnPrint.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
//                    if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
//                        String[] permission = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
//                        requestPermissions(permission, PERMISSION_STORAGE_CODE);
//                    }
//                    else {
//                        startDownloading();
//                    }
//                }
//                else {
//                    startDownloading();
//                }
//            }
//
//
//        });

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

//        btnConnect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try{
//                    FindBluetoothDevice();
//                    openBluetoothPrinter();
//
//                }catch (Exception ex){
//                    ex.printStackTrace();
//                }
//            }
//        });
//        btnDisconnect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try{
//                    disconnectBT();
//                }catch (Exception ex){
//                    ex.printStackTrace();
//                }
//            }
//        });
        btnPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cetak();
//                Intent intent = new Intent(Intent.ACTION_SEND);
//                intent.setType("text/plain");
//                intent.putExtra(Intent.EXTRA_TEXT,"");
//                startActivity(intent.createChooser(intent,"SHARE"));
            }
        });
    }

    private void startDownloading() {
        String url = "http://bkd.sangat.top/ws_pbb_mtr/index.php/cetak/1000/pbbm21";

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("File Download KLIK SPPT Kota Mataram");
        request.setDescription("Downloading File....");

        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,""+System.currentTimeMillis());

        DownloadManager manager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PERMISSION_STORAGE_CODE:{
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    startDownloading();
                }
            }
        }
    }

    private void run() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PembayaranApiInterface api = retrofit.create(PembayaranApiInterface.class);

        Call<NewModel> call = api.getListPembayaran(NOP,thn,"pbbm21");

        call.enqueue(new Callback<NewModel>() {


            @Override
            public void onResponse(Call<NewModel> call, Response<NewModel> response) {
                RetroModel retroModel = response.body().getData();
                String status = response.body().getMessage();
                wp_nama.setText(retroModel.getWpNama());
                alamat.setText(retroModel.getWpAlamat());
                kelurahan.setText(retroModel.getSpptTanggalJatuhTempo());
                rt.setText(retroModel.getWpRt());
                rw.setText(retroModel.getWpRw());
                kecamatan.setText(retroModel.getWpKecamatan());
                kabkota.setText(retroModel.getWpKotakab());

                tgltempo.setText(retroModel.getSpptTanggalJatuhTempo());
                tagihan.setText(retroModel.getSpptPbbHarusDibayar());
                tarifdenda.setText(retroModel.getOpTarif());
                biayadenda.setText(retroModel.getPbbDenda());
                biayaadmin.setText(retroModel.getPbbAdminGw());

                tottagihan.setText("(Rp. "+retroModel.getPbbTotalBayar()+" )");

            }

            @Override
            public void onFailure(Call<NewModel> call, Throwable t) {
                Toast.makeText(BayarActivity.this,"LIST DATA PEMBAYARAN",Toast.LENGTH_LONG).show();
            }
        });
    }
    private void update_bayar() {
        String nop,tahun,tagihanX,biayadendaX,biayaadminX,tottagihanX,wp_namaX;

        nop = NOP.trim();
        tahun = thn.trim();
        tagihanX = tagihan.getText().toString().trim();
        biayadendaX = biayadenda.getText().toString().trim();
        biayaadminX = biayaadmin.getText().toString().trim();
        tottagihanX = tottagihan.getText().toString().trim();
        wp_namaX = wp_nama.getText().toString().trim();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PembayaranApiInterface api = retrofit.create(PembayaranApiInterface.class);

        Call<NewModel> call = api.postUpdateBayar(nop,tahun,tagihanX,biayadendaX,biayaadminX,tottagihanX,wp_namaX,"pbbm21");

        call.enqueue(new Callback<NewModel>() {


            @Override
            public void onResponse(Call<NewModel> call, Response<NewModel> response) {
                if (response.isSuccessful()){
//                    int i = 1;
//                    response.body().getData().setPaymentFlag(i).toString();
                    Toast.makeText(BayarActivity.this,"BERHASIL", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NewModel> call, Throwable t) {
                Toast.makeText(BayarActivity.this,"LIST DATA PEMBAYARAN ERROR",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void kembalian(View view) {
        String x = input_uang.getText().toString();
        String y = tagihan.getText().toString();

        int xx = Integer.parseInt(x);
        int yy = Integer.parseInt(y);
        int jumlah = xx-yy;

        String jum = Integer.toString(jumlah);
        input_kembali.setEnabled(false);
        input_kembali.setText(jum);

    }
    public void bayar(View view) {
        update_bayar();
    }

    private void cetak() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PembayaranApiInterface api = retrofit.create(PembayaranApiInterface.class);

        Call<CetakModel> call = api.getCetak("0","pbbm21");

        call.enqueue(new Callback<CetakModel>() {


            @Override
            public void onResponse(Call<CetakModel> call, Response<CetakModel> response) {
//                RetroModel retroModel = response.body().get;
                String status = response.body().getMessage();
                Boolean sukses = response.body().getSuccess();


                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"____HASIL PEMBAYARAN____\n"+status+sukses+"\n\n______BKD MATARAM______");
                startActivity(intent.createChooser(intent,"SHARE"));
                Log.e("onResponse--------: ",response.toString() );
            }

            @Override
            public void onFailure(Call<CetakModel> call, Throwable t) {
                Toast.makeText(BayarActivity.this,"Mohon Periksa Koneksi Internet Anda",Toast.LENGTH_LONG).show();
            }
        });
    }

    void FindBluetoothDevice(){

        try {

            bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            if (bluetoothAdapter==null){
                lblPrinterName.setText("Tidak Ada Perangkat Bluetooth");
            }
            if (bluetoothAdapter.isEnabled()){
                Intent enableBT = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBT,0);
            }

            Set<BluetoothDevice> pairedDevice = bluetoothAdapter.getBondedDevices();

            if (pairedDevice.size()>0){
                for (BluetoothDevice pairedDev:pairedDevice){
                    if (pairedDev.getName().equals("BTP_F09F1A")){
                        bluetoothDevice=pairedDev;
                        lblPrinterName.setText("Bluetooth Printer Attached"+pairedDev.getName());
                        break;
                    }
                }
            }
            lblPrinterName.setText("Bluetooth Printer Attached");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    void openBluetoothPrinter(){
        try {
            UUID uuidString = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
            bluetoothSocket = bluetoothDevice.createRfcommSocketToServiceRecord(uuidString);
            bluetoothSocket.connect();
            outputStream = bluetoothSocket.getOutputStream();
            inputStream = bluetoothSocket.getInputStream();

            beginListenData();
        }catch (Exception ex){

        }
    }

    void beginListenData(){
        try {
            final Handler handler = new Handler();
            final byte delimiter = 10;
            stopWorker = false;
            readBufferPosition = 0;
            readBuffer = new byte[1024];

            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!Thread.currentThread().isInterrupted() && !stopWorker){
                        try {
                            int byteAvailable = inputStream.available();
                            if (byteAvailable>0){
                                byte[] packetByte = new byte[byteAvailable];
                                inputStream.read(packetByte);

                                for (int i = 0; i<byteAvailable; i++){
                                    byte b = packetByte[i];
                                    if (b==delimiter){
                                        byte[] encodedByte = new byte[readBufferPosition];
                                        System.arraycopy(
                                                readBuffer,0,
                                                encodedByte,0,
                                                encodedByte.length
                                        );
                                        final String data = new String(encodedByte,"US-ASCII");
                                        readBufferPosition=0;
                                        handler.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                lblPrinterName.setText(data);
                                            }
                                        });
                                    }
                                    else{
                                        readBuffer[readBufferPosition++]=b;
                                    }
                                }
                            }
                        }catch (Exception ex){
                            stopWorker=true;
                        }
                    }
                }
            });
            thread.start();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    void printData() throws IOException{
        try{
            String msg = input_uang.getText().toString();
            msg+="\n";
            outputStream.write(msg.getBytes());
            lblPrinterName.setText("Printing Text...");
        }catch (Exception ex){
            ex.printStackTrace();
        }

        //

    }

    // Disconnect Printer //
    void disconnectBT() throws IOException{
        try {
            stopWorker=true;
            outputStream.close();
            inputStream.close();
            bluetoothSocket.close();
            lblPrinterName.setText("Printer Disconnected.");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
