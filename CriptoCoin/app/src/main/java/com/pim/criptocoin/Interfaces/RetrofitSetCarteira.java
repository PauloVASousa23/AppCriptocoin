package com.pim.criptocoin.Interfaces;

import com.pim.criptocoin.model.Carteira;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitSetCarteira {
    @POST("Carteira")
    Call<Carteira> setCarteira(@Body Carteira carteira);
}
