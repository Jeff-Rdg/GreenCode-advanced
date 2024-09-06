package org.greencode.enums

import java.util.*

enum class EnvironmentalType(val type: String) {
    BEACH( "environmental.type.beach"),
    ROCKYSHORES("environmental.type.rockyshores"),
    MANGROVES( "environmental.type.mangroves"),
    CORALREEFS( "environmental.type.coralreefs"),
    ESTUARINEZONES("environmental.type.estuarinezones"),
    OPENOCEAN("environmental.type.openocean"),
    SEAFLOOR( "environmental.type.seafloor"),
    ABYSSALTRENCHES( "environmental.type.abyssaltrenches");

    companion object {
        fun printListEnv() {
            val envs = arrayOf(BEACH, ROCKYSHORES, MANGROVES, CORALREEFS, ESTUARINEZONES, OPENOCEAN, SEAFLOOR,
                ABYSSALTRENCHES)

            envs.forEachIndexed { index, env -> println("[${index + 1}] $env") }
        }

        fun selectedEnv() : EnvironmentalType {
            var env = readln().toInt()
            while (env <= 0 || env > 8) {
                println("opção $env inválida, tente novamente:")
                env = readln().toInt()
            }

            return when(env) {
                1 -> BEACH
                2 -> ROCKYSHORES
                3 -> MANGROVES
                4 -> CORALREEFS
                5 -> ESTUARINEZONES
                6 -> OPENOCEAN
                7 -> SEAFLOOR
                8 -> ABYSSALTRENCHES
                else -> {
                    throw IllegalArgumentException("Invalid env $env")
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