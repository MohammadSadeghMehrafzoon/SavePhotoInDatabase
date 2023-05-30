package ir.misterdeveloper.databaseapplication.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import ir.misterdeveloper.databaseapplication.R
import ir.misterdeveloper.databaseapplication.model.DataApp


class DataAdapter(
    private val context: Context,
    private val dataAppList: ArrayList<DataApp>,

    ) :
    RecyclerView.Adapter<DataAdapter.AddDataVH>() {


    class AddDataVH(itemView: View, context: Context) : RecyclerView.ViewHolder(itemView) {


        val textViewTitle: AppCompatTextView = itemView.findViewById(R.id.textViewTitle)
        val imageViewPhoto: CircleImageView = itemView.findViewById(R.id.imageViewPhoto);


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddDataVH {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.data_row, null)
        return AddDataVH(view, parent.context)
    }

    override fun onBindViewHolder(holder: AddDataVH, position: Int) {

        val data = dataAppList[position]

        val uri = Uri.parse(data.addressPhoto)

        Glide.with(context)
            .load(uri)
            .into(holder.imageViewPhoto)

        holder.textViewTitle.text = data.title


    }

    override fun getItemCount(): Int {

        return dataAppList.size

    }


}