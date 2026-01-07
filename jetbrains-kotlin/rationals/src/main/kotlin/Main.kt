package org.example

import java.math.BigInteger
import kotlin.div
import kotlin.times
import kotlin.unaryMinus

fun main() {
    val half = 1 divBy 2
    val third = 1 divBy 3

    val sum: Rational = half + third
    println(5 divBy 6 == sum)

    val difference: Rational = half - third
    println(1 divBy 6 == difference)

    val product: Rational = half * third
    println(1 divBy 6 == product)

    val quotient: Rational = half / third
    println(3 divBy 2 == quotient)

    val negation: Rational = -half
    println(-1 divBy 2 == negation)

    println((2 divBy 1).toString() == "2")
    println((-2 divBy 4).toString() == "-1/2")
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)

    println(half in third..twoThirds)

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println("912016490186296920119201192141970416029".toBigInteger() divBy
            "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2)
}

data class Rational(
    val numerator: BigInteger,
    val denominator: BigInteger
) : Comparable<Rational> {

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

    override fun compareTo(other: Rational): Int {
        val diff = this - other
        return when {
            diff.numerator < BigInteger.ZERO -> -1
            diff.numerator > BigInteger.ZERO -> 1
            else -> 0
        }
    }

    infix operator fun plus(other: Rational): Rational {
        val g = denominator.gcd(other.denominator)

        val a = numerator * (other.denominator / g)
        val b = other.numerator * (denominator / g)

        val num = a + b
        val den = (denominator / g) * other.denominator

        val finalGcd = num.gcd(den)
        return Rational(num / finalGcd, den / finalGcd)
    }

    infix operator fun minus(other: Rational): Rational {
        val gcdDen = denominator.gcd(other.denominator)
        val num = numerator * (other.denominator / gcdDen) - other.numerator * (denominator / gcdDen)
        val den = (denominator * other.denominator) / gcdDen
        val finalGcd = num.gcd(den)

        return Rational(
            numerator = num / finalGcd,
            denominator = den / finalGcd
        )
    }

    infix operator fun times(other: Rational): Rational {
        val numerator = numerator * other.numerator
        val denominator = denominator * other.denominator

        return normalize(
            Rational(
                numerator = numerator,
                denominator = denominator
            )
        )
    }

    infix operator fun div(other: Rational): Rational {
        return normalize(
            Rational(
                numerator = this.numerator * other.denominator,
                denominator = this.denominator * other.numerator
            )
        )
    }

    operator fun unaryMinus(): Rational {
        return normalize(
            Rational(
                numerator = -this.numerator,
                denominator = this.denominator
            )
        )
    }

    operator fun rangeTo(other: Rational): ClosedRange<Rational> {
        return object : ClosedRange<Rational> {
            override val start: Rational
                get() = this@Rational
            override val endInclusive: Rational
                get() = other
        }
    }
}

fun String.toRational(): Rational {
    val nums = this.split('/').map { it.toBigInteger() }

    return normalize(
        if (nums.size > 1) {
            Rational(
                numerator = nums.first(),
                denominator = nums.last()
            )
        } else {
            Rational(
                numerator = nums.first(),
                denominator = BigInteger.ONE
            )
        }
    )
}

infix fun Int.divBy(other: Int): Rational {
    return normalize(
        Rational(
            numerator = this.toBigInteger(),
            denominator = other.toBigInteger()
        )
    )
}

infix fun Long.divBy(other: Long): Rational {
    return normalize(
        Rational(
            numerator = this.toBigInteger(),
            denominator = other.toBigInteger()
        )
    )
}

infix fun BigInteger.divBy(other: BigInteger): Rational {
    return normalize(
        Rational(
            numerator = this,
            denominator = other
        )
    )
}

private fun normalize(rational: Rational): Rational {
    val gcd = rational.numerator.gcd(rational.denominator)

    var (numerator, denominator) = rational.numerator / gcd to rational.denominator / gcd

    if (denominator < BigInteger.ZERO) {
        numerator *= (-1).toBigInteger()
        denominator *= (-1).toBigInteger()
    }

    return Rational(
        numerator = numerator,
        denominator = denominator
    )
}