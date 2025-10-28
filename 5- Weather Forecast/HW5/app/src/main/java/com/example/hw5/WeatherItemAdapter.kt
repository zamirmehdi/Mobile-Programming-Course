package com.example.hw5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hw5.R
import com.example.hw5.ListDataClass
import java.text.SimpleDateFormat

class WeatherItemAdapter(private var context: Context, private var list: MutableList<ListDataClass>): RecyclerView.Adapter<WeatherItemAdapter.MyViewHolder>()  {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val day: TextView = itemView.findViewById(R.id.day)
        val time: TextView = itemView.findViewById(R.id.time)
        val image: ImageView = itemView.findViewById(R.id.image)
        val temp: TextView = itemView.findViewById(R.id.temp)

        fun bind(list: ListDataClass) {
            val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(list.dt_txt).toString()
            when(list.weather[0].icon) {
                "01d" -> image.setImageResource(R.drawable.x01d_2x)
                "01n" -> image.setImageResource(R.drawable.x01n_2x)
                "02d" -> image.setImageResource(R.drawable.x02d_2x)
                "02n" -> image.setImageResource(R.drawable.x02n_2x)
                "03d" -> image.setImageResource(R.drawable.x03d_2x)
                "03n" -> image.setImageResource(R.drawable.x03n_2x)
                "04d" -> image.setImageResource(R.drawable.x04d_2x)
                "04n" -> image.setImageResource(R.drawable.x04n_2x)
                "09d" -> image.setImageResource(R.drawable.x09d_2x)
                "09n" -> image.setImageResource(R.drawable.x09n_2x)
                "10d" -> image.setImageResource(R.drawable.x10d_2x)
                "10n" -> image.setImageResource(R.drawable.x10n_2x)
                "11d" -> image.setImageResource(R.drawable.x11d_2x)
                "11n" -> image.setImageResource(R.drawable.x11n_2x)
                "13d" -> image.setImageResource(R.drawable.x13d_2x)
                "13n" -> image.setImageResource(R.drawable.x13n_2x)
                "50d" -> image.setImageResource(R.drawable.x50d_2x)
                "50n" -> image.setImageResource(R.drawable.x50n_2x)
            }
            day.text = date.split(" ")[0]
            time.text = date.split(" ")[3].dropLast(3)
            temp.text = list.main.temp.toInt().toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.weather_card, parent, false)
        return MyViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem: ListDataClass = list[position]
        holder.bind(listItem)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}