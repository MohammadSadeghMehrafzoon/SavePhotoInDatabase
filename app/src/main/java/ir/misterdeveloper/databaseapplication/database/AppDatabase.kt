package ir.misterdeveloper.databaseapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.misterdeveloper.databaseapplication.model.DataApp

@Database(version = 1, exportSchema = false, entities = [ DataApp::class])
abstract class AppDatabase : RoomDatabase() {

    abstract val daoDatabase: DaoDatabase



    companion object {

        private var database: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {


            if (database == null) {

                database = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "dataApp.db"
                ).allowMainThreadQueries().build()
            }

            return database!!
        }
    }

}