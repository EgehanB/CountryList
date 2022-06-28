package com.example.country

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.country.model.country.Country
import com.example.country.model.country.CountryResponse
import com.example.country.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(
    private val repository: MainRepository

) : ViewModel() {

    val countryList = MutableLiveData<List<Country>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllCountries() {

        val response = repository.getAllCountries()
        response.enqueue(object : Callback<CountryResponse> {
            override fun onResponse(
                call: Call<CountryResponse>,
                response: Response<CountryResponse>
            ) {
                countryList.postValue(response.body()!!.data)
            }

            override fun onFailure(call: Call<CountryResponse>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}