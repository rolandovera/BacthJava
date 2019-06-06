package com.example.mysql.repository;


import java.util.Map;

import com.example.mysql.model.User;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface UserRestClient {

	@Headers({ "Content-Type: application/json" })
	@GET("users/lista")
	Observable<User> getUsers();
	
	@FormUrlEncoded
	@Headers({ "Accept: text/plain" })
	@POST("users")
	Call<String> createUser(@FieldMap Map<String,String> datos);
	
	@FormUrlEncoded
	@Headers({ "Accept: text/plain" })
    @PUT("users")
    Call<String> updateUser(@FieldMap Map<String,Object> datos);
    
	@FormUrlEncoded
	@Headers({ "Accept: text/plain" })
	@DELETE("users")
	String deleteUser(@FieldMap Map<String,Integer> id);
	
}



