package isb17.petrenko.fit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import isb17.petrenko.fit.db.DbManager
import kotlinx.android.synthetic.main.activity_note.*

class NoteActivity : AppCompatActivity() {
    val dbManager = DbManager(this)
    val dbAdapter = NoteAdapter(ArrayList(),this)
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
        rcNoteView.layoutManager=LinearLayoutManager(this)
        rcNoteView.adapter=dbAdapter
    }
    fun fillAdapter(){
        val list=dbManager.readDbData()
        dbAdapter.updateAdapter(list)
        if(list.size>0) {
            tvNoElement.visibility = View.GONE
        } else
        {
            tvNoElement.visibility = View.VISIBLE
        }
    }
}