package com.pim.criptocoin.Interfaces;


import com.pim.criptocoin.model.Conta;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitSetConta {
    @POST("Conta")
    Call<Conta> setConta(@Body Conta conta);
}
