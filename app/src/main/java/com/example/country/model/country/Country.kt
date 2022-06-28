package com.example.country.model.country

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Country: Serializable {
    @SerializedName("name")
    val name: String? = null

    @SerializedName("code")
    val code: String? = null
}