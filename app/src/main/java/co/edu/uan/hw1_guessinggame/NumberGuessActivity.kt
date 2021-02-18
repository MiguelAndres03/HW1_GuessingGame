package co.edu.uan.hw1_guessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlin.random.Random

class NumberGuessActivity : AppCompatActivity() {
    var nintentos = 0
    var nrandom = crearAleatorio()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_guess)
    }

    fun crearAleatorio(): Int {
        var numaleatorio: Int = Random.nextInt(1,1000)
        return numaleatorio
    }

    fun iniciar(view: View) {
        val numero = findViewById<EditText>(R.id.txtnumber)
        val nroUsuario = Integer.parseInt(numero.getText().toString())
        nintentos = nintentos + 1

        if (nrandom == nroUsuario) {
            Toast.makeText(
                    applicationContext,
                    "Bien hecho!!, numero de intentos: ${nintentos}",
                    Toast.LENGTH_LONG
            ).show()
        } else if (nroUsuario < 1 || nroUsuario > 1000) {
            Toast.makeText(
                    applicationContext,
                    "El numero que ingresaste no es valido",
                    Toast.LENGTH_LONG
            ).show()
        } else if (nrandom > nroUsuario) {
            Toast.makeText(
                    applicationContext,
                    "El número que ingresaste es menor que el numero generado!",
                    Toast.LENGTH_LONG
            ).show()
        } else if (nrandom < nroUsuario) {
            Toast.makeText(
                    applicationContext,
                    "El número que ingresaste es mayor que el numero generado!",
                    Toast.LENGTH_LONG
            ).show()
        }
        numero.setText("")
    }

    fun reiniciar(view: View){
        crearAleatorio()
        Toast.makeText(applicationContext,"Se genero un nuevo numero, intentalo adivinar",Toast.LENGTH_SHORT).show()
    }

}