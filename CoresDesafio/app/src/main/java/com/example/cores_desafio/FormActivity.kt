package com.example.cores_desafio

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Toast
import com.example.cores_desafio.model.Cor

class FormActivity : AppCompatActivity() {
    private lateinit var nomeCor: EditText
    private lateinit var corRed: SeekBar
    private lateinit var corGreen: SeekBar
    private lateinit var corBlue: SeekBar
    private lateinit var btCor: Button
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button
    private var codigoRgb: Int = 0
    private var codigoHexa: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.nomeCor = findViewById(R.id.etCor)
        this.corRed = findViewById(R.id.seekBarRed)
        this.corGreen = findViewById(R.id.seekBarGreen)
        this.corBlue = findViewById(R.id.seekBarBlue)
        this.btCor = findViewById(R.id.btCor)
        this.btSalvar = findViewById(R.id.btSalvar)
        this.btCancelar = findViewById(R.id.btCancelar)


        val cod = Color.rgb(corRed.progress, corGreen.progress, corBlue.progress)
        updateColorButton(cod)
        this.btCor.setText(codigoHexa)

        if (intent.hasExtra("COR")) {
            val cor = intent.getSerializableExtra("COR") as Cor
            this.nomeCor.setText(cor.nome)
            this.btCor.setText(codigoHexa)
            this.btSalvar.text = "Atualizar"
        } else {
        }

        this.corRed.setOnSeekBarChangeListener(ChangeSeekbar())
        this.corGreen.setOnSeekBarChangeListener(ChangeSeekbar())
        this.corBlue.setOnSeekBarChangeListener(ChangeSeekbar())

        this.btSalvar.setOnClickListener({ salvar(it) })
        this.btCancelar.setOnClickListener({ cancelar(it) })
        this.btCor.setOnClickListener({ copiarCodigo(it) })

    }

    private fun salvar(view: View) {
        val nome = this.nomeCor.text.toString()
//          Log.i("RED",codRed.toString())
//        Log.i("GREEN",codGreen.toString())
//        Log.i("BLUE",codBlue.toString())
//        Log.i("JUNTOS",color.toString())

        val cor = if (intent.hasExtra("COR")) {
            val c = intent.getSerializableExtra("COR") as Cor
            c.nome = nome
            c.codigo = codigoRgb
            c
        } else {
            Cor(nome, codigoRgb)
        }

        val intent = Intent()
        intent.putExtra("COR", cor)
        setResult(Activity.RESULT_OK, intent)
        finish()

    }

    private fun copiarCodigo(view: View) {
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip: ClipData = ClipData.newPlainText("Código hex da cor ", codigoHexa)
        clipboard.setPrimaryClip(clip)
        Toast.makeText(this, "Código copiado!", Toast.LENGTH_SHORT).show()

    }

    inner class ChangeSeekbar : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            val codRed = corRed.progress
            val codGreen = corGreen.progress
            val codBlue = corBlue.progress
            val color = Color.rgb(codRed, codGreen, codBlue)
            updateColorButton(color)

        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {
        }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {
        }

    }

    fun updateColorButton(colorButton: Int) {
        this.btCor.setBackgroundColor(colorButton)
        this.codigoRgb = colorButton
        val codHex = String.format("#%06X", (0xFFFFFF and colorButton))
        this.btCor.setText(codHex)
        this.codigoHexa = codHex

    }

    private fun cancelar(view: View) {
        finish()
    }
}