package com.example.country

import android.content.SharedPreferences
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.country.databinding.ItemCountryBinding
import com.example.country.model.country.Country

class MainAdapter(
    private val listener: ClickListener,

) : RecyclerView.Adapter<MainAdapter.CountryViewHolder>() {


    var countries = mutableListOf<Country>()

    fun setCountryList(CountryResponse: List<Country>) {
        countries = CountryResponse.toMutableList()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCountryBinding.inflate(inflater, parent, false)
        return CountryViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]
        holder.binding.name.text = country.name
        holder.binding.imageViewFavouriteState.setOnClickListener {
            listener.onClick(countries[position])



        }

             holder.itemView.setOnClickListener {
                 listener?.onClick(country)
                 Log.d("tag", "country")
             }
    }

    override fun getItemCount() = countries.size


    class CountryViewHolder(
        val binding: ItemCountryBinding
    ) : RecyclerView.ViewHolder(binding.root)
}




