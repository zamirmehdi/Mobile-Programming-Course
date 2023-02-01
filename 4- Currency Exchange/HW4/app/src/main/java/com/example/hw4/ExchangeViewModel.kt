package com.example.hw4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ExchangeViewModel {
    private var _irrVal = MutableLiveData<Float>()
    val irrVal: LiveData<Float>
        get() = _irrVal

    private var _usdVal = MutableLiveData<Float>()
    val usdVal: LiveData<Float>
        get() = _usdVal

    private var _cadVal = MutableLiveData<Float>()
    val cadVal: LiveData<Float>
        get() = _cadVal

    private var _gbpVal = MutableLiveData<Float>()
    val gbpVal: LiveData<Float>
        get() = _gbpVal

    private var _eurVal = MutableLiveData<Float>()
    val eurVal: LiveData<Float>
        get() = _eurVal

    private var _aedVal = MutableLiveData<Float>()
    val aedVal: LiveData<Float>
        get() = _aedVal

    fun updateValue(newVal: Float, currency: String) {
        when (currency) {
            "irr" -> if (_irrVal.value != newVal) _irrVal.value = newVal
            "usd" -> if (_usdVal.value != newVal) _usdVal.value = newVal
            "cad" -> if (_cadVal.value != newVal) _cadVal.value = newVal
            "gbp" -> if (_gbpVal.value != newVal) _gbpVal.value = newVal
            "eur" -> if (_eurVal.value != newVal) _eurVal.value = newVal
            "aed" -> if (_aedVal.value != newVal) _aedVal.value = newVal
        }
    }
}