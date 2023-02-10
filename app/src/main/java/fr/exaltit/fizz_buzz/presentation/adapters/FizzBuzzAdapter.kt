package fr.exaltit.fizz_buzz.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.exaltit.fizz_buzz.R

class FizzBuzzAdapter(private val dataSet: List<String>) :
	RecyclerView.Adapter<FizzBuzzAdapter.ViewHolder>() {
	
	override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
		val view = LayoutInflater.from(viewGroup.context)
			.inflate(R.layout.fizzbuzz_item_row, viewGroup, false)
		
		return ViewHolder(view)
	}
	
	override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
		
		viewHolder.textView.text = dataSet[position]
	}
	
	override fun getItemCount() = dataSet.size
	
	
	class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		val textView: TextView
		
		init {
			textView = view.findViewById(R.id.textView_show_text)
		}
	}
}
