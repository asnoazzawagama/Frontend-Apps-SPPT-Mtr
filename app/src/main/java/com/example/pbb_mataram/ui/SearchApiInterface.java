package com.example.pbb_mataram.ui;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import java.net.URL;
import java.util.List;
import retrofit2.http.Query;

public interface SearchApiInterface {

        String BASE_URL = "http://bkd.sangat.top/ws_pbb_mtr/";

        @GET("index.php/search/{nop}/{key}")
        Call<SearchListModel> getSearch(@Path(value="nop") String nop, @Path(value="key")String key);
    }
