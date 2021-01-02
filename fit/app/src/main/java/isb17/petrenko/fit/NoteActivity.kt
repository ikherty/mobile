package isb17.petrenko.fit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import isb17.petrenko.fit.db.DbManager
import kotlinx.android.synthetic.main.activity_note.*

class NoteActivity : AppCompatActivity() {
    val dbManager = DbManager(this)
    val dbAdapter = NoteAdapter(ArrayList(), this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)
        init()
    }

    override fun onResume() {
        super.onResume()
        dbManager.openDb()
        fillAdapter()
    }

    fun onClickNew(view: View) {
        val i = Intent(this, TableActivity::class.java)
        startActivity(i)
    }

    override fun onDestroy() {
        super.onDestroy()
        dbManager.closeDb()
    }

    fun init() {
        rcNoteView.layoutManager = LinearLayoutManager(this)
        val swapHelper = getSwapManager()
        swapHelper.attachToRecyclerView(rcNoteView)
        rcNoteView.adapter = dbAdapter
    }

    fun fillAdapter() {
        val list = dbManager.readDbData()
        dbAdapter.updateAdapter(list)
        if (list.size > 0) {
            tvNoElement.visibility = View.GONE
        } else {
            tvNoElement.visibility = View.VISIBLE
        }
    }

    private fun getSwapManager(): ItemTouchHelper {
        return ItemTouchHelper(object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                dbAdapter.removeItem(viewHolder.adapterPosition, dbManager)
            }
        })
    }
}