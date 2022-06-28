package com.example.country.repository

import com.example.country.CountryDetailResponse
import com.example.country.RetrofitService
import com.example.country.model.country.CountryResponse
import retrofit2.Call

class MainRepository constructor(private val retrofitService: RetrofitService) {


    fun getAllCountries(): Call<CountryResponse> {
        val API_KEY = "b0035a2f7amsh3cc4552335c43bep193e50jsncf9fbd945eb3"
        val limit = "10"
        return retrofitService.getAllCountries(API_KEY,limit)
    }

    fun getCountryDetail(countryCode: String): Call<CountryDetailResponse> {
        val API_KEY = "b0035a2f7amsh3cc4552335c43bep193e50jsncf9fbd945eb3"
        return retrofitService.getCountryDetail(countryCode,API_KEY)
    }
}