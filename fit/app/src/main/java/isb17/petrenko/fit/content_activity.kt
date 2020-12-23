package isb17.petrenko.fit

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_layout.*

class content_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)
        var index: Int = intent.getIntExtra("pos", 0)
//        Toast.makeText(this, "Выбрано $index", Toast.LENGTH_SHORT).show()
        webView.loadUrl("file:///android_asset/item_$index.html")
    }
}