package com.example.pbb_mataram.ui;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PenyampaianApiInterface {

    String BASE_URL = "http://bkd.sangat.top/ws_pbb_mtr/";

    @GET("index.php/search/{nop}/{tahun}/{key}")
    Call<SearchListModel> getPenyampaian(@Path(value="nop") String nop,@Path(value="tahun")String tahun, @Path(value="key")String key);
}
