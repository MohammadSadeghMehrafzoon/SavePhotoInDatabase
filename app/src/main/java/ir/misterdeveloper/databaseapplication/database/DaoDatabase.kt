package ir.misterdeveloper.databaseapplication.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ir.misterdeveloper.databaseapplication.model.DataApp

@Dao
interface DaoDatabase {


    @Insert
    fun insert(dataApp:DataApp):Long


    @Query("select * from dataApp_table")
    fun getAllData():List<DataApp>
}