package isb17.petrenko.fit.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.icu.text.CaseMap

//https://developer.android.com/training/data-storage/sqlite#kotlin
class DbManager(val context: Context) {
    val DbHelper = DbHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb() {
        db = DbHelper.writableDatabase
    }

    fun insertToDb(title: String, content: String) {
        val values = ContentValues().apply {
            put(MyDbNameClass.COLUMN_NAME_TITLE, title)
            put(MyDbNameClass.COLUMN_NAME_CONTENT, content)
        }
        db?.insert(MyDbNameClass.TABLE_NAME, null, values)
    }

    fun readDbData(): ArrayList<String> {
        val dataList = ArrayList<String>()
        val cursor = db?.query(MyDbNameClass.TABLE_NAME, null, null, null, null, null, null)
        with(cursor) {
            while (this?.moveToNext()!!) {
                val dataText =
                    cursor?.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_TITLE))
                dataList.add(dataText.toString())
            }
        }
        return dataList
    }
}