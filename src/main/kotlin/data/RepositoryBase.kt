package org.greencode.data

interface RepositoryBase<T> {
    fun getAll(): List<T>
    fun getById(id:Int): T?
    fun save(t: T)
    fun delete(id:Long)
}