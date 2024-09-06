package org.greencode.data

import org.greencode.domain.*

class InMemoryDatabase {
    val marineConservations = mutableListOf<MarineConservation>()
    val speciesExtinctions = mutableListOf<SpeciesExtinction>()
}