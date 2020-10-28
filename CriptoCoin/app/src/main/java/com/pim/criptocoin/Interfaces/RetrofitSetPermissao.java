package com.pim.criptocoin.Interfaces;

import com.pim.criptocoin.model.Permissao;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitSetPermissao {
    @POST("Permissao")
    Call<Permissao> setPermissao(@Body Permissao permissao);
}
