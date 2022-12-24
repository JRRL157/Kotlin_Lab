package src.dio.kotlin.lab.model

data class Usuario(val nome: String, val email : String, val educacao : Educacao){
    var conteudoCompleto = mutableListOf<ConteudoEducacional>()
    var formacaoCompleta = mutableListOf<Formacao>()
    var experiencia : Int = 0

    fun addConteudo(conteudo : ConteudoEducacional) : Boolean {
        if(!conteudoCompleto.contains(conteudo)){
            experiencia += conteudo.XP;
            return conteudoCompleto.add(conteudo)
        }
        return false
    }

    fun addFormacao(formacao : Formacao) : Boolean {
        if(!formacaoCompleta.contains(formacao))
            return formacaoCompleta.add(formacao)
        
        return false
    }
}