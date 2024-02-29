package com.example.subsmissionsdicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.subsmissionsdicoding.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val list = ArrayList<Game>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvGame.setHasFixedSize(true)

        list.addAll(getListGames())
        showRecyclerList()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.about_page -> {
                val intent = Intent(this@HomeActivity, AboutActivity::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun getListGames(): ArrayList<Game>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listGame = ArrayList<Game>()
        for (i in dataName.indices) {
            val game = Game(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listGame.add(game)
        }
        return listGame
    }

    private fun showRecyclerList() {
        binding.rvGame.layoutManager = LinearLayoutManager(this)
        val listGameAdapter = ListGameAdapter(list)
        binding.rvGame.adapter = listGameAdapter
    }
}