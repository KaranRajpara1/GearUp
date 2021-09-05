package com.example.gear_up

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.gear_up.fragments.DashboardFragment
import com.example.gear_up.fragments.InvitationFragment
import com.example.gear_up.fragments.MyNotesFragment
import com.example.gear_up.fragments.NotificationFragment

class activity_student : AppCompatActivity() {

    private val dashboardFragment = DashboardFragment()
    private val invitationFragment = InvitationFragment()
    private val myNotesFragment = MyNotesFragment()
    private val notificationFragment = NotificationFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        replaceFragment(dashboardFragment)

        
    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment != null){
            val transection = supportFragmentManager.beginTransaction()
            transection.replace(R.id.fragment_container, fragment)
            transection.commit()
        }
    }
}