package uz.uzsoft.netspay_.ui.obboardings

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.slide.*
import uz.uzsoft.netspay_.R
import uz.uzsoft.netspay_.adapters.SlideAdapter

class OnboardingFragment : Fragment() {

    private var viewpager: ViewPager? = null
    private var liner: LinearLayout? = null
    private var myadapter: SlideAdapter? = null
    private lateinit var mdots: Array<TextView?>
    private var next: TextView? = null
    private var back: TextView? = null
    private var finish: TextView? = null
    private var mCureentPage = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewpager = view.findViewById<View>(R.id.viewpager) as ViewPager
        liner = view.findViewById<View>(R.id.dots) as LinearLayout
        next = view.findViewById<View>(R.id.nextBtn) as TextView?
        back = view.findViewById<View>(R.id.backBtn) as TextView?
        finish = view.findViewById<View>(R.id.finishBtn) as TextView?
        myadapter = SlideAdapter(requireContext())
        viewpager!!.adapter = myadapter
        adddots(0)
        viewpager!!.addOnPageChangeListener(viewlistener)
        next!!.setOnClickListener {
            viewpager!!.currentItem = mCureentPage + 1
            if (keyWord == "FINISH")
                findNavController().navigate(R.id.nav_welcome)
        }

        back!!.setOnClickListener { viewpager!!.currentItem = mCureentPage - 1 }
        finish!!.setOnClickListener {
            findNavController().navigate(R.id.nav_home)
            Log.d("komiljon", "Finish")
        }
    }

    fun adddots(i: Int) {
        mdots = arrayOfNulls(3)
        liner!!.removeAllViews()
        for (x in mdots.indices) {
            mdots[x] = TextView(requireContext())
            mdots[x]!!.text = Html.fromHtml("&#8226;")
            mdots[x]!!.textSize = 35f
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                mdots[x]!!.setTextColor(requireContext().getColor(R.color.blue_black))
            } else {
                mdots[x]!!.setTextColor(getResources().getColor(R.color.blue_black))
            }
            liner!!.addView(mdots[x])
        }
        if (mdots.size > 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                mdots[i]!!.setTextColor(requireContext().getColor(R.color.white))
            } else {
                mdots[i]!!.setTextColor(getResources().getColor(R.color.white))
            }
//
        }
    }

    var viewlistener: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            adddots(position)
            mCureentPage = position
            if (position == 0) {
                next!!.isEnabled = true
                back!!.isEnabled = false
                next!!.text = "Next"
                back!!.text = "Skip"

                next!!.visibility = View.VISIBLE
                finish!!.visibility = View.GONE

                imageViewRight.visibility = View.VISIBLE
                imageViewLeft.visibility = View.GONE
                imageViewTop.visibility = View.GONE


            } else if (position == mdots.size - 1) {
                next!!.isEnabled = true
                back!!.isEnabled = true
                back!!.visibility = View.VISIBLE
                next!!.visibility = View.GONE
                finish!!.visibility = View.VISIBLE
                back!!.text = "Skip"

                imageViewRight.visibility = View.GONE
                imageViewLeft.visibility = View.GONE
                imageViewTop.visibility = View.VISIBLE

                Log.d("komiljon", "Finish")

            } else {
                next!!.isEnabled = true
                back!!.isEnabled = true
                back!!.visibility = View.VISIBLE
                next!!.text = "Next"
                back!!.text = "Skip"
                next!!.visibility = View.VISIBLE
                finish!!.visibility = View.GONE
                imageViewRight.visibility = View.GONE
                imageViewLeft.visibility = View.VISIBLE
                imageViewTop.visibility = View.GONE


            }
        }

        override fun onPageScrollStateChanged(state: Int) {}
    }

    companion object {
        var keyWord = ""
    }
}