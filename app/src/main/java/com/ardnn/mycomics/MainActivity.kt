package com.ardnn.mycomics

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var bnvMain: BottomNavigationView
    private lateinit var fragmentMap: MutableMap<Int, Fragment>
    private val datasetName: String = "dataset.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // get dataset comics from assets folder and resources
        ComicsData.getDataset(this, datasetName)

        // initialize widgets
        bnvMain = findViewById(R.id.bnv_main)
        fragmentMap = mutableMapOf<Int, Fragment>()

    }

    override fun onStart() {
        super.onStart()

        fragmentMap.put(R.id.menu_item_home, HomeFragment.newInstance())
        fragmentMap.put(R.id.menu_item_recent, RecentFragment.newInstance())
        fragmentMap.put(R.id.menu_item_favorite, FavoriteFragment.newInstance())

        bnvMain.setOnNavigationItemSelectedListener(this)
        bnvMain.selectedItemId = R.id.menu_item_home
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fragment = fragmentMap.get(item.itemId)
        if (fragment != null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fl_main, fragment)
                    .commit()
        }
        return true
    }

}