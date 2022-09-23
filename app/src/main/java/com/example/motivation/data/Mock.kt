package com.example.motivation.data

import com.example.motivation.infra.MotivationConstants
import kotlin.random.Random

class Phrase(val description: String, val category: Int)


class Mock {

    val all = MotivationConstants.FILTER.ALL
    val sunny = MotivationConstants.FILTER.SUNNY
    val happy = MotivationConstants.FILTER.HAPPY

    private val listPhrases = listOf<Phrase>(
        Phrase("Gordo, quando está fazendo dieta, sempre faz a barba antes de se pesar.", happy),
        Phrase("Não fique chateado se você passar a vida inteira gordo. Você terá toda a eternidade para ser só osso!", happy),
        Phrase("Na Idade Média, os mais belos eram os mais gordos. Na Idade Contemporânea, o oposto. Em que época o interior se tornará a beleza extrema?", happy),
        Phrase("Namore com alguém que coma com você e não alguém que reclame que você está comendo.", happy),
        Phrase("Que nesta madrugada de Natal, o gordinho que entrou na janela da sua casa tenha vindo de trenó e não de Saveiro.", happy),
        Phrase("Estou gordo porque seria injusto com as outras pessoas se eu fosse bonito, divertido, inteligente e ainda por cima magro.", happy),
        Phrase("Maior incentivo para a minha locomoção:”vai ter comida”.", happy),
        Phrase("A única coisa que vai pra frente na sua vida, é a sua barriga!”.", happy),
        Phrase("De todas as coisas que a vida me deu, só gostaria de devolver uns 10kg que vieram por engano.”.", happy),
        Phrase("Não deixe para amanhã o que você pode comer hoje, pois amanhã pode não estar mais na geladeira!”.", happy),

        Phrase("Em breve teremos que caçar para comer e eu nem sei onde vivem as lasanhas", sunny),
        Phrase("Subi na balança hoje e apareceu o numero do meu CPF!", sunny),
        Phrase("Falar de mim é fácil, quero ver vestir 36.", sunny),
        Phrase("O lado bom de ser gordo? Nenhum, bola não tem lado.", sunny),
        Phrase("Minha barriga não é definida, porque quem se define se limita.", sunny),
        Phrase("Hoje começo a dieta da sopa. Vou comer tudo o que estiver dando sopa na geladeira e na mesa.", sunny),
        Phrase("Eu até tinha um lado doce, mas acabei comendo ele.", sunny),
        Phrase("Se você acredita, faz toda a diferença.", sunny),
        Phrase("Amizade entre homem e mulher é igual a gordo perto do bacon, se der mole ele come.", sunny),
        Phrase("O cara era tão gordo, mas tão gordo, que a bunda dele parecia um provolone enrolado na corda.", sunny),
        Phrase("Um dia um moleque na escola me chamou de gordo. Coloquei ele dentro de um pão e comi.", sunny),
        Phrase("Coma tudo que você quiser, e se alguém vier te dar sermão sobre o seu peso, coma essa pessoa também.", sunny),
        Phrase("Eu gosto tanto de comida, que meu super herói favorito é o super mercado.", sunny),
        Phrase("Minha mãe me deu tanto biotônico fontoura quando eu era criança pra abrir o apetitite que hoje ele não fecha mais.", sunny),
        Phrase("Praia é igual balança, sempre que você pisa nela, sente vontade de emagrecer.", sunny),
        Phrase("No restaurante a quilo, dá pra medir a maturidade de uma pessoa pela quantidade de batata frita que ela põe no prato", sunny)
    )

    // Obtém frase aleatória de acordo com o filtro
    fun getPhrase(value: Int): String {
        val filtered = listPhrases.filter { (it.category == value || value == all) }

        // Número aleatório de 0 ao tamanho da lista retornada do filtro
        val rand = Random.nextInt(filtered.size)

        // Retorna string
        return filtered[rand].description
    }

}