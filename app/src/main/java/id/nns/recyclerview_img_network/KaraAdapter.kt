package id.nns.recyclerview_img_network

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class KaraAdapter(internal var listKara: ArrayList<Kara>) : RecyclerView.Adapter<KaraAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val txtName: TextView = itemView.findViewById(R.id.tv_name)
        private val txtDesc: TextView = itemView.findViewById(R.id.tv_det)
        private val imgPhoto: CircleImageView = itemView.findViewById(R.id.civ_url)

        fun bind(kara: Kara) {
            Glide.with(itemView.context)
                .load(kara.url)
                .into(imgPhoto)
            txtName.text = kara.name
            txtDesc.text = kara.det
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.KEY_KARA, kara)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KaraAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.kara_members, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listKara.size
    }

    override fun onBindViewHolder(holder: KaraAdapter.MyViewHolder, position: Int) {
        holder.bind(listKara[position])
    }
}