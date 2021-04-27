package uz.uzsoft.netspay_.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.view.*
import uz.uzsoft.netspay_.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var viewPager: ViewPager2
    private lateinit var adapterTabHomeTabLayout: AdapterHomeTabLayout


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapterTabHomeTabLayout = AdapterHomeTabLayout(this)
        viewPager = view.viewPagerAllProducts
        viewPager.adapter = adapterTabHomeTabLayout


        val tabLayout = view.tabLayoutAllProducts
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0->{
                    tab.text="Day"

                }
                1->{
                    tab.text="Week"
                }
                2->{
                    tab.text="Month"
                }
                3->{
                    tab.text="Year"

                }

            }
        }.attach()

        val toast = Toast.makeText(
            requireContext(),
            "Press again to exit..",
            Toast.LENGTH_SHORT
        )

        toast.show()
    }
}