package com.example.subsmissionsdicoding

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.example.subsmissionsdicoding.databinding.ActivityDetailBinding

class DetailActivity : BaseActivity() {

    companion object{
        const val KEY_GAME = "key_game"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val dataGame =  if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Game>(KEY_GAME, Game::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Game>(KEY_GAME)
        }

        if (dataGame != null){
            binding.tvTitle.text = dataGame.name
            binding.tvDescription.text = dataGame.description
            binding.imgDetail.setImageResource(dataGame.photo)
        }

        binding.includeButton.btnBuy.setOnClickListener {
            Toast.makeText(this, "kamu membeli " + dataGame!!.name, Toast.LENGTH_SHORT)
                .show()
        }

        binding.includeButton.actionShare.setOnClickListener {
            Toast.makeText(this, "kamu membagikan " + dataGame!!.name, Toast.LENGTH_SHORT)
                .show()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}