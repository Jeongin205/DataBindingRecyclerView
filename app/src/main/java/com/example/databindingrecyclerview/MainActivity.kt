package com.example.databindingrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.databindingrecyclerview.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val list: ArrayList<Data> = ArrayList()

        binding.recycler.adapter = MainAdapter(list){data, position ->
            list.removeAt(position)
            Toast.makeText(this, "냠냠", Toast.LENGTH_SHORT).show()
            binding.recycler.adapter?.notifyItemRemoved(position)
        }

        binding.addBtn.setOnClickListener {
            val randomInt = Random.nextInt(100).toString()
            list.add(Data("애플파이", randomInt))
            binding.recycler.adapter?.notifyItemInserted(list.size.minus(1))

        }

    }

}