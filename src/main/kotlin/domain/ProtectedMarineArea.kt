package org.greencode.domain

import org.greencode.enums.EnvironmentalType
import org.greencode.input.MarineConservationInput

class ProtectedMarineArea(name: String, environmentalType: EnvironmentalType, protectedArea: Double,
                          hasMonitoringProgram: Boolean, qualityWater: Int, coralCover: Int,
                          populationSpeciesExtinction: Int, biodiversity: Int, monitoringLevel: Int, protectedAreaIndex: Int
                          ) : MarineConservation(name, environmentalType, protectedArea, hasMonitoringProgram,
                          qualityWater, coralCover, populationSpeciesExtinction, biodiversity, monitoringLevel, protectedAreaIndex) {

    constructor(input: MarineConservationInput) : this(input.name, input.environmentalType, input.protectedArea,
        input.hasMonitoringProgram, input.qualityWater, input.coralCover, input.populationSpeciesExtinction,
        input.biodiversity, input.monitoringLevel, input.protectedAreaIndex)
                          }