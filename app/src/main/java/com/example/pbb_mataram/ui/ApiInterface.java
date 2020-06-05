package com.example.pbb_mataram.ui;

import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    String BASE_URL = "http://bkd.sangat.top/ws_pbb_mtr/";

    @GET("index.php/status/{nop}/{tahun}/{key}")
    Call<NewModel> getRetro(@Path(value="nop") String nop,@Path(value="tahun")String tahun, @Path(value="key")String key);

    @POST("index.php/status/{nop}/{tahun}/{key}")
    Call<NewModel> getLogin(@Path(value = "nop") String nop,@Path(value = "tahun") String tahun,@Path(value = "key") String key);

}

