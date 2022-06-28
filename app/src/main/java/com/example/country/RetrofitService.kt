package com.example.country

import com.example.country.model.country.CountryResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface RetrofitService {

    @GET("countries")
    fun getAllCountries(
        @Header("X-RapidAPI-Key") token: String,
        @Query("limit") limit: String
    ): Call<CountryResponse>

    @GET("countries/{countryCode}")
    fun getCountryDetail(
        @Path("countryCode") countryCode: String,
        @Header("X-RapidAPI-Key") token: String
    ): Call <CountryDetailResponse>

    companion object {
        var retrofitService: RetrofitService? = null

        fun getInstance(): RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://wft-geo-db.p.rapidapi.com/v1/geo/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}