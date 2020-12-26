package isb17.petrenko.fit

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
//import isb17.petrenko.fit.db.DbManager
import kotlinx.android.synthetic.main.header_main_menu.*
import kotlinx.android.synthetic.main.table_layout.*

class note_activity : AppCompatActivity() {
    //val dbManager = DbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.note_layout)

    }

    override fun onResume() {
        super.onResume()
        //dbManager.openDb()

        }

    fun onClickNew(view: View) {
        val i=Intent(this, note_activity::class.java)
        startActivity(i)
        }

    //        var index: Int = intent.getIntExtra("pos", 0)
////        Toast.makeText(this, "Выбрано $index", Toast.LENGTH_SHORT).show()
//        webView.loadUrl("file:///android_asset/item_$index.html")
    override fun onDestroy() {
        super.onDestroy()
        //dbManager.closeDb()
    }
}