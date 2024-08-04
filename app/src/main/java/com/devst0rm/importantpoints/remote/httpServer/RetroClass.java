package com.devst0rm.importantpoints.remote.httpServer;

import static com.devst0rm.importantpoints.utils.config.APIVersion_1;
import static com.devst0rm.importantpoints.utils.config.mainIP_API;

import com.devst0rm.importantpoints.remote.APIService.APIS_Point;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetroClass {

//    private static final String BASE_PATH = Config.APIAddress; // For Server
    private static final String BASE_PATH = mainIP_API + APIVersion_1; // For Local


    //Cache cache = new Cache(context.getCacheDir(), cacheSize);

    private static OkHttpClient getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory);
            builder.hostnameVerifier((hostname, session) -> true);

            OkHttpClient okHttpClient = builder.build();
            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//     For Server
    private static Retrofit getRetroInstance()
    {
        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder()
                .baseUrl(BASE_PATH).client(getUnsafeOkHttpClient()).addConverterFactory(GsonConverterFactory.create(gson))
                //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

//     For Local
//    private static Retrofit getRetroInstance()
//    {
//        Gson gson = new GsonBuilder().setLenient().create();
//        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
//                .connectTimeout(60, TimeUnit.SECONDS)
//                .readTimeout(60, TimeUnit.SECONDS)
//                .writeTimeout(60, TimeUnit.SECONDS)
//                .build();
//        return new Retrofit.Builder()
//                .baseUrl(BASE_PATH).client(okHttpClient).addConverterFactory(GsonConverterFactory.create(gson))
//                //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();
//    }



    // API Service


    public static APIS_Point getAPIS_Point() {
        return getRetroInstance().create(APIS_Point.class);
    }


}
