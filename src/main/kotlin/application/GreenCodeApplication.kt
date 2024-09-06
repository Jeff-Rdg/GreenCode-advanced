package org.greencode.application

import org.greencode.Config

class GreenCodeApplication {
    companion object {
        fun build() {
            val config = Config()
            println("Bem vindo!")
            config.menu()
        }
    }
}