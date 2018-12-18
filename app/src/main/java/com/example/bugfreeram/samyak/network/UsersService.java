package com.example.bugfreeram.samyak.network;

import com.example.bugfreeram.samyak.Models.UserResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface UsersService {

    @GET
    Observable<UserResponse> fetchUsers(@Url String url);
}
