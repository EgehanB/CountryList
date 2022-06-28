package com.example.country.model.detail

import com.google.gson.annotations.SerializedName

class CountryDetail{

    @SerializedName("name")
    val name: String? = null

    @SerializedName("code")
    val code: String? = null

    @SerializedName("flagImageUri")
    val flagImageUri: String?= null

    @SerializedName("wikiDataId")
    val wikiDataId: String? = null
}
