package isb17.petrenko.fit

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_layout.*
import kotlinx.android.synthetic.main.item_layout.*
import kotlinx.android.synthetic.main.rc_item.*
import kotlinx.android.synthetic.main.rc_item.tvTitle

class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)
//        tvTitle.text=intent.getStringExtra("title")
//        if (tvTitle.text=="Завтрак")
//            webView.loadUrl("https://grandkulinar.ru/9535-luchshie-recepty-dlya-zdorovogo-zavtraka.html")
        var index: Int = intent.getIntExtra("pos", 0)
//        Toast.makeText(this, "Выбрано $index", Toast.LENGTH_SHORT).show()
        webView.loadUrl("file:///android_asset/item_$index.html")
    }
}