package com.example.country

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.country.databinding.FragmentHomeBinding
import com.example.country.model.country.Country
import com.example.country.repository.MainRepository

class HomeFragment : Fragment(), ClickListener {
    private lateinit var binding: FragmentHomeBinding

       lateinit var viewModel: MainViewModel
       private val retrofitService = RetrofitService.getInstance()
  lateinit var adapter : MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        viewModel =
            ViewModelProvider(this, MainViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )
        binding.recyclerview.layoutManager = LinearLayoutManager(activity)
        adapter = MainAdapter(this)
        binding.recyclerview.adapter = adapter

        viewModel.countryList.observe(viewLifecycleOwner , Observer {

            adapter.setCountryList(it)
            adapter.notifyDataSetChanged()
        })

        viewModel.getAllCountries()

        return binding.root
    }

    override fun onClick(country: Country) {
       val bundle = Bundle()
        bundle.putSerializable("country", country)
        view?.let{
           Navigation.findNavController(it).
            navigate(R.id.detailFragment, bundle)
        }
    }}








