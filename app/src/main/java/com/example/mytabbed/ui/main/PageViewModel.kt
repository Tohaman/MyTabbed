package com.example.mytabbed.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlin.random.Random
import kotlin.random.nextInt

class PageViewModel : ViewModel() {

    private var _dataList: MutableLiveData<List<Int>> = MutableLiveData()
    val dataList: LiveData<List<Int>> get() = _dataList

    private val _index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_index) {
        "Random number is: $it"
    }

    fun setIndex(index: Int) {
        _index.value = index
    }



}