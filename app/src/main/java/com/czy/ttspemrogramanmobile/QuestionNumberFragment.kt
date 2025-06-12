package com.czy.ttspemrogramanmobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class QuestionNumberFragment : Fragment() {
    // Fragment ini menampilkan daftar nomor soal yang dapat dipilih
    private lateinit var containerLayout: LinearLayout
    private var selectedQuestionIndex = 0

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
        return inflater.inflate(R.layout.fragment_question_numbers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Membuatkan variabel untuk menampung wadah yang berisi nomor soal
        containerLayout = view.findViewById(R.id.question_numbers_container)

        // Menyiapkan button untuk setiap nomor soal
        setupQuestionNumbers()
    }

    /**
     * Menyiapkan button untuk setiap nomor soal yang ada di daftar soal.
     * Saat button di klik, maka akan memanggil fungsi updateAnswerFragment
     * untuk menampilkan soal dan opsi jawaban yang sesuai dengan nomor soal
     * yang diklik.
     */
    private fun setupQuestionNumbers() {
        // Mendapatkan daftar soal dari MainActivity
        val questions = (activity as MainActivity).getQuestions()

        // Membuatkan button untuk setiap nomor soal
        for (i in questions.indices) {
            val button = Button(requireContext()).apply {
                // Mengatur teks untuk setiap button
                text = "Soal ${i + 1}"

                // Mengatur layout params untuk setiap button
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    // Mengatur margin untuk setiap button
                    setMargins(0, 0, 0, 16)
                }

                // Menambahkan event listener untuk setiap button
                setOnClickListener {
                    // Memanggil fungsi untuk memilih nomor soal yang diklik
                    selectQuestion(i)

                    // Memanggil fungsi untuk menampilkan soal dan opsi jawaban
                    // yang sesuai dengan nomor soal yang diklik
                    updateAnswerFragment(i)
                }
            }

            // Menambahkan button ke dalam container layout
            containerLayout.addView(button)
        }

        // Memilih nomor soal pertama secara default
        selectQuestion(0)

        // Menampilkan soal dan opsi jawaban yang sesuai dengan nomor soal
        // yang dipilih
        updateAnswerFragment(0)
    }

    /**
     * Memilih nomor soal yang sesuai dengan indeks yang diberikan.
     * Fungsi ini akan mengatur status selected untuk setiap button
     * yang ada di dalam container layout.
     *
     * @param index Indeks nomor soal yang ingin dipilih.
     */
    private fun selectQuestion(index: Int) {
        // Mengatur nilai variabel selectedQuestionIndex
        selectedQuestionIndex = index

        // Membuatkan loop untuk setiap button yang ada di dalam container layout
        for (i in 0 until containerLayout.childCount) {
            // Mendapatkan button yang sesuai dengan indeks yang diberikan
            val button = containerLayout.getChildAt(i) as Button

            // Mengatur status selected untuk setiap button
            button.isSelected = (i == index)
        }
    }

    /**
     * Menampilkan soal dan opsi jawaban yang sesuai dengan indeks soal yang diberikan.
     * Fungsi ini akan memanggil fungsi showQuestion di AnswerFragment untuk menampilkan
     * soal dan opsi jawaban yang sesuai dengan indeks soal yang diberikan.
     *
     * @param questionIndex Indeks soal yang ingin ditampilkan.
     */
    private fun updateAnswerFragment(questionIndex: Int) {
        // Mendapatkan instance AnswerFragment yang ada di dalam activity
        val answerFragment = activity?.supportFragmentManager
            ?.findFragmentById(R.id.fragment_answers) as? AnswerFragment

        // Memanggil fungsi showQuestion di AnswerFragment untuk menampilkan
        // soal dan opsi jawaban yang sesuai dengan indeks soal yang diberikan
        answerFragment?.showQuestion(questionIndex)
    }
}