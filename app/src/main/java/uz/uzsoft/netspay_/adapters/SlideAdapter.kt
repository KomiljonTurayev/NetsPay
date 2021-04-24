package uz.uzsoft.netspay_.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import uz.uzsoft.netspay_.R

class SlideAdapter(var context: Context) : PagerAdapter() {
    var inflater: LayoutInflater? = null

    //Array
    var list_images = intArrayOf(
        R.drawable.ic_undraw_transfer_money_rywa,
        R.drawable.ic_undraw_vault_9cmw,
        R.drawable.ic_undraw_investing_7u74
    )

    var list_title =
        arrayOf(R.string.helps.toString(), R.string.helps.toString(), R.string.helps.toString())

    override fun getCount(): Int {
        return list_title.size
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view === obj as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater!!.inflate(R.layout.slide, container, false)
//        val linearLayout = view.findViewById<View>(R.id.slidelinearlayout) as LinearLayout
        val img = view.findViewById<View>(R.id.slideimg) as ImageView
        img.setImageResource(list_images[position])

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}