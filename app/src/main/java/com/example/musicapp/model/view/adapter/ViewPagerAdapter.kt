package com.example.musicapp.model.view.adapter


import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.musicapp.model.view.DisplayFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    /**
     * We are going to have only 5 tabs
     */
    override fun getItemCount() = 5

    /**
     * Create the functionality for each tab
     * Tabs are created in SearchFragment in initView function
     */
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {DisplayFragment()}
            1 -> {DisplayFragment()}
            2 -> {DisplayFragment()}
            3 -> {DisplayFragment()}
            4 -> {DisplayFragment()}
            else -> {throw Resources.NotFoundException("Item Not Found")}
        }
    }

}