package com.jaegerpicker.covid19api.ui.areas

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.LayoutRes
import com.jaegerpicker.covid19api.databinding.ActivityAreasBinding
import com.jaegerpicker.covid19api.ui.information.InformationActivity
import com.jaegerpicker.covid19api.R
import com.jaegerpicker.covid19api.ui.BindingActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class AreasActivity : BindingActivity<ActivityAreasBinding>() {

    @LayoutRes
    override fun getLayoutResId() = R.layout.activity_areas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = getViewModel()
        binding.setLifecycleOwner(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_area, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.search_recycler_view -> {
                startActivity(Intent(this, InformationActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
