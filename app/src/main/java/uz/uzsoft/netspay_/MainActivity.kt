package uz.uzsoft.netspay_

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import uz.uzsoft.kidya.utils.hideKeyboard
import uz.uzsoft.netspay_.utils.NavigationUIHelper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_profile, R.id.nav_earnings,
                R.id.nav_cards
            )
        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        navController.addOnDestinationChangedListener { _, destination, _ ->

            when (destination.id) {
                R.id.nav_welcome -> {
                    container.setPadding(0, 0, 0, 0)
                    this.container.hideKeyboard()
                    nav_view.visibility = View.GONE
                    floatingActionButton.visibility = View.GONE
                }

                R.id.nav_onboarding -> {
                    container.setPadding(0, 0, 0, 0)
                    this.container.hideKeyboard()
                    nav_view.visibility = View.GONE
                    floatingActionButton.visibility = View.GONE

                }

                R.id.nav_home -> {
                    nav_view.visibility = View.VISIBLE
                }
                R.id.nav_cards -> {
                    nav_view.visibility = View.VISIBLE
                }
                R.id.nav_earnings -> {
                    nav_view.visibility = View.VISIBLE
                }
                R.id.nav_profile -> {
                    nav_view.visibility = View.VISIBLE
                }

                else -> supportActionBar?.show()
            }
        }


        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );


        val floatingActionButton: FloatingActionButton = findViewById(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener {
//            startActivity(Intent(this,MapsActivity::class.java))
            Toast.makeText(applicationContext, "Fab clicked", Toast.LENGTH_SHORT).show()
        }


        nav_view.setOnNavigationItemSelectedListener { item: MenuItem ->
            val builder = NavOptions.Builder()
                .setLaunchSingleTop(true)

            when (item.title) {
                "Home" -> {
                    Toast.makeText(applicationContext, "Home", Toast.LENGTH_SHORT).show()
                }
                "Cards" -> {
                    Toast.makeText(applicationContext, "Cards", Toast.LENGTH_SHORT).show()
                }
                "Earnings" -> {
                    Toast.makeText(applicationContext, "Earnings", Toast.LENGTH_SHORT).show()
                }
                "Profile" -> {
                    Toast.makeText(applicationContext, "Profile", Toast.LENGTH_SHORT).show()
                }

                else -> {
                    navController.navigate(R.id.nav_home)
                }
            }

            NavigationUIHelper.onNavDestinationSelected(item, navController, builder)
            true
        }
    }
}