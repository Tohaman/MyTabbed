package com.example.mytabbed.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel: ViewModel() {
    private var _dataList: MutableLiveData<List<Int>> = MutableLiveData()
    val dataList: LiveData<List<Int>> get() = _dataList



    fun randomFill() {
        val list : MutableList<Int> = mutableListOf()
        for (i in 0..(3..7).random()) {
            list.add((10..20).random())
        }
        _dataList.postValue(list)
    }


    companion object {
        class MainViewModelFactory () : ViewModelProvider.NewInstanceFactory() {

            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel() as T
            }
        }
    }
}