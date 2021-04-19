package com.ardnn.recycleviewassignmet

object ComicsData {
//    private val comicsData = arrayOf(
//        arrayOf(
//            "One Piece",
//            "Eiichiro Oda",
//            "Elex Media",
//            "Manusia karet yang mau jadi raja bajak laut",
//            "ini synopsis"
//        ),
//        arrayOf(
//            "Hunter x Hunter",
//            "Yoshihiro Togashi",
//            "Gramedia",
//            "Seorang anak yang jago mancing pergi cari bapaknya",
//            "ini synopsis"
//        ),
//        arrayOf(
//            "Naruto",
//            "Masashi Kishimoto",
//            "Gramedia",
//            "Anak berambut kuning yang ada monster di dalam perutnya",
//            "synopsis"
//        ),
//        arrayOf(
//            "Katekyo Hitman Reborn",
//            "Akira Amano",
//            "Shonen Jump",
//            "Nolep yang tiba - tiba disuruh jadi ketua mafia",
//            "synopsis"
//        ),
//        arrayOf(
//            "Haikyuu",
//            "Haruichi Furudate",
//            "Shonen Jump",
//            "Pelajar bertubuh pendek yang ingin jago main volly",
//            "synopsis"
//        ),
//        arrayOf(
//            "Boku no Hero Academia",
//            "Kohei Horikoshi",
//            "Shonen Jump",
//            "Seorang bocah yang mau jadi pahlawan nomor 1",
//            "synopsis"
//        ),
//        arrayOf(
//            "One Punch Man",
//            "Yusuke Murata",
//            "Gramedia",
//            "Kehidupan pahlawan botak yang terlalu OP",
//            "synopsis"
//        ),
//        arrayOf(
//            "Solo Leveling",
//            "Chu-Gong",
//            "Kakao",
//            "Orang cupu yang dibuff langsung OP",
//            "synopsis"
//        ),
//        arrayOf(
//            "Kimetsu no Yaiba",
//            "Koyoharu Gatouge",
//            "Elex Media",
//            "Bocah tidak berdosa yang pulang kerumah melihat anggota keluarganya dibasmi iblis",
//            "synopsis"
//        ),
//        arrayOf(
//            "Shingeki no Kyojin",
//            "Hajime Isayama",
//            "Gramedia",
//            "Sasageyo, sasageyo, shinzou wa sasageyo",
//            "synopsis"
//        ),
//        arrayOf(
//            "Kuroko no Basuke",
//            "Tadatoshi Fujimaki",
//            "Elex Media",
//            "Anak SMA main basket tapi rambutnya kayak pelangi",
//            "synopsis"
//        )
//    )

    private val comicTitles = arrayOf(
        "One Piece",
        "Hunter X Hunter",
        "Naruto",
        "Katekyo Hitman Reborn",
        "Haikyuu",
        "Boku no Hero Academia",
        "One Punch Man",
        "Solo Leveling",
        "Kimetsu no Yaiba",
        "Shingeki no Kyojin",
        "Kuroko no Basuke"
    )

    private val comicSummaries = arrayOf(
        "Summary One Piece",
        "Summary Hunter X Hunter",
        "Summary Naruto",
        "Summary Katekyo Hitman Reborn",
        "Summary Haikyuu",
        "Summary Boku no Hero Academia",
        "Summary One Punch Man",
        "Summary Solo Leveling",
        "Summary Kimetsu no Yaiba",
        "Summary Shingeki no Kyojin",
        "Summary Kuroko no Basuke"
    )

    private val comicsImages = intArrayOf(
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
            for (position in comicTitles.indices) {
                val comic = Comic()
                comic.title = comicTitles[position]
                comic.summary = comicSummaries[position]
                comic.image = comicsImages[position]

                list.add(comic)
            }
            return list
        }

//        get() {
//            val list = arrayListOf<Comic>()
//            for (pos in comicsData.indices) {
//                val comic = Comic()
//                comic.title = comicsData[pos][0]
//                comic.author = comicsData[pos][1]
//                comic.publisher = comicsData[pos][2]
//                comic.summary = comicsData[pos][3]
//                comic.synopsis = comicsData[pos][4]
//                comic.image = comicsImages[pos]
//            }
//            return list
//        }

}