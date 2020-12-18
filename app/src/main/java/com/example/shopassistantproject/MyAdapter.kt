package com.example.shopassistantproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopassistantproject.databinding.ListElementBinding

class MyAdapter(val viewModel: ShoppingViewModel) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    public var POZYCJA: String = ""

    private var shoppingList = emptyList<Shopping>()

    class MyViewHolder(val binding: ListElementBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ListElementBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        //Check it why toString if its text..

        holder.binding.id.text = shoppingList[position].id.toString()
        holder.binding.txProduct.text = shoppingList[position].product
        holder.binding.txQuantity.text = shoppingList[position].quantity
        holder.binding.txPrice.text = shoppingList[position].price.toString()+" $"
        holder.binding.tvCb.isChecked = shoppingList[position].bought
        holder.binding.root.setOnClickListener {
            viewModel.remove(shoppingList[position])
            notifyDataSetChanged()
        }
        holder.binding.tvCb.setOnClickListener {
            // Change it what is in the base, actually, click, unclicked
            shoppingList[position].bought = holder.binding.tvCb.isChecked
            viewModel.modify(shoppingList[position])
            notifyDataSetChanged()
        }

        holder.binding.btm.setOnClickListener {
            POZYCJA = holder.binding.id.text.toString()
            holder.binding.btm.setBackgroundColor(255)
        }

    }

    override fun getItemCount(): Int = shoppingList.size

    fun setShoppingList(list: List<Shopping>){
        shoppingList = list

        //Important to make if we change sth on Adapter to refresh recycle
        notifyDataSetChanged()

    }


}