package com.ardnn.mycomics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.github.florent37.shapeofview.shapes.ArcView
import com.github.florent37.shapeofview.shapes.RoundRectView

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

    // widgets
    private lateinit var btnHome: Button
    private lateinit var avDetailWallpaper: ArcView
    private lateinit var rrvDetailImage: RoundRectView

    // animations
    private lateinit var animTopToBottom: Animation
    private lateinit var animBottomToTOp: Animation
    private lateinit var animLeftToRight: Animation
    private lateinit var animRightToLeft: Animation
    private lateinit var llDetailData: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // initialize widgets
        var tvComicsDetails: Array<TextView> = arrayOf(
            findViewById(R.id.tv_detail_title),
            findViewById(R.id.tv_detail_author),
            findViewById(R.id.tv_detail_publisher),
            findViewById(R.id.tv_detail_synopsis)
        )
        var ivDetailImage: ImageView = findViewById(R.id.iv_detail_image)
        var ivDetailWallpaper: ImageView = findViewById(R.id.iv_detail_wallpaper)
        avDetailWallpaper = findViewById(R.id.av_detail_wallpaper)
        rrvDetailImage = findViewById(R.id.rrv_detail_image)
        llDetailData = findViewById(R.id.ll_detail_data)

        // set widgets content
        for (i in 0 until EXTRAS.size - 2) {
            tvComicsDetails[i].text = intent.getStringExtra(EXTRAS[i])
        }
        ivDetailImage.setImageResource(intent.getIntExtra(EXTRAS[EXTRAS.size-2], R.color.white))
        ivDetailWallpaper.setImageResource(intent.getIntExtra(EXTRAS[EXTRAS.size-1], R.color.white))

        // load animations
        animTopToBottom = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom)
        animBottomToTOp = AnimationUtils.loadAnimation(this, R.anim.bottom_to_top)
        animLeftToRight = AnimationUtils.loadAnimation(this, R.anim.left_to_right)
        animRightToLeft = AnimationUtils.loadAnimation(this, R.anim.right_to_left)

        // run animations
        avDetailWallpaper.animation = animTopToBottom
        rrvDetailImage.animation = animLeftToRight
        tvComicsDetails[0].animation = animRightToLeft
        llDetailData.animation = animBottomToTOp
        tvComicsDetails[3].animation = animBottomToTOp


        // if button clicked
        btnHome = findViewById(R.id.btn_home_detail)
        btnHome.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}