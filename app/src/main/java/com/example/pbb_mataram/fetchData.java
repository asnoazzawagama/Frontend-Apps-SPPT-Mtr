package com.example.pbb_mataram;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchData extends AsyncTask<Void, Void, Void> {
    String data = "";
    String dataParse = "";
    String singleParsed = "";
//    EditText nop;
//    TextView teks1;

    Context activity;

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url = new URL("https://bkd.sangat.top/ws_pbb_mtr/index.php/search/527175000100200670/2020/pbbm21");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            data = bufferedReader.readLine();

//                singleParsed = "Nama" + JO.get("wp_nama") + "\n"+
//                        "NOP" + JO.get("nop") + "\n"+
//                        "Alamat" + JO.get("wp_alamat") + "\n";
//                dataParse = dataParse + singleParsed;
//                String val = (String) JO.get("nop");
//                Toast.makeText(fetchData.class, val, Toast.LENGTH_SHORT).show();

//                if (val.equals(nop.getText().toString()) ){
//                    teks1.setText(Integer.parseInt(val));
//                }


        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            Toast.makeText(activity, String.valueOf(ex), Toast.LENGTH_SHORT).show();
        } catch (IOException ex) {
            ex.printStackTrace();
            Toast.makeText(activity, String.valueOf(ex), Toast.LENGTH_SHORT).show();
//        } catch (JSONException e) {
//            e.printStackTrace();
        }

        return null;
    }


    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

//        PenyampaianSPPTActivity.data.setText(this.data);
    }
}
