package com.pim.criptocoin.Interfaces;

import com.pim.criptocoin.model.Indicacoes;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitSetIndicacao {
    @POST("Indicacao")
    Call<Indicacoes> setIndicacao(@Body Indicacoes indicacoes);
}
