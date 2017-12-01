package com.fml.calculator

import java.text.NumberFormat
import java.util.*

object Main {

    private var bestRevenue = 0
    private var validCombos: Int = 0
    private var invalidCombos: Int = 0
    // Sub 50 movies is instant
    // 55+ takes about a minute
    // 60 takes 3 minutes
    private val MOVIES = MoviesBuilder()
            .addMovie(Movie("Empty", 0, -200), 2)
            // Movies of the week
            .addMovie(Movie("Coco", 417, 2673), 2)
            .addMovie(Movie("Justice League", 280, 1603), 3)
            .addMovie(Movie("Wonder", 230, 1323), 4)
            .addMovie(Movie("Thor", 134, 803), 7)
            .addMovie(Movie("Murder", 132, 733), 7)
            .addMovie(Movie("Daddy", 126, 670), 7)
            .addMovie(Movie("Three Billboard", 74, 460), 8)
            .addMovie(Movie("Lady Bird", 66, 345), 8)
            .addMovie(Movie("The Star", 60, 326), 8)
            .addMovie(Movie("Bad Mom", 44, 256), 8)
            .addMovie(Movie("Roman", 36, 223), 8)
            .addMovie(Movie("The Man", 14, 59), 8)
            .addMovie(Movie("The Disaster", 13, 36), 8)
            .addMovie(Movie("Call Me", 8, 30), 8)
            .addMovie(Movie("Wonder Wheel", 6, 25), 8)
            .build()

    @JvmStatic
    fun main(args: Array<String>) {
        val startTime = System.nanoTime()
        println("Total movies: " + MOVIES.size)

        val blah = Movie("Blah", 0, 0)

        combinations2(8, 0, arrayOf(blah, blah, blah, blah, blah, blah, blah, blah))

        val duration = System.nanoTime() - startTime

        val numberFormat = NumberFormat.getNumberInstance(Locale.US)
        println("Valid Combos ${numberFormat.format(validCombos)}")
        println("Invalid Combos ${numberFormat.format(invalidCombos)}")
        println("Done - ${duration / 1000000000} seconds")
    }

    private fun combinations2(screensRemaining: Int, screenPosition: Int, movieTheater: Array<Movie>) {
        if (screensRemaining == 0) {
            if (MovieTheater.totalCost(movieTheater) <= 1000) {
                validCombos++
                val revenue = MovieTheater.totalRevenue(movieTheater)
                if (revenue > bestRevenue) {
                    bestRevenue = revenue
                    println(revenue.toString() + " " + Arrays.toString(movieTheater))
                }
            } else {
                invalidCombos++
            }
            return
        }
        val bound = MOVIES.size - screensRemaining
        for (i in screenPosition..bound) {
            movieTheater[movieTheater.size - screensRemaining] = MOVIES[i]
            combinations2(screensRemaining - 1, i + 1, movieTheater)
        }
    }
}

