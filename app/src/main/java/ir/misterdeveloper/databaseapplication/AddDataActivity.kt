package ir.misterdeveloper.databaseapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ir.misterdeveloper.databaseapplication.database.AppDatabase
import ir.misterdeveloper.databaseapplication.database.DaoDatabase
import ir.misterdeveloper.databaseapplication.databinding.ActivityAddDataBinding
import ir.misterdeveloper.databaseapplication.model.DataApp


class AddDataActivity : AppCompatActivity() {


    private val REQUEST_CODE_PICKER: Int = 192
    lateinit var daoDatabase: DaoDatabase
    var selectedImageUri: Uri? = null
    lateinit var binding: ActivityAddDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddDataBinding.inflate(layoutInflater)
        setContentView(binding.root)


        daoDatabase = AppDatabase.getDatabase(applicationContext).daoDatabase



        binding.imageAdd.setOnClickListener {


            // intent to mobile files and photo selection
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_OPEN_DOCUMENT
            startActivityForResult(
                Intent.createChooser(intent, "select a picture"),
                REQUEST_CODE_PICKER
            )

        }

        binding.addData.setOnClickListener {

            // Save the address in the database to display it
            val dataApp = DataApp(
                title = binding.titleName.text.toString(),
                addressPhoto = selectedImageUri.toString()
            )

            val result = daoDatabase.insert(dataApp)

            if (result > 0) {
                Toast.makeText(this, "your data added", Toast.LENGTH_SHORT).show()
                finish()
            }

        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_PICKER) {
            if (resultCode == RESULT_OK) {

                // Getting the address of the photo storage location
                selectedImageUri = data!!.data
                binding.imagePhoto.setImageURI(selectedImageUri)

            }

        }

    }

}