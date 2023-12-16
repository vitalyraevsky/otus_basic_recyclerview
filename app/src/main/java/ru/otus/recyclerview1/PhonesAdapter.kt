package ru.otus.recyclerview1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.util.Collections

private const val VIEW_ITEM_PHONE = 1
private const val VIEW_ITEM_TABLET = 2

class PhonesAdapter(
    //private val listener: PhoneListener
//) : RecyclerView.Adapter<BaseViewHolder>() {
) : ListAdapter<BaseItam, BaseViewHolder>(DiffUtilItemCallBack()) {

    var onItemClicked: (Int) -> Unit = {}
    var onItemActionClicked: (Int) -> Unit = {}

    //private var items = mutableListOf<BaseItam>()

/*    fun updateData(newItems: List<BaseItam>) {
        val diffUtilCallBack = DiffUtilCallBack(items,newItems)
        val diffResolt = DiffUtil.calculateDiff(diffUtilCallBack)
        items.clear()
        items.addAll(newItems)
        diffResolt.dispatchUpdatesTo(this)
    }*/

/*
    override fun getItemCount(): Int {
        return items.size
    }
*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutRes = when (viewType) {
            VIEW_ITEM_TABLET -> R.layout.item_2_layout
            else -> R.layout.item_layout
        }
        val view = LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)
        return when (viewType) {
            VIEW_ITEM_TABLET -> TabletViewHolder(view, onItemClicked)
            else -> PhoneViewHolder(view, onItemClicked, onItemActionClicked)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position) is TabletItem) VIEW_ITEM_TABLET else VIEW_ITEM_PHONE
    }

/*
    fun setItems(list: List<BaseItam>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }
*/

    // удаление по позииции
        fun removeItem(position: Int) {
        // Без DiffUtils
/*
            val newItems = items.toMutableList()
            newItems.removeAt(position)
            items = newItems
            notifyItemRemoved(position)
*/
            val newList = currentList.toMutableList().apply {
                removeAt(position)
            }
            submitList(newList)
        }

    // удаление по id
/*
    fun removeItem(id: Int) {
        val position = items.indexOfFirst { it.getItemId() == id }
        val newItems = items.toMutableList()
        newItems.removeAt(position)
        items = newItems
        notifyItemRemoved(position)
    }
*/

    fun exchange(fromPosition: Int, toPosition: Int) {
        // Без DiffUtils
/*
        if (fromPosition < toPosition) {
            for (index in fromPosition until toPosition) {
                Collections.swap(items, index, index + 1)
            }
        } else {
            for (index in fromPosition downTo toPosition + 1) {
                Collections.swap(items, index, index - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
*/
        val newList = currentList.toMutableList()
        Collections.swap(newList,fromPosition, toPosition)
        submitList(newList)
    }

}