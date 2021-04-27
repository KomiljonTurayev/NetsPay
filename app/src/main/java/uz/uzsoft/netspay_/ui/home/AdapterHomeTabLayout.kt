package uz.uzsoft.netspay_.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.uzsoft.netspay_.ui.home.transfer.day.DayFragment
import uz.uzsoft.netspay_.ui.home.transfer.month.MonthFragment
import uz.uzsoft.netspay_.ui.home.transfer.week.WeekFragment
import uz.uzsoft.netspay_.ui.home.transfer.year.YearFragment


class AdapterHomeTabLayout(fa: Fragment) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                DayFragment()
            }
            1 -> {
                WeekFragment()
            }
            2 -> {
                MonthFragment()
            }
            3 -> {
                YearFragment()
            }
            else -> DayFragment()
        }
    }
}