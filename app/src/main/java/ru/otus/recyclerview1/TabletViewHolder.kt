package ru.otus.recyclerview1

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TabletViewHolder(
    view: View,
    //private val listener: PhoneListener
    private val onItemClicked: (Int) -> Unit,
) : BaseViewHolder(view) {

    private val model: TextView by lazy { itemView.findViewById(R.id.model) }
    private val age: TextView by lazy { itemView.findViewById(R.id.age) }

    override fun bind(itemModel: BaseItam) {
        itemModel as TabletItem
        model.text = itemModel.model
        age.text = itemModel.age.toString()
        itemView.setOnClickListener {
            onItemClicked.invoke(itemModel.id)
            //listener.onItemClicked(model.id)
        }
    }
}