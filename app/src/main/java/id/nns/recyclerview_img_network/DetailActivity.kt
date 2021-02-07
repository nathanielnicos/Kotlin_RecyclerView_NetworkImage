package id.nns.recyclerview_img_network

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_KARA = "key_kara"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataKara = intent.getParcelableExtra(KEY_KARA) as Kara
        findViewById<TextView>(R.id.tv_name_detail).text = dataKara.name
        findViewById<TextView>(R.id.tv_det_detail).text = dataKara.det
        Glide.with(this)
                .load(dataKara.url)
                .into(findViewById(R.id.img_photo_detail))
    }
}