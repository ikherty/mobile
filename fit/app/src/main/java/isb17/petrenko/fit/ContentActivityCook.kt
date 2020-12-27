package isb17.petrenko.fit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_layout.*

class ContentActivityCook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)
        var index: Int = intent.getIntExtra("pos", 0)
//        Toast.makeText(this, "Выбрано $index", Toast.LENGTH_SHORT).show()
        var str = ""
        when (index) {
            0 -> str = "https://grandkulinar.ru/9535-luchshie-recepty-dlya-zdorovogo-zavtraka.html"
            1 -> str = "https://grandkulinar.ru/recepies/zdorovoe-pitanie/poleznye-obedy/"
            2 -> str = "https://grandkulinar.ru/recepies/zdorovoe-pitanie/poleznye-perekusy/"
            3 -> str = "https://grandkulinar.ru/recepies/zdorovoe-pitanie/poleznye-uzhiny/"
        }
        webView.loadUrl(str)
    }
}