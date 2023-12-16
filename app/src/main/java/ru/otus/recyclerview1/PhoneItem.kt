package ru.otus.recyclerview1

sealed interface BaseItam {
    fun getItemId() : Int
}

data class PhoneItem(
    val id: Int,
    val model: String,
    val age: Int,
    val background: Int,
) : BaseItam {

    override fun getItemId() = id
}

data class TabletItem(
    val id: Int,
    val model: String,
    val age: Int,
) : BaseItam {

    override fun getItemId() = id
}


