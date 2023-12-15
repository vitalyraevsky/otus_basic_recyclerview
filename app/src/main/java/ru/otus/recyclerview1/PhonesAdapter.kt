package ru.otus.recyclerview1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PhonesAdapter(
    //private val listener: PhoneListener
) : RecyclerView.Adapter<PhoneViewHolder>() {

    var onItemClicked : (Int) -> Unit = {}
    var onItemActionClicked : (Int) -> Unit = {}

    private var items = emptyList<PhoneItem>()

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        //return PhoneViewHolder(view, listener)
        return PhoneViewHolder(view, onItemClicked, onItemActionClicked)
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setItems(list: List<PhoneItem>) {
        items = list
        notifyDataSetChanged()
    }

    // удаление по позииции
/*
    fun removeItem(position: Int) {
        val newItems = items.toMutableList()
        newItems.removeAt(position)
        items = newItems
        notifyItemRemoved(position)
    }
*/

    // удаление по id
    fun removeItem(id: Int) {
        val position = items.indexOfFirst { it.id == id }
        val newItems = items.toMutableList()
        newItems.removeAt(position)
        items = newItems
        notifyItemRemoved(position)
    }

}