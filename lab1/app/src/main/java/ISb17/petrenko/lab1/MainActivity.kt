package ISb17.petrenko.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import var9

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val RandomArray = var9.randomArray(10)
        val inputString = RandomArray.joinToString()
        inputField.setText(inputString)

        button.setOnClickListener {
            val customArray = var9.customArray(RandomArray)
            val customString = customArray.joinToString()
            outputField.setText(customString)
        }
    }
}