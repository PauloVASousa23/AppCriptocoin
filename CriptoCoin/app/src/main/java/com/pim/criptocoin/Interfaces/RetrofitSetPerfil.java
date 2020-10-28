package com.pim.criptocoin.Interfaces;

import com.pim.criptocoin.model.Perfil;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitSetPerfil {
    @POST("Perfil")
    Call<Perfil> setPerfil(@Body Perfil perfil);
}
