package com.ardnn.recycleviewassignmet

object ComicsData {
    private val comicsData = arrayOf(
        arrayOf(
            "One Piece",
            "Eiichiro Oda",
            "Elex Media",
            "Manusia karet yang mau jadi raja bajak laut",
            "ini synopsis"
        ),
        arrayOf(
            "Hunter x Hunter",
            "Yoshihiro Togashi",
            "Gramedia",
            "Seorang anak yang jago mancing pergi cari bapaknya",
            "ini synopsis"
        ),
        arrayOf(
            "Naruto",
            "Masashi Kishimoto",
            "Gramedia",
            "Anak berambut kuning yang ada monster di dalam perutnya",
            "synopsis"
        ),
        arrayOf(
            "Katekyo Hitman Reborn",
            "Akira Amano",
            "Shonen Jump",
            "Nolep yang tiba - tiba disuruh jadi ketua mafia",
            "synopsis"
        ),
        arrayOf(
            "Haikyuu",
            "Haruichi Furudate",
            "Shonen Jump",
            "Pelajar bertubuh pendek yang ingin jago main volly",
            "synopsis"
        ),
        arrayOf(
            "Boku no Hero Academia",
            "Kohei Horikoshi",
            "Shonen Jump",
            "Seorang bocah yang mau jadi pahlawan nomor 1",
            "synopsis"
        ),
        arrayOf(
            "One Punch Man",
            "Yusuke Murata",
            "Gramedia",
            "Kehidupan pahlawan botak yang terlalu OP",
            "synopsis"
        ),
        arrayOf(
            "Solo Leveling",
            "Chu-Gong",
            "Kakao",
            "Orang cupu yang dibuff langsung OP",
            "synopsis"
        ),
        arrayOf(
            "Kimetsu no Yaiba",
            "Koyoharu Gatouge",
            "Elex Media",
            "Bocah tidak berdosa yang pulang kerumah melihat anggota keluarganya dibasmi iblis",
            "synopsis"
        ),
        arrayOf(
            "Shingeki no Kyojin",
            "Hajime Isayama",
            "Gramedia",
            "Sasageyo, sasageyo, shinzou wa sasageyo",
            "synopsis"
        ),
        arrayOf(
            "Kuroko no Basuke",
            "Tadatoshi Fujimaki",
            "Elex Media",
            "Anak SMA main basket tapi rambutnya kayak pelangi",
            "synopsis"
        )
    )

    private val comicImages = intArrayOf(
        R.drawable.onepiece,
        R.drawable.hxh,
        R.drawable.naruto,
        R.drawable.hitman,
        R.drawable.haikyuu,
        R.drawable.bnha,
        R.drawable.opm,
        R.drawable.solo,
        R.drawable.kny,
        R.drawable.snk,
        R.drawable.kuroko
    )


    val listData: ArrayList<Comic>
        get() {
            val list = arrayListOf<Comic>()
            for (i in comicsData.indices) {
                val comic = Comic()
                comic.title = comicsData[i][0]
                comic.author = comicsData[i][1]
                comic.publisher = comicsData[i][2]
                comic.summary = comicsData[i][3]
                comic.synopsis = comicsData[i][4]
                comic.image = comicImages[i]

                list.add(comic)
            }

            return list
        }

}