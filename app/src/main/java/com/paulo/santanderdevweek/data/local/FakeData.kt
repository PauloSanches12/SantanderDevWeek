package com.paulo.santanderdevweek.data.local

import com.paulo.santanderdevweek.data.Cartao
import com.paulo.santanderdevweek.data.Cliente
import com.paulo.santanderdevweek.data.Conta

class FakeData {
    fun getLocalData(): Conta {
        val cliente = Cliente("Paulo Sergio")
        val cartao = Cartao("0077")
        return Conta(
                "458489-4",
                "3291-4",
                "R$ 20.000,00",
                "R$: 30.000,00",
                cliente,
                cartao)
    }
}