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

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_COMICS = "extra_comics"
    }

    // widgets
    private lateinit var tvToolbarTitle: TextView
    private lateinit var tvDetailTitle: TextView
    private lateinit var tvDetailAuthor: TextView
    private lateinit var tvDetailPublisher: TextView
    private lateinit var tvDetailSynopsis: TextView
    private lateinit var ivBack: ImageView
    private lateinit var ivDetailImage: ImageView
    private lateinit var ivDetailWallpaper: ImageView
    private lateinit var btnHome: Button
    private lateinit var avDetailWallpaper: ArcView
    private lateinit var rrvDetailImage: RoundRectView

    // animations
    private lateinit var animTopToBottom: Animation
    private lateinit var animBottomToTop: Animation
    private lateinit var animLeftToRight: Animation
    private lateinit var animRightToLeft: Animation
    private lateinit var llDetailData: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // get comic object from previous intent
        val comic: Comic = intent.getParcelableExtra<Comic>(EXTRA_COMICS) as Comic

        // add comic to recent comics
        ComicsData.addRecentComic(comic)

        // initialize widgets
        tvToolbarTitle = findViewById(R.id.tv_toolbar_title_detail)
        tvDetailTitle = findViewById(R.id.tv_detail_title)
        tvDetailAuthor = findViewById(R.id.tv_detail_author)
        tvDetailPublisher = findViewById(R.id.tv_detail_publisher)
        tvDetailSynopsis = findViewById(R.id.tv_detail_synopsis)

        ivBack = findViewById(R.id.iv_back_detail)
        ivDetailImage = findViewById(R.id.iv_detail_image)
        ivDetailWallpaper = findViewById(R.id.iv_detail_wallpaper)

        avDetailWallpaper = findViewById(R.id.av_detail_wallpaper)
        rrvDetailImage = findViewById(R.id.rrv_detail_image)
        llDetailData = findViewById(R.id.ll_detail_data)

        btnHome = findViewById(R.id.btn_home_detail)

        // set widgets content
        tvToolbarTitle.text = comic.title
        tvDetailTitle.text = comic.title
        tvDetailAuthor.text = comic.author
        tvDetailPublisher.text = comic.publisher
        tvDetailSynopsis.text = comic.synopsis

        ivDetailImage.setImageResource(comic.image)
        ivDetailWallpaper.setImageResource(comic.wallpaper)

        // load animations
        animTopToBottom = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom)
        animBottomToTop = AnimationUtils.loadAnimation(this, R.anim.bottom_to_top)
        animLeftToRight = AnimationUtils.loadAnimation(this, R.anim.left_to_right)
        animRightToLeft = AnimationUtils.loadAnimation(this, R.anim.right_to_left)

        // run animations
        avDetailWallpaper.animation = animTopToBottom
        rrvDetailImage.animation = animLeftToRight
        tvDetailTitle.animation = animRightToLeft
        llDetailData.animation = animBottomToTop
        tvDetailSynopsis.animation = animBottomToTop


        // if button clicked
        btnHome.setOnClickListener(this)
        ivBack.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.iv_back_detail -> finish()
            R.id.btn_home_detail -> finish()
        }
    }
}