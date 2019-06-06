package com.example.mysql.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.mysql.repository.UserRestClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class RestClientConfiguration {

	private static final String URI_USER = "http://localhost:8080/";
//	private static final String URI_USER = "https://a6253090-56f7-4196-8e71-8cedb14e002c.mock.pstmn.io/localhost:9090/";

	@Bean
	UserRestClient userRestClient() {
		return builRetrofit().create(UserRestClient.class);
	}

	private Retrofit builRetrofit() {
		Gson gson = new GsonBuilder().setLenient().create();
//		Gson gson = new GsonBuilder().serializeNulls().create();
//
//	    OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
//	    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//	    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//	    okHttpClientBuilder.addInterceptor(logging);
//	    OkHttpClient okHttpClient = okHttpClientBuilder.build();
	
		Retrofit retrofit = new Retrofit.Builder()
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.addConverterFactory(GsonConverterFactory.create(gson))
				.addConverterFactory(JacksonConverterFactory.create())
				// .addConverterFactory(ScalarsConverterFactory.create())
				.baseUrl(URI_USER)
				.build();
		return retrofit;
	}
}
