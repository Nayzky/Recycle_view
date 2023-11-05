package com.example.recycle_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recycle_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterDisaster = DisasterAdaptor(generateDummy(), { disaster ->
            showDetailDialog(disaster)
        }) { disaster ->
            showDetailDialog(disaster)
        }

        with(binding.rvDisaster) {
            adapter = adapterDisaster
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }
    }

    private fun generateDummy(): List<Disaster> {
        return listOf(
            Disaster(nameDisaster = "Bobby", typeDisaster = "Natural"),
            Disaster(nameDisaster = "DreamLife", typeDisaster = "Hope"),
            Disaster(nameDisaster = "Closure", typeDisaster = "GoodLife"),
            Disaster(nameDisaster = "Bokuno", typeDisaster = "Hero"),
            Disaster(nameDisaster = "MyTotoro", typeDisaster = "Fantasi"),
            Disaster(nameDisaster = "HeroAcademia", typeDisaster = "Action")
        )
    }

    private fun showDetailDialog(disaster: Disaster) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val prevFragment = fragmentManager.findFragmentByTag(DisasterDetailFragment.TAG)
        if (prevFragment != null) {
            fragmentTransaction.remove(prevFragment)
        }
        fragmentTransaction.addToBackStack(null)

        val dialogFragment = DisasterDetailFragment.newInstance(disaster)
        dialogFragment.show(fragmentTransaction, DisasterDetailFragment.TAG)
    }

}