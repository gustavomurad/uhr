package com.example.gustavomurad.uhr

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mHour: String = "00"
    private var mMinute: String = "00"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnHourUp.setOnClickListener {
            var hour = textHour.text.toString().toInt()
            if(hour == 23){
                hour = 0
            }else{
                hour++
            }
            mHour = addZerosToLeft(hour)
            textHour.text = mHour
        }

        btnHourDown.setOnClickListener {
            var hour = textHour.text.toString().toInt()
            if(hour == 0){
                hour = 23
            }else{
                hour--
            }
            mHour = addZerosToLeft(hour)
            textHour.text = mHour
        }

        btnMinuteUp.setOnClickListener {
            var minute = textMinute.text.toString().toInt()
            if(minute == 59){
                minute = 0
            }else{
                minute++
            }
            mMinute = addZerosToLeft(minute)
            textMinute.text = mMinute
        }

        btnMinuteDown.setOnClickListener{
            var hour = textMinute.text.toString().toInt()
            if(hour == 0){
                hour = 59
            }else{
                hour--
            }
            mMinute = addZerosToLeft(hour)
            textMinute.text = mMinute
        }

        btnSayTime.setOnClickListener {
            displayTime.text = getTime()
        }
    }

    private fun addZerosToLeft(number: Int):String{
        return "%02d".format(number)
    }

    private fun getTime():String{
        return "${Hour().hourInFullFormal(mHour.toInt(), mMinute.toInt())} \n\n ${Hour().hourInFullInformal(mHour.toInt(), mMinute.toInt())}"
    }




}
