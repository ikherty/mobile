package ISb17.petrenko.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import var9

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var RandomArray = var9.randomArray(10)
        var inputString: String = ""
        for (c in RandomArray)
            inputString += (c.toString() + " ")
        inputField.setText(inputString)

        button.setOnClickListener {
            var customArray = var9.customArray(RandomArray)
            var customString: String = ""
            for (c in customArray)
                customString += (c.toString() + " ")
            outputField.setText(customString)
        }
    }
}