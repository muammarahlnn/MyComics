package com.ardnn.recycleviewassignmet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    companion object {
        val EXTRAS = arrayOf(
            "extra_title",
            "extra_author",
            "extra_publisher",
            "extra_synopsis",
            "extra_image",
            "extra_wallpaper"
        )
    }

    private lateinit var btnHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var tvComicsDetails: Array<TextView> = arrayOf(
            findViewById(R.id.tv_detail_title),
            findViewById(R.id.tv_detail_author),
            findViewById(R.id.tv_detail_publisher),
            findViewById(R.id.tv_detail_synopsis)
        )

        for (i in 0 until EXTRAS.size - 2) {
            tvComicsDetails[i].text = intent.getStringExtra(EXTRAS[i])
        }


        var ivDetailImage: ImageView = findViewById(R.id.iv_detail_image)
        ivDetailImage.setImageResource(intent.getIntExtra(EXTRAS[EXTRAS.size-2], R.color.white))

        var ivDetailWallpaper: ImageView = findViewById(R.id.iv_detail_wallpaper)
        ivDetailWallpaper.setImageResource(intent.getIntExtra(EXTRAS[EXTRAS.size-1], R.color.white))

        btnHome = findViewById(R.id.btn_home_detail)
        btnHome.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}