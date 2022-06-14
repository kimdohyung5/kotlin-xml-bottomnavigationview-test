package com.kimdo.bottomnavtest


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.kimdo.bottomnavtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate( layoutInflater )}

    private lateinit var mNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( binding.root )

        setBottomNav()

        changeSelectedItemId( R.id.fragment_home )
    }

    private fun setBottomNav() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController( navController )

        val appBarConfiguration = AppBarConfiguration( setOf( R.id.fragment_home, R.id.fragment_info, R.id.fragment_setting) )
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)

        mNavController = navController

        mNavController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.fragment_info || destination.id == R.id.fragment_info_child) {
                binding.toolbar.visibility = View.GONE
                binding.bottomNavigationView.visibility = View.GONE
            } else {
                binding.toolbar.visibility = View.VISIBLE
                binding.bottomNavigationView.visibility = View.VISIBLE
            }
        }
    }

    fun changeSelectedItemId( id: Int) {
        binding.bottomNavigationView.selectedItemId = id
    }

    companion object {
        const val TAG = "MainActivity"
    }
}