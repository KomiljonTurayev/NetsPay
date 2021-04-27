package uz.uzsoft.netspay_.ui.home.transfer.week

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_day.view.*
import uz.uzsoft.netspay_.R
import uz.uzsoft.netspay_.network.dto.MockData

class WeekAdapter : RecyclerView.Adapter<WeekAdapter.ItemView>() {
    val list = MockData.getDayDataList()

    var onItemClick: ((MockData.DayData) -> Unit)? = null

    inner class ItemView(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.textViewName
        val textViewTransactions = view.textViewTransactions
        val textViewCount = view.textViewCount

        val imageViewUser = view.imageViewUser
        val containerLayout = view.containerLayout

        fun bind(d: MockData.DayData) {
            itemView.apply {
                name.text = d.name
                textViewTransactions.text = d.transactions
                textViewCount.text = d.count
                imageViewUser.setImageResource(d.image)
            }
        }

        init {
            containerLayout.setOnClickListener {
                Toast.makeText(itemView.context, "item - $it", Toast.LENGTH_SHORT).show()
            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemView {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_day, parent, false)
        return ItemView(view)
    }

    override fun getItemCount(): Int {
        return list.size
//        Toast.makeText(, "", Toast.LENGTH_SHORT).show()
    }

    override fun onBindViewHolder(holder: ItemView, position: Int) {
        return holder.bind(list[position])
    }

}
