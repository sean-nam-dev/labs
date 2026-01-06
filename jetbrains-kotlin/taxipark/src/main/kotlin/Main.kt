package org.example

import kotlin.math.floor

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

}

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> {
    val activeDrivers = this.trips.map { it.driver }.toSet()

    return this.allDrivers - activeDrivers
}

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> {
    if (minTrips == 0) return allPassengers

    val passengerMap = mutableMapOf<Passenger, Int>()

    this.trips.forEach { trip ->
        trip.passengers.forEach { passenger ->
            passengerMap[passenger] = passengerMap.getOrDefault(passenger, 0) + 1
        }
    }

    return passengerMap.filter { it.value >= minTrips }.keys
}