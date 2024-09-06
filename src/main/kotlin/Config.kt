package org.greencode

import org.greencode.data.InMemoryDatabase
import org.greencode.data.MarineConservationRepository
import org.greencode.data.SpeciesExtinctionRepository
import org.greencode.domain.MarineConservation
import org.greencode.domain.MarineReservation
import org.greencode.domain.ProtectedMarineArea
import org.greencode.domain.SpeciesExtinction
import org.greencode.enums.EnvironmentalType
import org.greencode.enums.ReservationType
import org.greencode.input.MarineConservationInput

class Config {
    private val db = InMemoryDatabase()
    private val marineConservationRepository = MarineConservationRepository(db)
    private val speciesExtinctionRepository = SpeciesExtinctionRepository(db)

    fun menu() {
        try {
            println("\nInforme o serviço que deseja realizar:")
            servicesAvailable()

            var input = readln().toInt()

            while (input < 0 || input > 4) {
                println("Valor [$input] inválido, tente novamente.")
                servicesAvailable()
                input = readln().toInt()
            }

            when (input) {
                1 -> newMarineConservation()
                2 -> {
                    println(marineConservationRepository.getAll())
                    return menu()
                }
                3 -> newSpecieExtinction()
                4 -> {
                    println(speciesExtinctionRepository.getAll())
                    return menu()
                }
                0 -> println("Até mais!")
            }


        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun servicesAvailable() {
        println("[1] Cadastrar uma área de conservação marinha.")
        println("[2] Listar as áreas de conservação marinha.")
        println("[3] Cadastrar especies em extinção.")
        println("[4] Listar especies em extinção.")
        println("[0] Sair.")
    }

    private fun newSpecieExtinction() {
        println("informe o nome cientifico: ")
        val cientificName = readln()

        println("informe o nome popular: ")
        val popularName = readln()

        val specieExtinction = SpeciesExtinction(cientificName, popularName)
        speciesExtinctionRepository.save(specieExtinction)

        println("Especie em extinção cadastrada com sucesso!")
        menu()
    }

    private fun newMarineConservation() {
        println("informe o nome: ")
        val name = readln()

        println("Informe o tipo de ambiente:")
        EnvironmentalType.printListEnv()
        val env = EnvironmentalType.selectedEnv()

        println("Informe a área de proteção ambiental em Km²:")
        val protectedArea = readln().toDouble()

        println("possui programa de monitoramento? (y/n)")
        val hasMonitoringProgram = selectBooleanOption()

        println("Os seguintes itens fazem parte do Indice de Eficiência de conservação marinha, \n" +
                "para o calculo, é necessário informar em escala de 0 a 100, Isso permite que cada indicador seja \n" +
                "comparável e contribua proporcionalmente para o índice geral. \n")

        println("Informe o indice de qualidade da água: (0 a 100)")
        val qualityWater = selectIndice()

        println("Informe o indice de cobertura de coral: (0 a 100)")
        val coralCover = selectIndice()

        println("Existem especies em extinção? (y/n)")
        val option = selectBooleanOption()
        var populationSpeciesExtinction = 0

        if (option) {
            println("Informe o indice de População de Espécies em Extinção: (0 a 100)")
            populationSpeciesExtinction = selectIndice()
        }

        println("Informe o indice de Biodiversidade: (0 a 100)")
        val biodiversity = selectIndice()

        println("Informe o indice de Nível de Monitoramento: (0 a 100)")
        val monitoringLevel = selectIndice()

        println("Informe o indice de área protegida: (0 a 100)")
        val protectedAreaIndex = selectIndice()

        println("Informe o tipo de conservação marinha:")
        println("[1] Reserva marinha.")
        println("[2] Área de Proteção marinha.")

        val input = MarineConservationInput(name, env, protectedArea, hasMonitoringProgram,
            qualityWater, coralCover, populationSpeciesExtinction, biodiversity, monitoringLevel, protectedAreaIndex)

        val marineConservation = chosenMarineConservation(input)

        marineConservationRepository.save(marineConservation)

        println("Área de conservação marinha cadastrada com sucesso!")
        menu()
    }

    private fun chosenMarineConservation(input: MarineConservationInput ): MarineConservation {
        var option = readln().toInt()
        while (option != 1 && option != 2) {
            println("opção $option inválida, tente novamente:")
            option = readln().toInt()
        }

        when(option) {
            1 -> {
                println("Informe o tipo de reservação marinha:")
                ReservationType.printList()
                val type = ReservationType.selectedType()

                return MarineReservation(input, type)
            }
            2 -> return ProtectedMarineArea(input)
            else -> {
                throw IllegalArgumentException("Invalid option")
            }
        }

    }

    private fun selectBooleanOption() : Boolean {
        var booleanOption = readln().lowercase()
        while (booleanOption != "y" && booleanOption != "n") {
            println("opção $booleanOption inválida, tente novamente:")
            booleanOption = readln().lowercase()
        }

        return booleanOption == "y"
    }

    private fun selectIndice() : Int {
        var option = readln().toInt()
        while (option > 100 || option < 0) {
            println("opção $option inválida, tente novamente:")
            option = readln().toInt()
        }

        return option
    }
}