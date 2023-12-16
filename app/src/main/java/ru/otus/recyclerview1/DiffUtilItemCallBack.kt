package ru.otus.recyclerview1

import androidx.recyclerview.widget.DiffUtil

class DiffUtilItemCallBack : DiffUtil.ItemCallback<BaseItam>() {

    override fun areItemsTheSame(oldItem: BaseItam, newItem: BaseItam): Boolean {
        return oldItem.getItemId() == newItem.getItemId()
    }

    override fun areContentsTheSame(oldItem: BaseItam, newItem: BaseItam): Boolean {
        return oldItem == newItem
    }
}