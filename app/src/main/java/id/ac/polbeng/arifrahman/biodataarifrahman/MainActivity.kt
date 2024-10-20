package id.ac.polbeng.arifrahman.biodataarifrahman

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import id.ac.polbeng.arifrahman.biodataarifrahman.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonSubmit.setOnClickListener {
            val nama = binding.inputNama.text.toString()
            val nim = binding.inputNim.text.toString()
            val jurusan = binding.inputJurusan.text.toString()
            val prodi = binding.inputProdi.text.toString()
            val kelas = binding.inputKelas.text.toString()
            val nilaiUts = binding.inputNilaiUts.text.toString()
            val nilaiUas = binding.inputNilaiUas.text.toString()
            val noHp = binding.inputNoHp.text.toString()


            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("NAMA", nama)
            intent.putExtra("NIM", nim)
            intent.putExtra("JURUSAN", jurusan)
            intent.putExtra("PRODI", prodi)
            intent.putExtra("KELAS", kelas)
            intent.putExtra("NILAI_UTS", nilaiUts)
            intent.putExtra("NILAI_UAS", nilaiUas)
            intent.putExtra("NO_HP", noHp)
            startActivity(intent)
        }
    }
}
