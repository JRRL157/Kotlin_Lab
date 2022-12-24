package src.dio.kotlin.lab.model

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {

    var inscritos = mutableListOf<Usuario>()
    var inscritosFinalizaram = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) : Boolean {
        if(!inscritosFinalizaram.contains(usuario))
            return inscritos.add(usuario)    
        return false;
    }

    fun finalizarConteudoEducacional(ce : ConteudoEducacional, usuario: Usuario) : Boolean {
        if(inscritos.contains(usuario))
            return usuario.addConteudo(ce)
        return false;
    }

    fun finalizouFormacao(usuario : Usuario) : Boolean {
        val completouFormacao = usuario.conteudoCompleto.stream().allMatch({conteudo : ConteudoEducacional ->
            conteudos.contains(conteudo)})

        if(completouFormacao){            
            return inscritosFinalizaram.add(usuario) && usuario.addFormacao(this)
        }
        return false
    }
}