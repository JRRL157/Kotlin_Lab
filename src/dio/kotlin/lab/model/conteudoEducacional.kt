package src.dio.kotlin.lab.model

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel : Nivel = Nivel.BASICO, val XP : Int = 100)