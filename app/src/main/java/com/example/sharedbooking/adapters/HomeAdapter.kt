package com.example.sharedbooking.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sharedbooking.Items.HomeItem
import com.example.sharedbooking.R

class HomeAdapter (private val itemsList: List<HomeItem>): RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_home)
        val textViewFio: TextView = itemView.findViewById(R.id.fio_home)
        val textViewBirthday: TextView = itemView.findViewById(R.id.birthday_home)
        val textViewPol: TextView = itemView.findViewById(R.id.pol_home)
        val textViewCity: TextView = itemView.findViewById(R.id.city_home)
        val textViewPayment: TextView = itemView.findViewById(R.id.payment_home)
        val textViewCountPeople: TextView = itemView.findViewById(R.id.people_count_home)
        val textViewCountRoom: TextView = itemView.findViewById(R.id.rooms_count_home)
        val textViewTransport: TextView = itemView.findViewById(R.id.transport_home)
        val textViewTime: TextView = itemView.findViewById(R.id.time_home)
        val heartCheckBox: CheckBox = itemView.findViewById(R.id.heart)
        val checkBox: CheckBox = itemView.findViewById(R.id.check)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemsList[position]
        holder.imageView.setImageResource(item.imageResId)
        holder.textViewFio.text = item.fio
        holder.textViewBirthday.text = item.birthday
        holder.textViewPol.text = item.pol
        holder.textViewCity.text = "Город: " + item.city
        holder.textViewPayment.text = "До " +item.payment.toString() + " тысяч"
        holder.textViewCountPeople.text = "Людей в квартире: " + item.countPeople.toString()
        holder.textViewCountRoom.text = "Комнат в квартире: " + item.countRooms.toString()
        holder.textViewTransport.text = "До " + item.transport.toString() + " минут"
        holder.textViewTime.text = "Снимать до " + item.time + " месяцев"
        holder.heartCheckBox.isChecked = item.heartCheck
        holder.checkBox.isChecked = item.check
    }
}