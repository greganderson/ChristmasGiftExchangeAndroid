package com.anderson.greg.christmasgiftexchange

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    val brethren: ArrayList<String> = arrayListOf("Christian", "Peter", "Greg", "Stephen")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numberPicker.minValue = 2018
        numberPicker.maxValue = 2030
        exchangeList.text = whoGiftsToWho(numberPicker.value)

        numberPicker.setOnValueChangedListener({n, a, b -> exchangeList.text = whoGiftsToWho(b)})
    }

    fun whoGiftsToWho(year: Int): String {
        val family = ArrayList(brethren)
        val target: ArrayList<String> = ArrayList()
        val familySize = family.size

        for (i in 0 until familySize)
            target.add(family[(i + 1) % familySize])

        for (i in 0 until (year % (familySize - 1)))
            target.add(target.removeAt(0))

        var result = ""
        for (i in 0 until familySize)
            result += family.removeAt(0) + " -> " + target.removeAt(0) + "\n"
        return result
    }
}
