package com.wixsite.mupbam1.resume.doskaobjavleniy

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.my_content.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        val toggle = ActionBarDrawerToggle(
            this, dlMenu, toolbar,
            R.string.open, R.string.closed
        )
        dlMenu.addDrawerListener(toggle)
        toggle.syncState()
        nvNav.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.id_myAds -> {
                Toast.makeText(this, "id_myAds", Toast.LENGTH_LONG).show()
            }
            R.id.id_car -> {
                Toast.makeText(this, "id_car", Toast.LENGTH_LONG).show()
            }
            R.id.id_pc -> {
                Toast.makeText(this, "id_pc", Toast.LENGTH_LONG).show()
            }
            R.id.id_smart -> {
                Toast.makeText(this, "id_smart", Toast.LENGTH_LONG).show()
            }
            R.id.id_dm -> {
                Toast.makeText(this, "id_dm", Toast.LENGTH_LONG).show()
            }
            R.id.id_signUp -> {
                Toast.makeText(this, "id_signUp", Toast.LENGTH_LONG).show()
            }
            R.id.id_signIn -> {
                Toast.makeText(this, "id_signIn", Toast.LENGTH_LONG).show()
            }
            R.id.id_signOut -> {
                Toast.makeText(this, "id_signOut", Toast.LENGTH_LONG).show()
            }
        }
        dlMenu.closeDrawer(GravityCompat.START)
        return true
    }
}
