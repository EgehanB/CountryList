package com.example.country
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.country.repository.MainRepository

class DetailViewModelFactory constructor(
    private val repository: MainRepository,

) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            DetailViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}