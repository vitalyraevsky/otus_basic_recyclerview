package ru.otus.recyclerview1

interface PhoneListener {

    fun onItemClicked(id: Int)

    fun onItemActionClicked(position: Int)
}