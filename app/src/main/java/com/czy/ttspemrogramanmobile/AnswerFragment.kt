package com.czy.ttspemrogramanmobile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class AnswerFragment : Fragment() {
    // Interface untuk berkomunikasi dengan MainActivity
    private lateinit var questionText: TextView
    private lateinit var radioGroup: RadioGroup
    private lateinit var checkButton: Button

    // Question index yang sedang ditampilkan untuk memeriksa jawaban
    private var currentQuestionIndex = 0


    /**
     * Dipanggil saat tampilan fragmen dibuat.
     *
     * @param inflater Digunakan untuk mengisi tampilan fragmen.
     * @param container Wadah yang menampung fragmen.
     * @param savedInstanceState Jika tidak null, fragmen ini sedang dibangun kembali dari keadaan sebelumnya yang disimpan.
     * @return Mengembalikan tampilan yang diisi untuk fragmen ini.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Mengisi tampilan fragmen dengan layout fragment_answers
        return inflater.inflate(R.layout.fragment_answers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Pastikan fungsi onViewCreated superclass dijalankan
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi tampilan
        questionText = view.findViewById(R.id.question_text)
        radioGroup = view.findViewById(R.id.radio_group)
        checkButton = view.findViewById(R.id.check_button)

        // Menyiapkan fungsi klik tombol "Cek"
        checkButton.setOnClickListener {
            // Mengecek jawaban yang dipilih dan memberikan umpan balik
            checkAnswer()
        }
    }

    /**
     * Menampilkan soal dan opsi jawaban yang sesuai dengan indeks soal yang diberikan.
     *
     * @param questionIndex Indeks soal yang ingin ditampilkan.
     */
    fun showQuestion(questionIndex: Int) {
        // Mencegah penggunaan fungsi ini sebelum views diinisialisasi
        if (!::questionText.isInitialized || !::radioGroup.isInitialized) {
            Log.e("AnswerFragment", "Views belum diinisialisasi. showQuestion() dipanggil terlalu awal.")
            return
        }

        // Memastikan indeks soal valid
        currentQuestionIndex = questionIndex
        // Mendapatkan instance MainActivity untuk mengakses daftar soal
        val mainActivity = activity as? MainActivity
        // Memastikan MainActivity tidak null
        if (mainActivity == null) {
            // Jika MainActivity tidak ditemukan, tampilkan pesan kesalahan
            questionText.text = "Error: Tidak dapat memuat soal."
            // Hapus semua RadioButton dari RadioGroup
            radioGroup.removeAllViews()
            return
        }

        // Mendapatkan daftar soal dari MainActivity
        val questions = mainActivity.getQuestions()
        // Memastikan indeks soal berada dalam rentang yang valid
        if (questionIndex < 0 || questionIndex >= questions.size) {
            // Jika indeks tidak valid, tampilkan pesan kesalahan
            questionText.text = "Error: Soal tidak ditemukan."
            // Hapus semua RadioButton dari RadioGroup
            radioGroup.removeAllViews()
            return
        }

        // Mengatur teks soal dan mengisi RadioGroup dengan opsi jawaban
        val question = questions[questionIndex]
        questionText.text = question.text
        radioGroup.removeAllViews()
        // Mengisi RadioGroup dengan opsi jawaban dari soal
        question.options.forEachIndexed { index, option ->
            val radioButton = RadioButton(requireContext()).apply {
                // Mengatur teks dan ID untuk setiap RadioButton
                text = option
                id = index
                // Mengatur layout params untuk RadioButton
                layoutParams = RadioGroup.LayoutParams(
                    RadioGroup.LayoutParams.MATCH_PARENT,
                    RadioGroup.LayoutParams.WRAP_CONTENT
                ).apply { setMargins(0, 8, 0, 8) }
            }
            // Menambahkan RadioButton ke RadioGroup
            radioGroup.addView(radioButton)
        }
        // Menghapus pilihan yang ada sebelumnya
        radioGroup.clearCheck()
    }

    /**
     * Fungsi untuk mengecek jawaban yang dipilih dan memberikan umpan balik.
     */
    private fun checkAnswer() {
        // Mendapatkan ID RadioButton yang dipilih
        val selectedRadioButtonId = radioGroup.checkedRadioButtonId

        if (selectedRadioButtonId == -1) {
            // Jika tidak ada opsi yang dipilih, maka kembali dari fungsi
            return
        }

        // Mendapatkan instance dari MainActivity melalui activity
        val quizInterface = activity as? QuizInterface
        // Memanggil fungsi onAnswerCheck pada QuizInterface
        quizInterface?.onAnswerCheck(currentQuestionIndex, selectedRadioButtonId)
    }
}