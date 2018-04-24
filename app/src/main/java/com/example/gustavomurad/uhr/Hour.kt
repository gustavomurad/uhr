package com.example.gustavomurad.uhr

class Hour{

    private fun getNumberInFull(time: Int): String{
        return if(time.toString().length == 1){
            getNumberLabel(time)
        }else if(time <= 20) {
            getNumberLabel(time)
        }else{
            val unity = time % 10
            val dozen = time - unity
            "${getNumberLabel(unity)}und${getNumberLabel(dozen)}"
        }
    }

    fun hourInFullFormal(hour: Int, minute: Int): String{
        val fullHour = getNumberInFull(hour)
        val fullMinute = getNumberInFull(minute)

        return "Es ist $fullHour Uhr ${fullMinute.removePrefix("null")}"
    }

    fun hourInFullInformal(hour: Int, minute: Int): String{
        val fullHour = getNumberInFull(hour)
        val fullMinute = getNumberInFull(minute)

        return if(minute <= 10 && minute != 0 ) {
            "Es ist $fullMinute nach ${fullHour.removePrefix("null")}"
        }else if(minute >= 50) {
            "Es ist ${getNumberInFull((60 - minute))} vor ${if((hour + 1) == 24 ) "Mittnacht" else getNumberInFull((hour + 1))}"
        }else if(minute == 15) {
            "Es ist Viertel nachs $fullMinute"
        }else if(minute == 45) {
            "Es ist Viertel vor $fullMinute"
        }else if(minute == 30){
            "Es ist halb ${if((hour + 1) == 24 ) "Mittnacht" else getNumberInFull((hour + 1))}"
        }else if(hour == 0 && minute == 0){
            "Es ist Mittnacht"
        }else{
            ""
        }
    }

    private fun getNumberLabel(number: Int):String{
        return when(number){
            0  -> "null"
            1  -> "eins"
            2  -> "zwei"
            3  -> "drei"
            4  -> "vier"
            5  -> "fünf"
            6  -> "sechs"
            7  -> "sieben"
            8  -> "acht"
            9  -> "neun"
            10 -> "zehn"
            11 -> "elf"
            12 -> "zwölf"
            13 -> "dreizehn"
            14 -> "vierzehn"
            15 -> "fünfzehn"
            16 -> "sechzehn"
            17 -> "siebzehn"
            18 -> "achtzehn"
            19 -> "neunzehn"
            20 -> "zwanzig"
            30 -> "dreißig"
            40 -> "vierzig"
            50 -> "fünfzig"
            else -> ""
        }
    }
}