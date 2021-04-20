package com.ardnn.recycleviewassignmet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // set timer for 1 second
        Handler(Looper.getMainLooper()).postDelayed({
            val goToMain: Intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(goToMain)
            finish()
        }, 1000)
    }
}