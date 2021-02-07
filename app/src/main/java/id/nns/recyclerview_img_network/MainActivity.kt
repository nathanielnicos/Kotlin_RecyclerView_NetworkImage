package id.nns.recyclerview_img_network

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<Kara>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setting recyclerview
        val recyclerView: RecyclerView = findViewById(R.id.rv_kara)
        recyclerView.setHasFixedSize(true)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val listKaraAdapter = KaraAdapter(list)
        recyclerView.adapter = listKaraAdapter

        // Menyiapkan data dari resource
        val karaName = resources.getStringArray(R.array.kara_name)
        val karaDet = resources.getStringArray(R.array.kara_det)
        val karaUrl = resources.getStringArray(R.array.kara_url)

        // Memasukkan data ke data class
        val karaMembers = ArrayList<Kara>()
        for (position in karaName.indices) {
            val kara = Kara(
                karaName[position],
                karaDet[position],
                karaUrl[position]
            )
            karaMembers.add(kara)
        }

        // Memasukkan data class ke adapter
        listKaraAdapter.listKara = karaMembers
    }
}