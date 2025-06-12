package com.czy.ttspemrogramanmobile

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), QuizInterface {
    // Deklarasi variabel untuk menyimpan referensi ke fragment
    private lateinit var questionFragment: QuestionNumberFragment
    private lateinit var answerFragment: AnswerFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mengunci orientasi layar ke landscape
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        // Set the content view
        setContentView(R.layout.activity_main)
        // Inisialisasi fragment
        setupFragments()
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }

    /**
     * Menginisialisasi fragment dan menggantikan fragment yang lama dengan
     * fragment yang baru.
     */
    private fun setupFragments() {
        // Inisialisasi fragment
        questionFragment = QuestionNumberFragment()
        answerFragment = AnswerFragment()

        // Setelah fragment diinisialisasi, maka kita dapat menggantikan
        // fragment yang lama dengan fragment yang baru.
        supportFragmentManager.beginTransaction()
            // Gantikan fragment yang lama dengan fragment yang baru
            .replace(R.id.fragment_question_numbers, questionFragment)
            // Gantikan fragment yang lama dengan fragment yang baru
            .replace(R.id.fragment_answers, answerFragment)
            // Tambahkan transaksi ke dalam stack
            .commit()
    }

    /**
     * Dijalankan setiap kali pengguna memilih jawaban untuk soal yang sedang dijawab.
     * Metode ini akan menampilkan pesan berupa toast yang menginformasikan apakah
     * jawaban yang dipilih benar atau salah.
     *
     * @param questionIndex Indeks soal yang sedang dijawab.
     * @param selectedAnswer Jawaban yang dipilih oleh pengguna.
     */
    override fun onAnswerCheck(questionIndex: Int, selectedAnswer: Int) {
        // Pastikan indeks soal yang sedang dijawab valid
        val questions = getQuestions()
        val isCorrect = questions[questionIndex].correctAnswer == selectedAnswer

        // Tampilkan pesan berupa toast yang menginformasikan apakah jawaban yang
        // dipilih benar atau salah
        val message = if (isCorrect) "Woww benar!" else "Oops salah!"
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


    /**
     * Mendapatkan daftar soal yang akan dijawab dalam quiz.
     * Soal-soal ini dihardcode dalam kode program.
     *
     * @return List of questions yang akan dijawab dalam quiz.
     */
    fun getQuestions(): List<Question> {
        // Return a hardcoded list of questions for the quiz
        return listOf(
            // Soal 1
            Question(
                "Apa yang dimaksud dengan Android Activity?🤔",
                listOf(
                    "Komponen yang mengelola database😊",
                    "Komponen yang mewakili satu layar dengan antarmuka pengguna😘",
                    "Komponen untuk mengelola jaringan🛜",
                    "Komponen untuk menyimpan data🤩"
                ),
                1 // Index 1 = jawaban kedua (benar)
            ),
            // Soal 2
            Question(
                "Bahasa pemrograman utama untuk Android development adalah?🤔",
                listOf(
                    "Python🐍",
                    "JavaScript🗿",
                    "Kotlin🍼👶",
                    "C++🥶"
                ),
                2 // Index 2 = Kotlin (benar)
            ),
            // Soal 3
            Question(
                "Apa kepanjangan dari XML dalam konteks Android?🤔",
                listOf(
                    "eXtensible Markup Language😑",
                    "eXtra Modern Language😐",
                    "eXecutable Mobile Language😏",
                    "eXternal Management Language🙄"
                ),
                0 // Index 0 = eXtensible Markup Language (benar)
            )
        )
    }
}

// Interface untuk memeriksa jawaban yang dipilih
interface QuizInterface {
    fun onAnswerCheck(questionIndex: Int, selectedAnswer: Int)
}

// Data class untuk menyimpan informasi tentang soal
data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswer: Int
)