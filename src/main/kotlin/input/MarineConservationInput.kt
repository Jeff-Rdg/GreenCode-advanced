package org.greencode.input

import org.greencode.enums.EnvironmentalType

class MarineConservationInput(var name: String, var environmentalType: EnvironmentalType, var protectedArea: Double,
                              var hasMonitoringProgram: Boolean, var qualityWater: Int, var coralCover: Int,
                              var populationSpeciesExtinction: Int, var biodiversity: Int ,
                              var monitoringLevel: Int , var protectedAreaIndex: Int) {
}