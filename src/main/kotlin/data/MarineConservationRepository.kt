package org.greencode.data

import org.greencode.domain.MarineConservation

class MarineConservationRepository(private val db: InMemoryDatabase) : RepositoryBase<MarineConservation> {
    override fun getAll(): List<MarineConservation> {
        val result = mutableListOf<MarineConservation>()
        if (db.marineConservations.size == 0) {
            return result
        }

        db.marineConservations.forEach { result.add(it) }
        return result
    }

    override fun getById(id: Int): MarineConservation? {
        try {
            return db.marineConservations.first { it.id == id }
        } catch (e: NoSuchElementException) {
            println("O elemento com id $id não foi encontrado.")
            return null
        }
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }

    override fun save(t: MarineConservation) {
        db.marineConservations.add(t)
    }
}