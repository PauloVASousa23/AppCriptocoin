package com.pim.criptocoin.Interfaces;

import com.pim.criptocoin.model.Perfil;
import com.pim.criptocoin.model.PerfilResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitSetPerfilResult {
    @POST("Perfil")
    Call<Boolean> setPerfil(@Body Perfil perfil);
}
