package com.wiapp.happynote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

// Create a adapter reuse data in class Note
class NoteAdapter(val notes: List<Note>, val itemClickListener: View.OnClickListener)
    : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

        class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            //Stock of reference of data element who will have to be show
            val cardView = itemView.findViewById<CardView>(R.id.card_view)
            val titleView = cardView.findViewById<TextView>(R.id.title)
            val excerpView = cardView.findViewById<TextView>(R.id.excerp)

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_note,parent,false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.cardView.setOnClickListener(itemClickListener)
        holder.cardView.tag = position
        holder.titleView.text = note.title
        holder.excerpView.text = note.text
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}