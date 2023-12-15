package ru.otus.recyclerview1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

private const val SPAN_COUNT = 2
private const val LINEAR_ORIENTATION = LinearLayoutManager.VERTICAL
private const val STAGGERED_ORIENTATION = StaggeredGridLayoutManager.VERTICAL

class MainActivity : AppCompatActivity() //, PhoneListener
{

    private val listView: RecyclerView by lazy { findViewById(R.id.list) }

    private val adapter: PhonesAdapter by lazy {
        //PhonesAdapter(this)
        PhonesAdapter()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Добавляем layoutManager через код
        //listView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        //listView.layoutManager = GridLayoutManager(this, SPAN_COUNT)
        //listView.layoutManager = StaggeredGridLayoutManager(SPAN_COUNT, ORIENTATION)

        listView.recycledViewPool.setMaxRecycledViews(1, 15)
        listView.adapter = adapter
        adapter.onItemClicked = {
            Toast.makeText(this, "ID : $it", Toast.LENGTH_LONG).show()
        }
        adapter.onItemActionClicked = {
            adapter.removeItem(it)
        }
        adapter.setItems(fillList())
    }

    private fun fillList() : List<PhoneItem> {
        val mutableList = mutableListOf<PhoneItem>()
            for (i in 1..50) {
                val model = PhoneItem(
                    id = i,
                    model = "Apple Iphone $i",
                    age = 2000 + i,
                    background = if (i % 2 == 0) {
                        R.color.more
                    } else {
                        com.google.android.material.R.color.mtrl_btn_transparent_bg_color
                    }
                )
                mutableList.add(model)
            }
        return mutableList.toList()
    }

/*
    override fun onItemClicked(id: Int) {
        Toast.makeText(this, "ID : $id", Toast.LENGTH_LONG).show()
    }

    override fun onItemActionClicked(position: Int) {
        adapter.removeItem(position)
    }
*/
}