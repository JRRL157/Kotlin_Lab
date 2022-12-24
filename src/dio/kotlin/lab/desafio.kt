package src.dio.kotlin.lab

import src.dio.kotlin.lab.model.*

fun main() {
    val ce1 = ConteudoEducacional("Introdução à Machine Learning",60, Nivel.INTERMEDIARIO,300)
    val ce2 = ConteudoEducacional("Regressão com múltiplas variáveis",90, Nivel.DIFICIL,500)
    val ce3 = ConteudoEducacional("Classificação",120, Nivel.DIFICIL,900)

    val listaConteudoEducacional = listOf(ce1,ce2,ce3)
    val machineLearning = Formacao("Machine Learning", Nivel.DIFICIL,listaConteudoEducacional)

    val aluno1 = Usuario("Ryu","ryu6874@gmail.com", Educacao.ENSINO_SUPERIOR)
    val aluno2 = Usuario("Ken","ken15778@gmail.com", Educacao.ENSINO_SUPERIOR)
    val aluno3 = Usuario("Chun Li","chunli875@gmail.com", Educacao.POS_GRADUACAO)

    /* INÍCIO DAS SIMULAÇÔES */

    machineLearning.matricular(aluno1)
    machineLearning.matricular(aluno2)
    machineLearning.matricular(aluno3)
    println(machineLearning.inscritos.toString())

    /* Simulação com o Ryu */

    machineLearning.finalizarConteudoEducacional(ce1,aluno1)
    println(aluno1.experiencia)
    machineLearning.finalizarConteudoEducacional(ce2,aluno1)
    machineLearning.finalizarConteudoEducacional(ce3,aluno1)
    println(aluno1.experiencia);
    println(aluno1.conteudoCompleto.toString())
    println(aluno1.formacaoCompleta.toString()) // Nulo, pois o aluno ainda não gerou o certificado da formação

    machineLearning.finalizouFormacao(aluno1)
    println(aluno1.formacaoCompleta.toString())

    /* Simulação com a Chun Li */
    machineLearning.finalizarConteudoEducacional(ce2,aluno2)
    machineLearning.finalizarConteudoEducacional(ce1,aluno2)
    machineLearning.finalizarConteudoEducacional(ce3,aluno2) //Finalizou os conteúdos em uma ordem diferente
    println(aluno2.experiencia)
    println(aluno2.conteudoCompleto.toString())
    println(aluno2.formacaoCompleta.toString())

    /* Simulação com o Ken */
    machineLearning.finalizarConteudoEducacional(ce1,aluno3)
    machineLearning.finalizarConteudoEducacional(ce2,aluno3)
    machineLearning.finalizouFormacao(aluno3) //Tentou finalizar a Formação sem finalizar um conteúdo educacional

    println(machineLearning.inscritosFinalizaram.toString()) //Apenas Ryu e Chun Li finalizaram
}
