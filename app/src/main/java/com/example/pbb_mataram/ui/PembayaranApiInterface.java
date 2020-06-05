package com.example.pbb_mataram.ui;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PembayaranApiInterface {
    String BASE_URL = "http://bkd.sangat.top/ws_pbb_mtr/";

    @GET("index.php/search/{nop}/{key}")
    Call<SearchListModel> getPembayaran(@Path(value="nop") String nop, @Path(value="key")String key);

    @GET("index.php/status/{nop}/{tahun}/{key}")
    Call<NewModel> getListPembayaran(@Path(value="nop") String nop,@Path(value="tahun")String tahun, @Path(value="key")String key);

    @POST("index.php/update/{key}")
    Call<NewModel> postUpdateBayar(@Path(value="nop") String nop,@Path(value="tahun")String tahun,@Path(value="tagihan")String tagihan,
                                   @Path(value="biayadenda")String biayadenda,
                                   @Path(value="biayaadmin")String biayaadmin,@Path(value="tottagihan")String tottagihan,
                                   @Path(value="wp_nama")String wp_nama,@Path(value="key")String key);

    @GET("index.php/cetak/{id_bayar}/{key}")
    Call<CetakModel> getCetak(@Path(value="id_bayar") String id_bayar, @Path(value="key")String key);

//    @FormUrlEncoded
//    @HTTP(method = "GET", path = "index.php/search/{nop}/{key}", hasBody = true)
//    Call<SearchListModel> getPembayaran(@Field("id") String id);
}
