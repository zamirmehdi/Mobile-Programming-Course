package com.example.hw3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hw3.data.Datasource

class MainActivity : AppCompatActivity() {

    private var isLinearLayoutManager: Boolean = true
    val myDataset = Datasource().loadBooks()

    private fun chooseLayout() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        if (isLinearLayoutManager) {
            recyclerView.layoutManager = LinearLayoutManager(this)
        }
        else {
            recyclerView.layoutManager = GridLayoutManager(this, 3)
        }

        recyclerView.adapter = RecyclerAdapter(this, myDataset)
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this, R.drawable.grid_three_up_xxl)
            else ContextCompat.getDrawable(this, R.drawable.list_xxl)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)

        val layoutButton = menu?.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)

                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataset = Datasource().loadBooks()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = RecyclerAdapter(this, myDataset)

        recyclerView.setHasFixedSize(true)

        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}