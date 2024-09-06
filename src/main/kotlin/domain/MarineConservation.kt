package org.greencode.domain

import org.greencode.enums.EnvironmentalType
import org.greencode.utils.format
import java.time.LocalDate


abstract class MarineConservation(var name: String, var environmentalType: EnvironmentalType, var protectedArea: Double,
                                  var hasMonitoringProgram: Boolean = false, var qualityWater: Int = 0, var coralCover: Int = 0,
                                  var populationSpeciesExtinction: Int = 0, var biodiversity: Int = 0,
                                  var monitoringLevel: Int = 0, var protectedAreaIndex: Int) {

    val id: Int = ++idCounter
    val creationDate: LocalDate = LocalDate.now()

    companion object {
        private var idCounter = 0
    }

    private fun calculateEfficiency() : Double {
        val qw = qualityWater * 0.25
        val cc = coralCover * 0.20
        val pse = populationSpeciesExtinction * 0.20
        val bd = biodiversity * 0.15
        val pa = protectedAreaIndex * 0.10
        val ml = monitoringLevel * 0.10

        return qw + cc + pse + bd + pa + ml
    }

    override fun toString(): String {
        return "\n--------------------------------------------------------\n" +
                "Id: $id\n" +
                "Nome: $name\nTipo de ambiente: ${environmentalType}\n" +
                "Área de proteção ambiental(Km²): ${protectedArea}\n" +
                "Existência de programa de monitoramento: ${ if (hasMonitoringProgram) "Sim" else "Não"}\n" +
                "Indice de qualidade da água: $qualityWater\n" +
                "Indice de cobertura de coral: $coralCover\n" +
                "Indice de biodiversidade: $biodiversity\n" +
                "Indice de nivel de monitoramento: $monitoringLevel\n" +
                "Indice de Proteção ambiental: $protectedAreaIndex\n" +
                "Eficiência de conservação: ${calculateEfficiency().format(2)}\n"
    }
}