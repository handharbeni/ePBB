package io.github.handharbeni.epbb.apis;

import android.content.Context;

import io.github.handharbeni.epbb.utils.Constant;
import io.github.handharbeni.epbb.utils.UtilDb;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    private static final String BASE_URL = Constant.BASE_URL;
    private static Context context;
    private static final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static final OkHttpClient builderOkHttp = new OkHttpClient.Builder()
            .addInterceptor(chain -> {
                String token = new UtilDb(context).getString(Constant.TOKEN);
                Request request = chain.request()
                        .newBuilder()
                        .addHeader("authorization", token)
                        .build();
                return chain.proceed(request);
            })
            .addInterceptor(loggingInterceptor)
            .build();

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(builderOkHttp)
            .addConverterFactory(GsonConverterFactory.create());

    private static final Retrofit retrofit = builder.build();

    private static volatile Object instances;

    public static <T> T getInstance(Context contexts, Class<T> type) {
        context = contexts;
        synchronized (Client.class) {
            instances = retrofit.create(type);
        }
        return (T) Client.instances;
    }
}