package com.example.swiftycompanion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swiftycompanion.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    // TODO: Commented lines about binding are for API fetching
//    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root) // TODO: can I have the 2 of them here?
        setContentView(R.layout.activity_main)

//        fetchCurrencyData().start()

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.searchFragment,
                R.id.profilesFragment,
                R.id.myProfileFragment
            )
        )

        // Navigation menu
        bottomNavigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

//    private fun fetchCurrencyData(): Thread {
//        return Thread {
//            val url = URL("https://open.er-api.com/v6/latest/aud")
//            val connection = url.openConnection() as HttpURLConnection
//
//            if (connection.responseCode == 200) {
//                val inputSystem = connection.inputStream
//                println(inputSystem.toString())
//            } else {
//                binding.baseCurrency.text = "Failed Connection"
//            }
//        }
//    }

    // Navigation menu
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}