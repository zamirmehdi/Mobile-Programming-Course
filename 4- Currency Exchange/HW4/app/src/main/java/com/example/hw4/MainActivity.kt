package com.example.hw4

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private var exchangeViewModel: ExchangeViewModel = ExchangeViewModel()

    private fun usdToOthers(
        newUsd: Float,
        currency: String,
        exchangeViewModel: ExchangeViewModel
    ) {
        val newIrr = newUsd * 351970f
        if (currency != "irr") exchangeViewModel.updateValue(newIrr, "irr")

        if (currency != "usd") exchangeViewModel.updateValue(newUsd, "usd")

        val newCad = (newUsd * 1.3468f)
        if (currency != "cad") exchangeViewModel.updateValue(newCad, "cad")

        val newGbp = (newUsd * 0.8133f)
        if (currency != "gbp") exchangeViewModel.updateValue(newGbp, "gbp")

        val newEur = (newUsd * 0.9490f)
        if (currency != "eur") exchangeViewModel.updateValue(newEur, "eur")

        val newAed = (newUsd * 3.673f)
        if (currency != "aed") exchangeViewModel.updateValue(newAed, "aed")
    }

    private fun calculateNewValues(
        newVal: Float,
        currency: String,
        exchangeViewModel: ExchangeViewModel
    ) {
        when (currency) {
            "irr" -> {
                val newUsd = newVal / 351970f
                usdToOthers(newUsd, currency, exchangeViewModel)
            }
            "usd" -> {
                usdToOthers(newVal, currency, exchangeViewModel)
            }
            "cad" -> {
                val newUsd = newVal / 1.3468f
                usdToOthers(newUsd, currency, exchangeViewModel)
            }
            "gbp" -> {
                val newUsd = newVal / 0.8133f
                usdToOthers(newUsd, currency, exchangeViewModel)
            }
            "eur" -> {
                val newUsd = newVal / 0.9490f
                usdToOthers(newUsd, currency, exchangeViewModel)
            }
            "aed" -> {
                val newUsd = newVal / 3.673f
                usdToOthers(newUsd, currency, exchangeViewModel)
            }
        }

    }

    private fun updateScreenValues(
        exchangeViewModel: ExchangeViewModel,
        irrEns: EditText,
        usdEns: EditText,
        cadEns: EditText,
        gbpEns: EditText,
        eurEns: EditText,
        aedEns: EditText,
    ) {
        val pattern = DecimalFormat("###,###.####")

        exchangeViewModel.irrVal.observe(this, Observer {
            Log.d("log1: ", exchangeViewModel.irrVal.value.toString())
            if (!irrEns.hasFocus()) irrEns.setText((pattern.format(it)).toString())
        })
        exchangeViewModel.usdVal.observe(this, Observer {
            Log.d("log2: ", exchangeViewModel.usdVal.value.toString())
            if (!usdEns.hasFocus()) usdEns.setText((pattern.format(it)).toString())
        })
        exchangeViewModel.cadVal.observe(this, Observer {
            Log.d("log3: ", exchangeViewModel.cadVal.value.toString())
            if (!cadEns.hasFocus()) cadEns.setText((pattern.format(it)).toString())
        })
        exchangeViewModel.gbpVal.observe(this, Observer {
            Log.d("log4: ", exchangeViewModel.gbpVal.value.toString())
            if (!gbpEns.hasFocus()) gbpEns.setText((pattern.format(it)).toString())
        })
        exchangeViewModel.eurVal.observe(this, Observer {
            Log.d("log5: ", exchangeViewModel.eurVal.value.toString())
            if (!eurEns.hasFocus()) eurEns.setText((pattern.format(it)).toString())
        })
        exchangeViewModel.aedVal.observe(this, Observer {
            Log.d("log6: ", exchangeViewModel.aedVal.value.toString())
            if (!aedEns.hasFocus()) aedEns.setText((pattern.format(it)).toString())
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val irrEns: EditText = findViewById(R.id.IRRENS)
        val usdEns: EditText = findViewById(R.id.USDENS)
        val cadEns: EditText = findViewById(R.id.CADENS)
        val gbpEns: EditText = findViewById(R.id.GBPENS)
        val eurEns: EditText = findViewById(R.id.EURENS)
        val aedEns: EditText = findViewById(R.id.AEDENS)


        irrEns.addTextChangedListener {
            if (irrEns.hasFocus()) {
                if (it.toString() == "") irrEns.setSelection(0, irrEns.length())
                else {
                    val newVal = it.toString().toFloat()
                    exchangeViewModel.updateValue(newVal, "irr")
                    calculateNewValues(newVal, "irr", exchangeViewModel)
                }
            }
        }

        usdEns.addTextChangedListener {
            if (usdEns.hasFocus()) {
                if (it.toString() == "") usdEns.setSelection(0, usdEns.length())
                else {
                    val newVal = it.toString().toFloat()
                    exchangeViewModel.updateValue(newVal, "usd")
                    calculateNewValues(newVal, "usd", exchangeViewModel)
                }
            }
        }
        cadEns.addTextChangedListener {
            if (cadEns.hasFocus()) {
                if (it.toString() == "") cadEns.setSelection(0, cadEns.length())
                else {
                    val newVal = it.toString().toFloat()
                    exchangeViewModel.updateValue(newVal, "cad")
                    calculateNewValues(newVal, "cad", exchangeViewModel)
                }
            }
        }
        gbpEns.addTextChangedListener {
            if (gbpEns.hasFocus()) {
                if (it.toString() == "") gbpEns.setSelection(0, gbpEns.length())
                else {
                    val newVal = it.toString().toFloat()
                    exchangeViewModel.updateValue(newVal, "gbp")
                    calculateNewValues(newVal, "gbp", exchangeViewModel)
                    println("   Gbp")
                }
            }
        }
        eurEns.addTextChangedListener {
            if (eurEns.hasFocus()) {
                if (it.toString() == "") eurEns.setSelection(0, eurEns.length())
                else {
                    val newVal = it.toString().toFloat()
                    exchangeViewModel.updateValue(newVal, "eur")
                    calculateNewValues(newVal, "eur", exchangeViewModel)
                }
            }
        }
        aedEns.addTextChangedListener {
            if (aedEns.hasFocus()) {
                if (it.toString() == "") aedEns.setSelection(0, aedEns.length())
                else {
                    val newVal = it.toString().toFloat()
                    exchangeViewModel.updateValue(newVal, "aed")
                    calculateNewValues(newVal, "aed", exchangeViewModel)
                }
            }
        }

        updateScreenValues(exchangeViewModel, irrEns, usdEns, cadEns, gbpEns, eurEns, aedEns)
    }
}