package com.example.project_mobile_kelompok2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.FragmentTransaction
import com.example.project_mobile_kelompok2.Fragment.*
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{

    lateinit var toogle: ActionBarDrawerToggle
    lateinit var inboxFragment: HalamanUser
    lateinit var draftFragment: HalamanUtama
    lateinit var sendFragment: HalamanBarang
    lateinit var settingFragment: HalamanSetting
    lateinit var helpFragment: HalamanHelp
    lateinit var editBarang: HalamanEditBarang
    lateinit var editUser: HalamanEditUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toogle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        nav_view.setNavigationItemSelectedListener (this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.inbox -> {
                inboxFragment = HalamanUser()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, inboxFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(applicationContext,"Ini Halaman Inbox",Toast.LENGTH_SHORT)
                    .show()
            }
            R.id.draft -> {
                draftFragment = HalamanUtama()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, draftFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(applicationContext,"Ini Halaman Draft",Toast.LENGTH_SHORT)
                    .show()
            }
            R.id.send -> {
                sendFragment = HalamanBarang()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, sendFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(applicationContext,"Ini Halaman Send",Toast.LENGTH_SHORT)
                    .show()
            }
            R.id.setting -> {
                settingFragment = HalamanSetting()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, settingFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(applicationContext,"Ini Halaman Setting",Toast.LENGTH_SHORT)
                    .show()
            }
            R.id.help -> {
                helpFragment = HalamanHelp()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, helpFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(applicationContext,"Ini Halaman Help",Toast.LENGTH_SHORT)
                    .show()
            }
        }
        drawerLayout.closeDrawers()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toogle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}