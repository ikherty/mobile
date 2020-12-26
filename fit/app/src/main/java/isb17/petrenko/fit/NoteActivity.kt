package isb17.petrenko.fit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import isb17.petrenko.fit.db.DbManager
import kotlinx.android.synthetic.main.main_content.*

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
        rcView.layoutManager=LinearLayoutManager(this)
        rcView.adapter=dbAdapter
    }
    fun fillAdapter(){
        dbAdapter.updateAdapter(dbManager.readDbData())
    }
}