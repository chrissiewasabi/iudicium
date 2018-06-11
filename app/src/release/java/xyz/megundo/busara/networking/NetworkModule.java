package xyz.megundo.busara.networking;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Module
public abstract class NetworkModule {


    @Provides
    @Singleton
    static Call.Factory provideOkHttp(){
        OkHttpClient.Builder okHttpClientBuilder=new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor();
        okHttpClientBuilder.readTimeout(60, TimeUnit.SECONDS);
        okHttpClientBuilder.connectTimeout(60, TimeUnit.SECONDS);
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);




        return okHttpClientBuilder.build();
    }

    @Provides
    @Named("base_url")
    static String provideBaseUrl(){
        return "http://api.smartduka.busaracenterlab.org/api/v1/";
    }
}
