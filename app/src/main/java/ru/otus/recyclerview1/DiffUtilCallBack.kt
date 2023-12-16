package ru.otus.recyclerview1

import androidx.recyclerview.widget.DiffUtil

class DiffUtilCallBack(
    private val oldList: List<BaseItam>,
    private val newList: List<BaseItam>
) : DiffUtil.Callback(){

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].getItemId() == newList[newItemPosition].getItemId()
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}