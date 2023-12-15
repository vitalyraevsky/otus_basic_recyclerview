package ru.otus.recyclerview1

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PhoneViewHolder(
    view: View,
    //private val listener: PhoneListener
    private val onItemClicked: (Int) -> Unit,
    private val onItemActionClicked: (Int) -> Unit
) : RecyclerView.ViewHolder(view) {

    private val model: TextView by lazy { itemView.findViewById(R.id.model) }
    private val age: TextView by lazy { itemView.findViewById(R.id.age) }
    private val icon: ImageView by lazy { itemView.findViewById(R.id.icon) }
    private val action: ImageView by lazy { itemView.findViewById(R.id.action) }

    fun bind(itemModel: PhoneItem) {
        model.text = itemModel.model
        age.text = itemModel.age.toString()
        icon.setImageResource(R.drawable.icon_phone_android_24)
        itemView.setBackgroundResource(itemModel.background)
        itemView.setOnClickListener {
            onItemClicked.invoke(itemModel.id)
            //listener.onItemClicked(model.id)
        }
        action.setOnClickListener {
            //listener.onItemActionClicked(adapterPosition)
            // Удаление по позиции
            //onItemActionClicked.invoke(adapterPosition)
            // Удаление по id
            onItemActionClicked.invoke(itemModel.id)
        }
    }
}