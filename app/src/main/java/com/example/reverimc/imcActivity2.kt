package com.example.reverimc

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.getSystemService

class imcActivity2 : AppCompatActivity() {

    private lateinit var editWeight: EditText
    private lateinit var editHeight: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc2)

        editWeight = findViewById(R.id.edi_campo1)
        editHeight = findViewById(R.id.edi_campo2)
        val btn_click: Button = findViewById(R.id.Btn_Cal)

        btn_click.setOnClickListener {

            if (!validate()) {
                Toast.makeText(this, "Digite um número", Toast.LENGTH_SHORT).show()

                return@setOnClickListener
            }

            val weight = editWeight.text.toString().toInt()
            val height = editHeight.text.toString().toInt()

            val resul = calImc(weight, height)
//            Log.i("testando", "resultado $resul")

            val situacao = InfoResul(resul)

            //Aqui para usar poups na tela
                 AlertDialog.Builder(this)
               .setTitle(getString(R.string.imcmens,resul))
               .setMessage(situacao)
                .setPositiveButton(android.R.string.ok) {  dialog, which ->

                }
                    .create()
                    .show()

            //Aqui vc esconde o teclado padrão
            val service =getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
              service.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
         }


    }
    //função paravalidar se os campos estão vazios e se o número não é zero

    private fun validate(): Boolean {

        return (editWeight.text.toString().isNotEmpty()
                && editHeight.text.toString().isNotEmpty()
                && !editWeight.text.startsWith("0")
                && !editHeight.text.startsWith("0"))

    }
    //Função pra ver realizar a operação

    private fun calImc(weight: Int, height: Int): Double {

        return weight / ((height / 100.0) * (height / 100.0))




}
    private fun InfoResul(imc:Double) :Int {


        when {
            imc < 17.0 ->return R.string.muito_abaix_do_peso
            imc < 18.0 ->return R.string.abaix_do_peso
            imc < 25.0 ->return R.string.peso_normal
            imc < 30.0 ->return R.string.acima_do_peso
            imc < 35.0 ->return R.string.obesidade_1
            imc < 40.0 ->return R.string.obesidade_2
            else -> return R.string.obesidade_MÓBIDA
        }


    }
}