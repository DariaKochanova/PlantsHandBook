package com.example.plantshandbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.plantshandbook.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding

    private var index = 0
    private var imageId = R.drawable.aloe
    private val imageIdList = listOf(
        R.drawable.aloe,
        R.drawable.bambuk,
        R.drawable.kaktus,
        R.drawable.lilia,
        R.drawable.palma,
        R.drawable.podsolnuk,
        R.drawable.romashka,
        R.drawable.roza,
        R.drawable.vasilek,
        R.drawable.viunok
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButton()
    }

    private fun initButton() = with(binding){
        bNext.setOnClickListener{
            index++
            if (index > imageIdList.size - 1) index = 0
            imageId = imageIdList[index]
            imageView.setImageResource(imageId)
        }

        bDone.setOnClickListener{
            val plant = Plant(imageId, edTitle.text.toString(), edDisc.text.toString())
            val editIntent = Intent().apply{
                putExtra("plant", plant)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }



}