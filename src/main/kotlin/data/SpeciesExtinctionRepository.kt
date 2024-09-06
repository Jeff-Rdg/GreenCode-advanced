package org.greencode.data

import org.greencode.domain.SpeciesExtinction

class SpeciesExtinctionRepository(private val db: InMemoryDatabase) : RepositoryBase<SpeciesExtinction> {
    override fun getAll(): List<SpeciesExtinction> {
        val result = mutableListOf<SpeciesExtinction>()
        if (db.speciesExtinctions.size == 0) {
            return result
        }

        db.speciesExtinctions.forEach { result.add(it) }
        return result
    }

    override fun getById(id: Int): SpeciesExtinction? {
        try {
            return db.speciesExtinctions.first { it.id == id }
        } catch (e: NoSuchElementException) {
            println("O elemento com id $id não foi encontrado.")
            return null
        }
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }

    override fun save(t: SpeciesExtinction) {
        db.speciesExtinctions.add(t)
    }
}