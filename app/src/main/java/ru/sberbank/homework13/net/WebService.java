package ru.sberbank.homework13.net;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebService {

    @GET("/{width}/{height}")
    Call<ResponseBody> getImage(@Path("width") int width, @Path("height") int height, @Query("random") String random);
}
