package isb17.petrenko.fit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setNavigationItemSelectedListener(this)
            var list=ArrayList<ListItem>()
            list.add(ListItem(R.drawable.ic_cook, title_text = "Плечи"))
            list.add(ListItem(R.drawable.ic_cook, title_text = "Руки"))
            list.add(ListItem(R.drawable.ic_cook, title_text = "Грудь"))
            list.add(ListItem(R.drawable.ic_cook, title_text = "Спина"))
            list.add(ListItem(R.drawable.ic_cook, title_text = "Ноги"))
            rcView.hasFixedSize()
            rcView.layoutManager= LinearLayoutManager(this)
            rcView.adapter=Adapter(list,this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }
//        var nameList=ArrayList<String>()
//        nameList.add("https://dev.px4.io/v1.9.0/en/ros/offboard_control.html")
//        nameList.add("https://dev.px4.io/v1.9.0/en/ros/offboard_control.html")
//        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,nameList)
//        listView.adapter=adapter
//        listView.setOnItemClickListener{parent, view, position, id ->
//            //run actions after click
//            Toast.makeText(this,"Pressed item ${nameList.get(position)}", Toast.LENGTH_SHORT).show()
//        }

}