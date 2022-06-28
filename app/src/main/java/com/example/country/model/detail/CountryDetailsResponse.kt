package com.example.country

import com.example.country.model.detail.CountryDetail
import com.google.gson.annotations.SerializedName

data class CountryDetailResponse(
    @SerializedName("data")
    val data: CountryDetail
)