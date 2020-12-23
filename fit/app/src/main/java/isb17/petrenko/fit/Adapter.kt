package isb17.petrenko.fit

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class Adapter(listArray: ArrayList<ListItem>, context: Context) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    var listArrayR = listArray
    var contextR = context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val im = view.findViewById<ImageView>(R.id.im)

        fun bind(listItem: ListItem, context: Context, position: Int) {
            tvTitle.text = listItem.title_text
            im.setImageResource(listItem.image_id)
            itemView.setOnClickListener {
                val i = Intent(context, content_activity::class.java).apply {
//                    putExtra("title", tvTitle.text.toString())
//                    putExtra("image", listItem.image_id)
                    putExtra("pos", position)
                }
                context.startActivity(i)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, ViewHolder: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return listArrayR.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem = listArrayR.get(position)
        holder.bind(listItem, contextR, position)
    }

    fun updateAdapter(listArray: List<ListItem>) {
        listArrayR.clear()
        listArrayR.addAll(listArray)
        notifyDataSetChanged()
    }
}