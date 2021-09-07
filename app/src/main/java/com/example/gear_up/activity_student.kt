package com.example.gear_up

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.gear_up.fragments.DashboardFragment
import com.example.gear_up.fragments.InvitationFragment
import com.example.gear_up.fragments.MyNotesFragment
import com.example.gear_up.fragments.NotificationFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class activity_student : AppCompatActivity() {

    private val dashboardFragment = DashboardFragment()
    private val invitationFragment = InvitationFragment()
    private val myNotesFragment = MyNotesFragment()
    private val notificationFragment = NotificationFragment()

    //private val bottomNavigation = findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.bottom_navigation)
    //private val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

    //BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        replaceFragment(dashboardFragment)
        //bottomNavigation.setOnNavigationItemReselectedListener {  }

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
//        bottomNavigation.setOnNavigationItemSelectedListener { item ->
//            when(item.itemId){
//                R.id.ic_dashboard -> {DashboardFragment}
//                //R.id.ic_notification -> notificationFragment()
////
//               R.id.ic_notification -> {notificationFragment}
//            }
//             true
//        }
//        bottomNavigation.setOnNavigationItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.ic_dashboard -> { dashboardFragment
//                }
//                R.id.ic_invitation -> { invitationFragment
//                }
////                R.id.action_music -> {
////                }
//            }
//            true
//        }

//        Stackoverflow link:
//        https://stackoverflow.com/questions/44611224/how-to-setonnavigationitemlistener-on-bottomnavigationview-in-android-using-kotl
        bottomNavigation.setOnNavigationItemSelectedListener {
            var selectedFragment: Fragment = dashboardFragment
            when (it.itemId) {
                R.id.ic_dashboard -> selectedFragment = dashboardFragment
                R.id.ic_invitation -> selectedFragment = invitationFragment
                R.id.ic_notification -> selectedFragment = notificationFragment
                R.id.ic_mynotes -> selectedFragment = myNotesFragment
            }
            val transection = supportFragmentManager.beginTransaction()
            transection.replace(R.id.fragment_container, selectedFragment)
            transection.commit()
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun replaceFragment(fragment: Fragment){

        if(fragment != null){
            val transection = supportFragmentManager.beginTransaction()
            transection.replace(R.id.fragment_container, fragment)

            transection.commit()
        }
    }
}