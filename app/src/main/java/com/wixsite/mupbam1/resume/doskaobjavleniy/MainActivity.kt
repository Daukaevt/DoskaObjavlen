package com.wixsite.mupbam1.resume.doskaobjavleniy

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.wixsite.mupbam1.resume.doskaobjavleniy.databinding.ActivityMainBinding
import com.wixsite.mupbam1.resume.doskaobjavleniy.dialogHelper.DialogConst
import com.wixsite.mupbam1.resume.doskaobjavleniy.dialogHelper.DialogHelper


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var binding: ActivityMainBinding
    private lateinit var tvAccount:TextView
    val dialogHelper = DialogHelper(this)
    val mAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        init()
    }

    override fun onStart() {
        super.onStart()
        uiUpdate(mAuth.currentUser)
    }

    private fun init()  {
            val toggle = ActionBarDrawerToggle(
                this, binding.dlMenu, binding.lMyContent.toolbar,
                R.string.open, R.string.closed)
            binding.dlMenu.addDrawerListener(toggle)
            toggle.syncState()
            binding.nvNav.setNavigationItemSelectedListener(this)
            tvAccount = binding.nvNav.getHeaderView(0).findViewById(R.id.tvAccount)
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
                dialogHelper.createSignDialog(DialogConst.SIGN_UP_STATE)
            }
            R.id.id_signIn -> {
                dialogHelper.createSignDialog(DialogConst.SIGN_IN_STATE)
            }
            R.id.id_signOut -> {
                uiUpdate(null)
                mAuth.signOut()
            }
        }
        binding.dlMenu.closeDrawer(GravityCompat.START)
        return true
    }
    fun uiUpdate (user:FirebaseUser?){
        tvAccount.text=if(user==null){
            resources.getString(R.string.ad_notReg)
        }else{
            user.email
        }

    }
}
