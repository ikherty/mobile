package isb17.petrenko.fit

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {
    var adapter:Adapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setNavigationItemSelectedListener(this)
            var list=ArrayList<ListItem>()
            list.addAll(fillArrays(resources.getStringArray(R.array.exec), getImageId(R.array.exec_image)))
//            list.add(ListItem(R.drawable.ic_cook, title_text = "Плечи"))
//            list.add(ListItem(R.drawable.ic_cook, title_text = "Руки"))
//            list.add(ListItem(R.drawable.ic_cook, title_text = "Грудь"))
//            list.add(ListItem(R.drawable.ic_cook, title_text = "Спина"))
//            list.add(ListItem(R.drawable.ic_cook, title_text = "Ноги"))
            rcView.hasFixedSize()
            rcView.layoutManager= LinearLayoutManager(this)
            adapter=Adapter(list,this)

            rcView.adapter=adapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.id_exec->adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.exec), getImageId(R.array.exec_image)))
            R.id.id_cook->adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.cook), getImageId(R.array.cook_image)))
        }
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
    fun fillArrays(titleArray: Array<String>, imageArray: IntArray):List<ListItem>{
        var listItemArray=ArrayList<ListItem>()
        for(n in 0..titleArray.size-1){
            var listItem=ListItem(imageArray[n],titleArray[n])
            listItemArray.add(listItem)
        }
    return  listItemArray
    }
    fun getImageId(imageArrayId:Int): IntArray {
        var tarray:TypedArray=resources.obtainTypedArray(imageArrayId)
        val count=tarray.length()
        val ids=IntArray(count)
        for(i in ids.indices){
            ids[i]=tarray.getResourceId(i,0)
        }
        tarray.recycle()
        return ids

    }
}