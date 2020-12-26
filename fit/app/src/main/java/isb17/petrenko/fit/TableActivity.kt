package isb17.petrenko.fit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import isb17.petrenko.fit.db.DbManager
import kotlinx.android.synthetic.main.activity_table.*

class TableActivity : AppCompatActivity() {
    val dbManager = DbManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)
        getMyIntent()
    }

    override fun onResume() {
        super.onResume()
        dbManager.openDb()
    }

    fun onClickSave(view: View) {
        val myTitle=idTitle.text.toString()
        val myFill=idFill.text.toString()
        if (myTitle!=""&&myFill!="")
            dbManager.insertToDb(idTitle.text.toString(), idTitle.text.toString())
    }
    fun getMyIntent(){
        val i=intent
        if(i!=null){
            if(i.getStringExtra(MyIntentConstant.I_TITLE_KEY)!=null){
                idTitle.setText(i.getStringExtra(MyIntentConstant.I_TITLE_KEY))
                idFill.setText(i.getStringExtra(MyIntentConstant.I_CONTENT_KEY))
            }
        }
    }

    //        var index: Int = intent.getIntExtra("pos", 0)
//        Toast.makeText(this, "Выбрано $index", Toast.LENGTH_SHORT).show()
//        webView.loadUrl("file:///android_asset/item_$index.html")
    override fun onDestroy() {
        super.onDestroy()
        dbManager.closeDb()
    }
}