package isb17.petrenko.fit

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import isb17.petrenko.fit.db.DbManager
import kotlinx.android.synthetic.main.header_main_menu.*
import kotlinx.android.synthetic.main.table_layout.*

class table_activity : AppCompatActivity() {
    val dbManager = DbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)
    }

    override fun onResume() {
        super.onResume()
        dbManager.openDb()
        val dataList = dbManager.readDbData()
        for (item in dataList) {
            tvTest.append(item + "\n")
        }
    }

    fun onClickSave(view: View) {
        tvTest.text = ""
//        dbManager.openDb()
        dbManager.insertToDb(idTitle.text.toString(), idTitle.text.toString())
        val dataList = dbManager.readDbData()
        for (item in dataList) {
            tvTest.append(item + "\n")
        }
    }

    //        var index: Int = intent.getIntExtra("pos", 0)
////        Toast.makeText(this, "Выбрано $index", Toast.LENGTH_SHORT).show()
//        webView.loadUrl("file:///android_asset/item_$index.html")
    override fun onDestroy() {
        super.onDestroy()
        dbManager.closeDb()
    }
}