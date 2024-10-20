package id.ac.polbeng.arifrahman.biodataarifrahman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Ambil data dari Intent
        val nama = intent.getStringExtra("NAMA")
        val nim = intent.getStringExtra("NIM")
        val jurusan = intent.getStringExtra("JURUSAN")
        val prodi = intent.getStringExtra("PRODI")
        val kelas = intent.getStringExtra("KELAS")
        val nilaiUts = intent.getStringExtra("NILAI_UTS")?.toFloatOrNull()
        val nilaiUas = intent.getStringExtra("NILAI_UAS")?.toFloatOrNull()
        val noHp = intent.getStringExtra("NO_HP")

        // Menampilkan data di TextView
        val resultText = findViewById<TextView>(R.id.resultText)
        resultText.text = """
            NIM: $nim
            Nama: $nama
            Jurusan: $jurusan
            Prodi: $prodi
            Kelas: $kelas
            Nilai UTS: ${nilaiUts ?: "N/A"}
            Nilai UAS: ${nilaiUas ?: "N/A"}
            Rata-rata Nilai: ${if (nilaiUts != null && nilaiUas != null) String.format("%.1f", (nilaiUts + nilaiUas) / 2) else "N/A"}
            Nomor HP: $noHp
        """.trimIndent()

        // Hitung status kelulusan dan nilai huruf
        val statusKelulusan = findViewById<TextView>(R.id.lulusResult)
        if (nilaiUts != null && nilaiUas != null) {
            val nilaiAkhir = (nilaiUts + nilaiUas) / 2
            val grade = when {
                nilaiAkhir >= 85 -> "A"
                nilaiAkhir >= 70 -> "B"
                nilaiAkhir >= 60 -> "C"
                nilaiAkhir >= 50 -> "D"
                else -> "E"
            }
            statusKelulusan.text = "Status Kelulusan: ${if (nilaiAkhir >= 60) "Lulus" else "Tidak Lulus"} (Grade: $grade)"
        } else {
            statusKelulusan.text = "Nilai UTS atau UAS tidak valid."
        }

        // Tombol kembali
        val buttonBack = findViewById<Button>(R.id.buttonBack)
        buttonBack.setOnClickListener { finish() }
    }
}
