enum class Nivel { INICIANTE, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val id: Long)

data class ConteudoEducacional(val nome: String, val stack: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    infix fun matricular(usuario: Usuario) { 
        inscritos.add(usuario) 
    }
    
     fun matricular(vararg usuarios: Usuario){
        for(usuario in usuarios)
            inscritos.add(usuario)
    }

    fun mostrarConteudos(){
        for(conteudo in conteudos)
            println(conteudo.nome)
    }

    fun mostrarInscritos(){
        for(inscrito in inscritos)
            println(inscrito.nome)
    }
}

fun main() {
     // Criação dos usuários
    val karina = Usuario("Karina", 1)
    val matheus = Usuario("Matheus", 2)
    val lucas = Usuario("Lucas", 3)
    val celia = Usuario("Celia", 4)

    // Criação da lista de conteúdos educadional
    val listaConteudosKotlin: List<ConteudoEducacional> = listOf(
        ConteudoEducacional("Conhecendo Kotlin","Kotlin"),
        ConteudoEducacional("Linguagem de Programação Kotlin","Kotlin"),
        ConteudoEducacional("Estruturas de Controles de Fluxos e Coleções","Kotlin"),
    	ConteudoEducacional("Orientação a Objetos e Tipos de Classes"," Kotlin"))

    // Criando a formação para Kotlin
    val kotlinBootcamp = Formacao("Kotlin Bootcamp", listaConteudosKotlin, Nivel.INICIANTE)

    // Matriculando alunos Matriculando os alunos caso a variavel não seja nula
    kotlinBootcamp?.let{
        kotlinBootcamp.matricular(karina, matheus, lucas, celia)
    }

    // Imprimindo na tela
    println("Formação: ${kotlinBootcamp.nome}\n\t\tConteúdos:")
    kotlinBootcamp.mostrarConteudos()
    println("\t\tInscritos:")
    kotlinBootcamp.mostrarInscritos()
}
    
    
    