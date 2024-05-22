package com.example.islami

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.islami.databinding.ActivityMainBinding
import com.example.islami.databinding.ActivityMainContentBinding
import com.example.islami.databinding.FragmentQuranBinding
import com.example.islami.fragments.HadethFragment
import com.example.islami.fragments.QuranFragment
import com.example.islami.fragments.SebhaFragment

//private fun <E> MutableList<E>.add(vararg elements: E) {
//    this.addAll(elements)
//}

class MainActivity : AppCompatActivity() {
    private lateinit var view: ActivityMainBinding
    private lateinit var view_content: ActivityMainContentBinding
    private lateinit var fragment_quran: FragmentQuranBinding

//    private lateinit var list: MutableList<String>
//    private lateinit var list2: MutableList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityMainBinding.inflate(layoutInflater)
        view_content = ActivityMainContentBinding.inflate(layoutInflater)
        setContentView(view.root)

//        list = mutableListOf()
//        list2 = mutableListOf()
//
//        list2.add(
//            7, 286, 200, 176, 120, 165, 206, 75, 129, 106, 123, 111, 43, 52, 99, 128, 111, 110, 98, 135, 112, 78, 118, 64,
//            77, 227, 93, 88, 69, 60, 34, 30, 73, 56, 45, 83, 181, 88, 75, 85, 54, 53, 89, 59, 37, 35, 38, 29, 18, 45,
//            60, 49, 62, 55, 78, 96, 29, 22, 24, 13, 14, 11, 11, 18, 12, 12, 30, 52, 52, 44, 28, 28, 20, 56, 40, 31,
//            50, 40, 46, 42, 29, 19, 36, 25, 22, 17, 19, 26, 30, 20, 15, 21, 11, 8, 8, 19, 5, 8, 8, 11, 11, 8, 3, 9, 5,
//            4, 7, 3, 6, 3, 5, 4, 5, 6
//        )
//
//        list.add(
//            "الفاتحه", "البقرة", "آل عمران", "النساء", "المائدة", "الأنعام", "الأعراف", "الأنفال", "التوبة", "يونس", "هود",
//            "يوسف", "الرعد", "إبراهيم", "الحجر", "النحل", "الإسراء", "الكهف", "مريم", "طه", "الأنبياء", "الحج", "المؤمنون",
//            "النّور", "الفرقان", "الشعراء", "النّمل", "القصص", "العنكبوت", "الرّوم", "لقمان", "السجدة", "الأحزاب", "سبأ",
//            "فاطر", "يس", "الصافات", "ص", "الزمر", "غافر", "فصّلت", "الشورى", "الزخرف", "الدّخان", "الجاثية", "الأحقاف",
//            "محمد", "الفتح", "الحجرات", "ق", "الذاريات", "الطور", "النجم", "القمر", "الرحمن", "الواقعة", "الحديد", "المجادلة",
//            "الحشر", "الممتحنة", "الصف", "الجمعة", "المنافقون", "التغابن", "الطلاق", "التحريم", "الملك", "القلم", "الحاقة", "المعارج",
//            "نوح", "الجن", "المزّمّل", "المدّثر", "القيامة", "الإنسان", "المرسلات", "النبأ", "النازعات", "عبس", "التكوير", "الإنفطار",
//            "المطفّفين", "الإنشقاق", "البروج", "الطارق", "الأعلى", "الغاشية", "الفجر", "البلد", "الشمس", "الليل", "الضحى", "الشرح",
//            "التين", "العلق", "القدر", "البينة", "الزلزلة", "العاديات", "القارعة", "التكاثر", "العصر",
//            "الهمزة", "الفيل", "قريش", "الماعون", "الكوثر", "الكافرون", "النصر", "المسد", "الإخلاص", "الفلق", "الناس"
//        )
//
//        fragment_quran=FragmentQuranBinding.inflate(layoutInflater)
//        val adapterQuran = Quran_adadpter(list, list2)
//        val recyclerView = fragment_quran.rvQuran
//        recyclerView.adapter = adapterQuran

        if (savedInstanceState==null){
            pushFragment(QuranFragment())
        }

        view.content.navigationBar.setOnItemSelectedListener {
            when (it.itemId){
                R.id.quran ->{
                    pushFragment(QuranFragment())
                }
                R.id.hadeth ->{pushFragment(HadethFragment())}
                R.id.sebha ->{pushFragment(SebhaFragment())}
                else ->pushFragment(QuranFragment())
            }

            true }
    }

    private fun pushFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container_layout,fragment)
            .commit()
    }
}
