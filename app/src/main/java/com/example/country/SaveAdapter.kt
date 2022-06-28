package com.example.country

/*
class SaveAdapter(
    private val listener: ClickListener,
  //  private val savemanager: SaveManager
) : RecyclerView.Adapter<SaveAdapter.ItemViewHolder>()
{
 //   private var countriesSaved = savemanager.getCountries() ?: arrayListOf()

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val binding = ItemCountryBinding.bind(itemView)

        fun bind(country: Country){
            binding.name.text = country.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_country,parent,false
            )
        )

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
  //      holder.bind(countriesSaved[position])
        holder.binding.card.setOnClickListener {
            listener.onClick(countriesSaved[position])
        }
  /*      holder.binding.imageViewSavedState.setImageResource(R.drawable.ic_fav_state)
        holder.binding.imageViewFavouriteState.setOnClickListener{
            savemanager.removeCountry(countriesSaved[position])
        }*/
    }
        override fun getItemCount(): Int = countriesSaved.size

    fun setData(countries: ArrayList<Country>){
        this.countriesSaved = countries
        notifyDataSetChanged()
    }


}*/