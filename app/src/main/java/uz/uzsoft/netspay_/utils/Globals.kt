package uz.uzsoft.kidya.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager



fun View.hideKeyboard() {
    val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(windowToken, 0)
}


var months = arrayOf(
    "января", "февраля", "марта", "апреля", "мая", "июня",
    "июля", "августа", "сентября", "октября", "ноября", "декабря"
)

var region = arrayOf(
    "Аккурганский район",
    "Ахангаранский район",
    "Бекабадский район",
    "Бостанлыкский район",
    "Букинский район",
    "Зангиатинский район",
    "Кибрайский район",
    "Куйичирчикский район",
    "Паркентский район",
    "Пскентский район",
    "Ташкентский район",
    "Уртачирчикский район",
    "Чиланзарский район",
    "Юкоричирчикский райо",
    "Янгиюльский район"
)

var city = arrayOf(
    "Ташкент",
    "Ташкентская область"
)
