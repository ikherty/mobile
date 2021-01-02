package isb17.petrenko.fit.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.icu.text.CaseMap
import android.provider.BaseColumns
import isb17.petrenko.fit.noteItem

//https://developer.android.com/training/data-storage/sqlite#kotlin
class DbManager(val context: Context) {
    val dbHelper = DbHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb() {
        db = dbHelper.writableDatabase
    }

    fun insertToDb(title: String, content: String) {
        val values = ContentValues().apply {
            put(MyDbNameClass.COLUMN_NAME_TITLE, title)
            put(MyDbNameClass.COLUMN_NAME_CONTENT, content)
        }
        db?.insert(MyDbNameClass.TABLE_NAME, null, values)
    }

    fun removeItemFromDb(id: String) {
        val selection = BaseColumns._ID + "=$id"
        db?.delete(MyDbNameClass.TABLE_NAME, selection, null)
    }

    fun readDbData(): ArrayList<noteItem> {
        val dataList = ArrayList<noteItem>()
        val cursor = db?.query(MyDbNameClass.TABLE_NAME, null, null, null, null, null, null)
        while (cursor?.moveToNext()!!) {
            val dataTitle = cursor.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_TITLE))
            val dataContent =
                cursor.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_CONTENT))
            val dataId =
                cursor.getInt(cursor.getColumnIndex(BaseColumns._ID))
            val item = noteItem()
            item.title = dataTitle
            item.fill = dataContent
            item.id = dataId
            dataList.add(item)
        }

        cursor.close()
        return dataList
    }

    fun closeDb() {
        dbHelper.close()
    }
}