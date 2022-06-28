package com.example.country

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.country.databinding.FragmentDetailBinding
import com.example.country.model.country.Country
import com.example.country.model.detail.CountryDetail
import com.example.country.repository.MainRepository

class DetailFragment : Fragment() {


    private lateinit var binding: FragmentDetailBinding
    lateinit var viewModel: DetailViewModel
    private val retrofitService = RetrofitService.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        viewModel =
            ViewModelProvider(this, DetailViewModelFactory(MainRepository(retrofitService))).get(
                DetailViewModel::class.java
            )



        val country = arguments?.getSerializable("country") as Country?
        val code = country?.code
        if (code != null) {
            viewModel.getCountryDetail(code)

        }

        binding.countrydetails.text = CountryDetail().name
        Glide.with(binding.image.context).load(CountryDetail().flagImageUri).into(binding.image)

        return binding.root
    }


}