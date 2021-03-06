package com.udacity

import android.app.NotificationManager
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.udacity.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object {
        const val FILE_NAME = "file_name"
        const val FILE_STATUS = "file_status"
    }

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        setSupportActionBar(binding.toolbar)

        val notificationManager:NotificationManager=ContextCompat.getSystemService(this,NotificationManager::class.java) as NotificationManager
        notificationManager.cancelAllNotification()

        binding.contentDetail.textViewFileNameValue.text = intent.getStringExtra(FILE_NAME) ?: ""
        binding.contentDetail.textViewStatusValue.text = intent.getStringExtra(FILE_STATUS) ?: ""


        binding.contentDetail.buttonOk.setOnClickListener {
            this.finish()
        }

    }

}
