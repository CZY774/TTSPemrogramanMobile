# Quiz App Android

Aplikasi quiz sederhana untuk Android yang dibuat menggunakan Kotlin dan Gradle KTS. Aplikasi ini dirancang dengan tampilan horizontal yang menyerupai platform LMS (Learning Management System).

## ✨ Fitur

- **Layout Dual Fragment**: Aplikasi menggunakan 2 fragment dalam layout horizontal
- **Navigasi Soal**: Fragment kiri menampilkan nomor-nomor soal untuk navigasi cepat
- **Interface Quiz**: Fragment kanan menampilkan pertanyaan dan pilihan jawaban menggunakan RadioButton
- **Validasi Jawaban**: Tombol "Cek Jawaban" dengan feedback menggunakan Toast
- **Orientasi Terkunci**: Aplikasi dikunci dalam mode landscape untuk pengalaman optimal
- **Responsive Design**: Layout yang responsif dan user-friendly

## 🛠️ Teknologi yang Digunakan

- **Kotlin** - Bahasa pemrograman utama
- **Android SDK** - Platform development
- **Gradle KTS** - Build system dengan Kotlin DSL
- **Fragment** - Untuk modular UI components
- **Material Design** - Untuk konsistensi UI/UX

## 📋 Persyaratan Sistem

- Android Studio Arctic Fox atau versi terbaru
- Android SDK API level 21 (Android 5.0) atau lebih tinggi
- Gradle 7.0+
- Kotlin 1.8+

## 🚀 Instalasi dan Setup

1. **Clone Repository**
   ```bash
   git clone https://github.com/CZY774/TTSPemrogramanMobile.git
   cd TTSPemrogramanMobile
   ```

2. **Buka di Android Studio**
   - Buka Android Studio
   - Pilih "Open an existing Android Studio project"
   - Navigasi ke folder project dan pilih

3. **Sync Project**
   - Android Studio akan otomatis melakukan sync Gradle
   - Tunggu hingga proses selesai

4. **Run Aplikasi**
   - Pastikan emulator atau device Android sudah terhubung
   - Klik tombol "Run" atau gunakan shortcut `Shift + F10`

## 📁 Struktur Project

```
app/
├── src/main/
│   ├── java/com/czy/ttspemrogramanmobile/
│   │   ├── MainActivity.kt          # Activity utama
│   │   ├── QuestionNumberFragment.kt # Fragment untuk nomor soal
│   │   ├── AnswerFragment.kt        # Fragment untuk soal dan jawaban
│   │   └── Question.kt              # Data class untuk soal
│   ├── res/
│   │   ├── layout/
│   │   │   ├── activity_main.xml
│   │   │   ├── fragment_question_numbers.xml
│   │   │   └── fragment_answers.xml
│   │   ├── values/
│   │   │   ├── colors.xml
│   │   │   └── strings.xml
│   │   └── ...
│   └── AndroidManifest.xml
├── build.gradle.kts                 # App-level build configuration
└── ...
```

## 🎯 Cara Menggunakan

1. **Pilih Soal**: Klik tombol "Soal 1", "Soal 2", atau "Soal 3" di panel kiri
2. **Baca Pertanyaan**: Pertanyaan akan tampil di panel kanan
3. **Pilih Jawaban**: Pilih salah satu opsi jawaban menggunakan radio button
4. **Cek Jawaban**: Klik tombol "Cek Jawaban"
5. **Lihat Hasil**: Toast akan menampilkan "Benar!" atau "Salah!"

## 📝 Menambah Soal Baru

Untuk menambah soal baru, edit method `getQuestions()` di `MainActivity.kt`:

```kotlin
fun getQuestions(): List<Question> {
    return listOf(
        Question(
            "Pertanyaan baru Anda?",
            listOf(
                "Opsi A",
                "Opsi B", 
                "Opsi C",
                "Opsi D"
            ),
            1 // Index jawaban yang benar (0-3)
        ),
        // Tambahkan soal lainnya...
    )
}
```

## 🔧 Konfigurasi

### Orientasi Screen
Aplikasi dikonfigurasi untuk mode landscape di `AndroidManifest.xml`:
```xml
<activity
    android:name=".MainActivity"
    android:screenOrientation="landscape">
```

### Theme dan Colors
Customize warna aplikasi di `res/values/colors.xml`:
```xml
<color name="primary_color">#2196F3</color>
<color name="light_gray">#F5F5F5</color>
```

## <img src="https://media.giphy.com/media/utz68KlKM5LGBVF6HZ/giphy.gif" width="25px" alt="rocket"> Quotes of the day
<div align="center">
  <img src="https://quotes-github-readme.vercel.app/api?type=horizontal&theme=tokyonight" alt="Random Dev Quote" />
</div>
<br/>
<br/>
<div align="center">
  <img src="https://github-readme-streak-stats.herokuapp.com/?user=CZY774&theme=tokyonight&hide_border=true&background=1f1f1f&stroke=58a6ff&ring=58a6ff&fire=58a6ff&currStreakNum=ffffff&sideNums=ffffff&currStreakLabel=58a6ff&sideLabels=58a6ff&dates=ffffff" alt="GitHub Streak" />
</div>

## <img src="https://media.giphy.com/media/hvRJCLFzcasrR4ia7z/giphy.gif" width="25px" alt="waving hand"> Get In Touch
<div align="center">
  <a href="https://www.instagram.com/corneliusyoga" target="_blank"><img src="https://img.shields.io/badge/Instagram-%23E4405F.svg?&style=for-the-badge&logo=instagram&logoColor=white" alt="Instagram"></a>&nbsp;
  <a href="https://www.linkedin.com/in/cornelius-yoga-783b6a291" target="_blank"><img src="https://img.shields.io/badge/LinkedIn-%230077B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn"></a>&nbsp;
  <a href="https://www.youtube.com/channel/UCj0TlW5vLO6r_Nlwc8oFBpw" target="_blank"><img src="https://img.shields.io/badge/YouTube-%23FF0000.svg?&style=for-the-badge&logo=youtube&logoColor=white" alt="YouTube"></a>&nbsp;
  <a href="https://corneliusyoga.vercel.app" target="_blank"><img src="https://img.shields.io/badge/Portfolio-%23000000.svg?&style=for-the-badge&logo=react&logoColor=white" alt="Portfolio"></a>
  <br/><br/>
  <img src="https://komarev.com/ghpvc/?username=CZY774&style=flat-square&color=0366D6" alt="Profile Views" />
  <br/>
  <sub>Made by Cornelius Ardhani Yoga Pratama</sub>
</div>
