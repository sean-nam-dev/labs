package org.example

import java.math.BigInteger

fun main() {

}

data class Rational(
    val numerator: BigInteger,
    val denominator: BigInteger
) {
    init {
        if (denominator == BigInteger.ZERO) {
            throw IllegalArgumentException()
        }
    }

    override fun toString(): String {
        return if (denominator == 1.toBigInteger()) {
            "$numerator"
        } else {
            "$numerator/$denominator"
        }
    }
}