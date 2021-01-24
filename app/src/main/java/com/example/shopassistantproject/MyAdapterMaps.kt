package com.example.shopassistantproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopassistantproject.databinding.ListElementBinding
import com.example.shopassistantproject.databinding.ListElementMapsBinding

class MyAdapterMaps(var viewModelMaps: MapsViewModel) : RecyclerView.Adapter<MyAdapterMaps.MyViewHolderMaps>() {

    private var mapsList = emptyList<Maps>()


    class MyViewHolderMaps(val binding: ListElementMapsBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderMaps {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListElementMapsBinding.inflate(inflater, parent, false)
        return MyAdapterMaps.MyViewHolderMaps(binding)
    }


    override fun onBindViewHolder(holder: MyViewHolderMaps, position: Int) {
        holder.binding.idTxMap.text = mapsList[position].id.toString()
        holder.binding.nameMap.text = mapsList[position].name
        holder.binding.descriptionMap.text = mapsList[position].description
        holder.binding.radiusMap.text = mapsList[position].radius
        holder.binding.locationMap.text = mapsList[position].latitude.toString()
        holder.binding.location2Map.text = mapsList[position].longitude.toString()
        holder.binding.root.setOnClickListener {
            viewModelMaps.remove(mapsList[position])
            notifyDataSetChanged()
        }
    }


    override fun getItemCount(): Int = mapsList.size

    fun setMapsList(list: List<Maps>){
        mapsList = list

        //Important to make if we change sth on Adapter to refresh recycle
        notifyDataSetChanged()
    }
}