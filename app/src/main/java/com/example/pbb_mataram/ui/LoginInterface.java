package com.example.pbb_mataram.ui;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LoginInterface {
    String BASE_URL = "http://10.0.2.2/restci/";

    @GET("index.php/sppt/login/")
    Call<LoginModel> getLogin(@Query(value="nama") String nama, @Query(value="password") String password);

    @GET("index.php/sppt/item/")
    Call<ProfilModel> getProfil(@Query(value="nama") String nama, @Query(value="tahun") String tahun);

}
