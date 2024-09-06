package org.greencode.enums

import org.greencode.enums.EnvironmentalType.*
import java.util.*

enum class ReservationType(val type:String) {
    BIOLOGICALMARINE("reservation.type.biological.marine"),
    MARINENATIONALPARK("reservation.type.marine.national.park"),
    EXTRACTIVEMARINE("reservation.type.extractive.marine"),
    ENVIRONMENTALPROTECTIONAREA("reservation.type.environmental.protection.area"),
    MARINESANCTUARY("reservation.type.marine.sanctuary"),
    FISHINGEXCLUSIONZONE("reservation.type.fishing.exclusion.zone"),
    SUSTAINABLEDEVELOPMENT("reservation.type.sustainable.development");

    companion object {
        fun printList() {
            val types = arrayOf(
                BIOLOGICALMARINE, MARINENATIONALPARK, EXTRACTIVEMARINE, ENVIRONMENTALPROTECTIONAREA,
                MARINESANCTUARY, FISHINGEXCLUSIONZONE, SUSTAINABLEDEVELOPMENT
            )

            types.forEachIndexed { index, type -> println("[${index + 1}] $type") }
        }

        fun selectedType() : ReservationType {
            var type = readln().toInt()
            while (type <= 0 || type > 7) {
                println("opção $type inválida, tente novamente:")
                type = readln().toInt()
            }

            return when(type) {
                1 -> BIOLOGICALMARINE
                2 -> MARINENATIONALPARK
                3 -> EXTRACTIVEMARINE
                4 -> ENVIRONMENTALPROTECTIONAREA
                5 -> MARINESANCTUARY
                6 -> FISHINGEXCLUSIONZONE
                7 -> SUSTAINABLEDEVELOPMENT
                else -> {
                    throw IllegalArgumentException("Invalid type $type")
                }
            }
        }
    }

    override fun toString(): String {
        return translate()
    }

    private fun translate(): String {
        val bundle = ResourceBundle.getBundle("message")
        return bundle.getString(type)
    }
}