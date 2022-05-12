package com.arka.livedatabasic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel(){
    private var clickCount :Int =0
    private var countLiveData = MutableLiveData<Int>()

    open fun getInitialCount() : MutableLiveData<Int>{
        countLiveData.value=clickCount
        return countLiveData
    }

    open fun getCurrentCount(){
        clickCount+=1
        countLiveData.value=clickCount
    }
}