package com.geneus.imaginibox.ui.main

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.geneus.imaginibox.R
import com.geneus.imaginibox.ui.adapter.GridRvAdapter

class BoxGridActivity : AppCompatActivity() {

    private val btnThreeByThree by lazy {
        findViewById<Button>(R.id.btnThreeByThree)
    }

    private val btnTwoByTwo by lazy {
        findViewById<Button>(R.id.btnTwoByTwo)
    }

    private val rvGridBox by lazy {
        findViewById<RecyclerView>(R.id.rvGridSquares)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_box_grid)
        initListeners()
        resetRecyclerView(3, 9)
    }

    fun initListeners() {
        btnThreeByThree.setOnClickListener {
            resetRecyclerView(3, 9)
        }

        btnTwoByTwo.setOnClickListener {
            resetRecyclerView(2, 4)
        }
    }

    fun resetRecyclerView(spanCount : Int, boxCount : Int){
        rvGridBox.layoutManager = GridLayoutManager(this, spanCount)
        rvGridBox.adapter = GridRvAdapter(this, boxCount)
    }
}