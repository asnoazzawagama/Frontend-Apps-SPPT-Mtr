package com.example.pbb_mataram.ui;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SendPenyampaianApiInterface {
    String BASE_URL = "http://10.0.2.2/restci/";

    @FormUrlEncoded
    @POST("index.php/sppt/add/")
    Call<SendPenyampaianListModel> postPenyampaian(@Field(value="nop") String nop, @Field(value="nama") String nama, @Field(value="tahun") String tahun, @Field(value="alamat") String alamat, @Field(value="payment_flag") String payment_flag);


}
