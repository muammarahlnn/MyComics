package com.ardnn.recycleviewassignmet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    companion object {
        val EXTRAS = arrayOf(
            "extra_title",
            "extra_author",
            "extra_publisher",
            "extra_summary",
            "extra_synopsis",
            "extra_image"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var tvComicsDetails: Array<TextView> = arrayOf(
            findViewById(R.id.tv_detail_title),
            findViewById(R.id.tv_detail_author),
            findViewById(R.id.tv_detail_publisher),
            findViewById(R.id.tv_detail_summary),
            findViewById(R.id.tv_detail_synopsis)
        )

        for (i in 0 until EXTRAS.size - 1) {
            tvComicsDetails[i].text = intent.getStringExtra(EXTRAS[i])
        }

        var ivDetailImage: ImageView = findViewById(R.id.iv_detail_image)
        ivDetailImage.setImageResource(intent.getIntExtra(EXTRAS[EXTRAS.size-1], 0))
    }
}