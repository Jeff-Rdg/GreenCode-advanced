package org.greencode.domain

import org.greencode.utils.format

class SpeciesExtinction(var cientificName: String, var popularName: String) {

    val id: Int = ++idCounter

    companion object {
        private var idCounter = 0
    }

    override fun toString(): String {
        return "\n--------------------------------------------------------\n" +
                "Id: $id\n" +
                "Nome popular: $popularName\nNome cientifico: ${cientificName}\n"
    }

}