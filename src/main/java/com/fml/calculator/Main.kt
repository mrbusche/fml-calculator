package com.fml.calculator

import java.text.NumberFormat
import java.util.*

object Main {

    private var bestRevenue = 0
    private var validCombos: Long = 0
    private var invalidCombos: Long = 0

    private val MOVIES = listOf(
            Movie("Empty", 0, -200),
            // Movies of the week
            Movie("Ready Player One", 522, 3942),
            Movie("Acrimony", 219, 1605),
            Movie("Pacific Rim", 167, 1095),
            Movie("I can only", 153, 1080),
            Movie("Black Panther", 148, 1090),
            Movie("Sherlock Gnomes", 91, 625),
            Movie("God's Not Dead", 75, 477),
            Movie("Love Simon", 71, 497),
            Movie("Isle of Dogs", 69, 405),
            Movie("Tomb Raider", 65, 480),
            Movie("A Wrinkle in Time", 54, 423),
            Movie("Game Night", 41, 320),
            Movie("Paul", 41, 356 + 200),
            Movie("Midnight Sun", 28, 200),
            Movie("Unsane", 23, 180)
    )

    @JvmStatic
    fun main(args: Array<String>) {
        val startTime = System.nanoTime()

        CombosWithReps(8, MOVIES).getComboList().map { movies ->
            MovieTheater(movies)
        }.forEach { theater ->
            if (theater.totalCost() <= 1000) {
                validCombos++
                val revenue = theater.totalRevenue()
                if (revenue > bestRevenue) {
                    bestRevenue = revenue
                    println(revenue.toString() + " " + theater)
                }
            } else {
                invalidCombos++
            }
        }

        val duration = System.nanoTime() - startTime

        val numberFormat = NumberFormat.getNumberInstance(Locale.US)
        println("Valid Combos ${numberFormat.format(validCombos)}")
        println("Invalid Combos ${numberFormat.format(invalidCombos)}")
        println("Done - ${duration / 1000000000} seconds")
    }
}
