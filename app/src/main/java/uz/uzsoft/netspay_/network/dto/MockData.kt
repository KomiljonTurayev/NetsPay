package uz.uzsoft.netspay_.network.dto

import uz.uzsoft.netspay_.R

class MockData {

    companion object {

        fun getDayDataList(): List<DayData> {
            val list = ArrayList<DayData>()

            for (dayData in 1..10) {
                if (dayData % 2 == 0)
                    list.add(DayData(R.drawable.user_, "Hailey Nolan", "26 transactions", "3,520"))
                else
                    list.add(DayData(R.drawable.user_1, "Steve Donald", "24 transactions", "3,320"))
            }

            return list
        }
    }


    data class DayData(
        val image: Int,
        val name: String,
        val transactions: String,
        val count: String
    )


}