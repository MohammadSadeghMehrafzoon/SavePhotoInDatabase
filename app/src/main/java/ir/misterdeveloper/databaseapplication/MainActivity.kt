package ir.misterdeveloper.databaseapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import ir.misterdeveloper.databaseapplication.adapter.DataAdapter
import ir.misterdeveloper.databaseapplication.database.AppDatabase
import ir.misterdeveloper.databaseapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private var addressRecycler: DataAdapter? = null
    private var appDatabase: AppDatabase? = null
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        appDatabase = AppDatabase.getDatabase(applicationContext)
        showDataRecycler()

        binding.buttonAdd.setOnClickListener {
            val intent = Intent(applicationContext, AddDataActivity::class.java)
            startActivity(intent)
        }

        binding.buttonUpdate.setOnClickListener {

            showDataRecycler()
        }




    }

    private fun showDataRecycler() {
        addressRecycler = DataAdapter(
            applicationContext,
            ArrayList(appDatabase!!.daoDatabase.getAllData())
        )
        binding.recyclerView.adapter = addressRecycler
        binding.recyclerView.layoutManager = LinearLayoutManager(
            applicationContext,
            RecyclerView.VERTICAL,
            false
        )
    }


}