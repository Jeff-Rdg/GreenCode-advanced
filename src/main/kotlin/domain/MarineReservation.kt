package org.greencode.domain

import org.greencode.enums.EnvironmentalType
import org.greencode.enums.ReservationType
import org.greencode.input.MarineConservationInput

class MarineReservation(name: String, environmentalType: EnvironmentalType, protectedArea: Double,
                        hasMonitoringProgram: Boolean, qualityWater: Int, coralCover: Int,
                        populationSpeciesExtinction: Int, biodiversity: Int, monitoringLevel: Int,
                        var reservationType: ReservationType, protectedAreaIndex: Int) : MarineConservation(name, environmentalType,
                        protectedArea, hasMonitoringProgram, qualityWater, coralCover, populationSpeciesExtinction,
                        biodiversity, monitoringLevel, protectedAreaIndex) {

                            constructor(input: MarineConservationInput, reservationType: ReservationType) : this(input.name, input.environmentalType, input.protectedArea,
                                input.hasMonitoringProgram, input.qualityWater, input.coralCover, input.populationSpeciesExtinction,
                                input.biodiversity, input.monitoringLevel, reservationType, input.protectedAreaIndex)

    override fun toString(): String {
        return super.toString().plus("Tipo de reserva: $reservationType\n")
    }
}