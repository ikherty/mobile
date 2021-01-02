package isb17.petrenko.fit

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import isb17.petrenko.fit.db.DbManager

class NoteAdapter(listMain: ArrayList<noteItem>, contextM: Context) :

    RecyclerView.Adapter<NoteAdapter.NoteHolder>() {
    var listArray = listMain
    var context = contextM

    class NoteHolder(itemView: View, contextV: Context) : RecyclerView.ViewHolder(itemView) {

        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        var context = contextV

        fun setData(item: noteItem) {
            tvTitle.text = item.title
            itemView.setOnClickListener {
                val intent = Intent(context, TableActivity::class.java).apply {
                    putExtra(MyIntentConstant.I_TITLE_KEY, item.title)
                    putExtra(MyIntentConstant.I_CONTENT_KEY, item.fill)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        var inflater = LayoutInflater.from(parent.context)
        return NoteHolder(inflater.inflate(R.layout.rc_item, parent, false), context)
    }

    override fun getItemCount(): Int {

        return listArray.size
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        holder.setData(listArray.get(position))
    }

    fun updateAdapter(listItem: List<noteItem>) {
        listArray.clear()
        listArray.addAll(listItem)
        notifyDataSetChanged()
    }

    fun removeItem(pos: Int, dbManager: DbManager) {
        dbManager.removeItemFromDb(listArray[pos].id.toString())
        listArray.removeAt(pos)
        notifyItemRangeChanged(0, listArray.size)
        notifyItemRemoved(pos)
    }
}