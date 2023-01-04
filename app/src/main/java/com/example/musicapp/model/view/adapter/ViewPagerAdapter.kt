package com.example.musicapp.model.view.adapter


import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.musicapp.model.view.DisplayFragment
import com.example.musicapp.model.view.SearchFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    var miclase = SearchFragment()

    //We are going to have only 3 tabs
    override fun getItemCount() = 4

    //create the functionality for each tab
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> { DisplayFragment()}
            1 -> {DisplayFragment()}
            2 -> {DisplayFragment()}
            3 -> {DisplayFragment()}
            else -> {throw Resources.NotFoundException("Item Not Found")}
        }
    }

}