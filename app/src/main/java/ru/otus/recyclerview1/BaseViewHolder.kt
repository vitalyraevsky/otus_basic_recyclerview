package ru.otus.recyclerview1

import android.view.View
import androidx.recyclerview.widget.RecyclerView

sealed class BaseViewHolder(
    view: View,
) : RecyclerView.ViewHolder(view) {

    abstract fun bind(model: BaseItam)
}