package com.example.pruebatecnia_repo

import kotlin.math.pow
import kotlin.math.sign

private fun lCalFact(valFact: Int, fnLambda:(Int) -> Long ):Long{
    return fnLambda(valFact)
}
fun main(args:Array<String>){

    var Seleccion:Int?
    println("Escoge una opción" +
            "\n1: Factorial de un número." +
            "\n2: Enunciado espejo." +
            "\n3: Pirámide." +
            "\n4: Cuenta dígitos."+
            "\nIngrese su selección: ")
    var ingres: String? = readLine()
    when{
        ingres == null -> println("Se detecto un EOF.")
        ingres.isEmpty() -> println("NO se ingreso ningun dato.")
        else->
        {
            Seleccion = ingres.toIntOrNull()
            if(Seleccion != null){
                when{
                    Seleccion==1 -> ingresoFactorial()
                    Seleccion==2 -> enunciadoEspejo()
                    Seleccion==3 -> piramide()
                    Seleccion==4 -> cuentaDigitos()
                    else ->{
                        println("Valor ingresado no valido.")
                    }
                }
            }
        }
    }

}
//Funcion encargada de Prueba 1 Factorial
fun ingresoFactorial(){
    var factIngr:Int?
    println("Calculo del Factorial de un número")
    print("Ingresa un número para calcular su factorial: ")
    var sIngr:String? = readLine()

    when{
        sIngr == null -> println("Se detecto un EOF.")
        sIngr.isEmpty() -> println("No ingresaste ningun tipo de valor.")
        else -> {
            factIngr = sIngr.toIntOrNull()
            if (factIngr != null) {
                if(factIngr >= 0) {
                    println("El número ingresado es $factIngr, el resultado es: $factIngr! = ${lCalFact(factIngr){ valFact ->
                        var rFact: Long =1
                        if(valFact != 0){
                            for(i in 1 .. valFact){
                                rFact *= i.toLong()
                            }
                        }
                        rFact
                    }
                    }")
                }else if(factIngr < 0){
                    println("Factorial preve números enteros positivos, no negativos")
                }
            }else if(factIngr == null){
                println("El valor ingresado no es valido.")
            }
        }

    }

}
//Funcion encargada de Prueba 1 Caracteres Espejo
fun enunciadoEspejo(){
    val lAbc: List<String> = "abcdefghijklmnopqrstuvwxyz".split("").subList(1,27)
    var iSeleAbc:Int=0
    var sResult:String = ""
    var regComp = Regex("[a-z]+")
    println("Enunciado Espejo")
    println("Escoja la letra de la que desea conocer su espejo, de la siguiente lista.")
    println("${lAbc.toList()} con un tamaño de ${lAbc.size} caracteres.")
    var sSelect: String? = readLine()
    when{
        sSelect == null -> print("Se detecto un EOF.")
        sSelect.isEmpty() -> println("NO escogio ningun valor.")
        else ->{
            if(regComp.matches(sSelect)){
                iSeleAbc = lAbc.indexOf(sSelect)
                if(iSeleAbc >= 0){
                    sResult += lAbc[(lAbc.size - iSeleAbc)-1]
                }
                println("Valor ingresado '$sSelect' su espejo es: '$sResult'")
            }else{
                println("valor no valido.")
            }
        }
    }

}
//Funcion encargada de Prueba 3 Piramide
fun piramide(){
    var dColecta:Double
    var dPrecio:Double
    var dLatasPisos:Double = 0.0
    var dContador:Double=0.0

    var regComp = Regex("[0-9]+")
    println("Piramide de latas")
    print("Favor de asignar el monto maximo de la colecta: ")
    var sColecta:String? = readLine()
    print("\nFavor de asignar el precio de la lata: ")
    var sPrecio:String? = readLine()
    when{
        sColecta == null -> print("Se detecto un EOF.")
        sPrecio == null -> print("Se detecto un EOF.")
        sColecta.isEmpty() -> println("NO escogio ningun valor.")
        sPrecio.isEmpty() -> println("NO escogio ningun valor.")
        else ->{
            if(regComp.matches(sColecta.toInt().toString()) && regComp.matches(sPrecio.toInt().toString())){
                dColecta = sColecta.toDouble()
                dPrecio = sPrecio.toDouble()

                var dLatas:Double = dColecta/dPrecio
                println("El número de latas es: ${dLatas.toInt()}")

                do{
                    ++dContador
                    dLatasPisos += Math.pow(dContador,2.0)
                }while (dLatas >= dLatasPisos)
                println("El número de colecta fue: $$dColecta," +
                        "\nEl precio de la lata fue: $$dPrecio,"+
                        "\nEl número de pisos de la piramide son: ${dContador.toInt()-1}")
            }else{
                println("Valor no valido")
            }
        }
    }
}
//Funcion encargada de Prueba 4 Cuanta Digitos
fun cuentaDigitos(){
    var iOcurrencia:Int=0
    var sComv:String
    //var lIntDig: Array<Int> = arrayOf(-18, -31, 81, -19, 111, -888)
    var lIntDig: Array<Int> = arrayOf(50, 444, 81, 34, 114, -888,556)
    var lIntBusq: Array<Int> = arrayOf(1, 8, 4,5)

    println("Cuenta Digitos")
    print("Se calculara la ocurrencia de los valores asignados")
    println("Valores ${lIntDig.toList()}" +
            "\nBusqueda ${lIntBusq.toList()}")

    for(element in lIntBusq){
        for(element2 in lIntDig){
            sComv = element2.toString()
            for(i in sComv.indices){
                if(sComv[i].toString() == element.toString()) iOcurrencia++
            }
        }
        println("Ocurrencia de [${element}][${iOcurrencia}].")
        iOcurrencia = 0
    }
}