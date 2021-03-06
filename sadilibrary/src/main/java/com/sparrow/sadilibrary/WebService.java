package com.sparrow.sadilibrary;


import com.google.gson.Gson;
import com.sparrow.seekerslibrary.JobseekerResponse;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class WebService {
    private static WebServiceInterface webApiInterface;


    public static WebServiceInterface getClient() {
        if (webApiInterface == null) {

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.level(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okclient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(100, TimeUnit.SECONDS)
                    .writeTimeout(100, TimeUnit.SECONDS)
                    .build();
            Retrofit client = new Retrofit.Builder()
                    .baseUrl("http://gohelvijay47932685.ipage.com/mrg_lib/")
                    .client(okclient)
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .build();
            webApiInterface = client.create(WebServiceInterface.class);
        }
        return webApiInterface;
    }

    public interface WebServiceInterface {

        @FormUrlEncoded
        @POST("add_bio.php")
        Call<JobseekerResponse> SendBioData(
                @Field("name") String name,
                @Field("image") String image,
                @Field("dob") String dob,
                @Field("height") String height,
                @Field("weight") String weight,
                @Field("education") String education,
                @Field("profession") String profession,
                @Field("hobbie") String hobbie,
                @Field("religion") String religion,
                @Field("native") String nativ,
                @Field("cast") String cast,
                @Field("marital_status") String marital_status,
                @Field("address") String address,
                @Field("mobile") String mobile,
                @Field("email") String email,
                @Field("grand_father") String grand_father,
                @Field("father") String father,
                @Field("mother") String mother,
                @Field("brother") String brother,
                @Field("sister") String sister,
                @Field("mosal") String mosal,
                @Field("mama") String mama

        );

    }
    }
