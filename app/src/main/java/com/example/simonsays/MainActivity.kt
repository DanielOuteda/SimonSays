package com.example.simonsays

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlin.random.Random
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rojo: Button=findViewById(R.id.rojo)
        val azul: Button=findViewById(R.id.azul)
        val amarillo: Button=findViewById(R.id.amarillo)
        val verde: Button=findViewById(R.id.verde)

        val toast1=Toast.makeText(this, "Error", Toast.LENGTH_SHORT)
        val toast2=Toast.makeText(this, "Good", Toast.LENGTH_SHORT)

        val inicio: Button = findViewById(R.id.inicio)
        inicio.setOnClickListener(){

            println("1")
            simonDice(rojo,azul,amarillo,verde,toast2)
            toast1.show()
        }
    }
}

private fun pedirArray2(rojo:Button,azul:Button,amarillo:Button,verde:Button,contador:Int): ArrayList<Int> {

    var array2 = ArrayList<Int>()

    var jugador:Int=0

    rojo.setOnClickListener(){
        jugador=1
        print("Red")
    }
    azul.setOnClickListener(){
        jugador=2
        print("Blue")
    }
    amarillo.setOnClickListener(){
        jugador=3
        print("Yellow")
    }
    verde.setOnClickListener(){
        jugador=4
        print("Green")
    }

    var a: Int=contador
    while (a!=0) {
        a--
        array2.add(jugador)
        println(array2[0])
    }
    return array2
}

private fun mostrarArray1(array1: ArrayList<Int>): ArrayList<Int> {
    array1.add(Random.nextInt(4) + 1)

    for (contador in 0..(array1.size)-1){
        when (array1[contador]){
            1-> {
                println("Red")}
            4-> {
                println("Green")}
            2-> {
                println("Blue")}
            3-> {
                println("Yellow")}
            else->{
                println("Error")
            }
        }
    }
    return array1
}

private fun simonDice(rojo: Button,azul: Button,amarillo: Button,verde: Button,toast: Toast) {
    var array1 = ArrayList<Int>()

    var contador=0
    toast.show()
    do {
        var array2 = ArrayList<Int>()
        contador++
        array1=mostrarArray1(array1)
        array2=pedirArray2(rojo,azul,amarillo,verde,contador)
        println("2")

    }while (array1==array2)
    println("3")

}