package com.dina.resepmakanan.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("getRecipe")
    fun getRecipe() : Call<ResponseFood>

    @GET("getCategory")
    fun getKategoriRecipe() : Call<ResponseKategori>

    @GET("recipe/categori/{categori}")
    fun getPerkategori(@Path("categori") categori : Int) : Call<ResponseFood>
}