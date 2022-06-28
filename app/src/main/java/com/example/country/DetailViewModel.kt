package com.example.country

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.country.model.detail.CountryDetail
import com.example.country.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel constructor(
    private val repository: MainRepository
    ) : ViewModel() {

    val detail = MutableLiveData<CountryDetail>()
    val errorMessage = MutableLiveData<String>()

    fun getCountryDetail(countryCode: String) {
        val response = repository.getCountryDetail(countryCode)
        response.enqueue(object : Callback<CountryDetailResponse> {
            override fun onResponse(
                call: Call<CountryDetailResponse>,
                response: Response<CountryDetailResponse>
            ) {
                detail.postValue(response.body()!!.data)
            }
            override fun onFailure(call: Call<CountryDetailResponse>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}