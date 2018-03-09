package com.fml.calculator

import me.tongfei.progressbar.ProgressBar
import org.apache.commons.math3.util.CombinatoricsUtils
import java.text.NumberFormat
import java.util.*

object Main {

    private var bestRevenue = 0
    private var validCombos: Long = 0
    private var invalidCombos: Long = 0
    // Sub 50 movies is instant
    // 55+ takes about a minute
    // 60 takes 3 minutes
    private val MOVIES = MoviesBuilder()
            .addMovie(Movie("Empty", 0, -200), 3)
            // Movies of the week
            .addMovie(Movie("A Wrinkle in Time", 641, 4032), 1)
            .addMovie(Movie("Black Panther", 575, 3900), 1)
            .addMovie(Movie("Strangers", 126, 847), 7)
            .addMovie(Movie("Red Sparrow", 121, 817), 0)
            .addMovie(Movie("Peter Rabbit", 107, 687), 0)
            .addMovie(Movie("Game Night", 97, 670), 0)
            .addMovie(Movie("Death Wish", 85, 640 + 200), 8)
            .addMovie(Movie("Hurrican heist", 78, 460), 2)
            .addMovie(Movie("Shape of Water", 48, 325), 0)
            .addMovie(Movie("Gringo", 48, 327), 2)
            .addMovie(Movie("Jumanji", 47, 325), 2)
            .addMovie(Movie("Thoroughbreds", 47, 260), 0)
            .addMovie(Movie("Annihilation", 44, 305), 2)
            .addMovie(Movie("Greatest Showman", 29, 210), 3)
            .addMovie(Movie("Fifty Shades", 25, 160), 4)
            .build()

    private var movieCombos = CombinatoricsUtils.binomialCoefficient(MOVIES.size, 8)
    private var progressBar: ProgressBar = ProgressBar("Simulating:", movieCombos)

    @JvmStatic
    fun main(args: Array<String>) {
        val startTime = System.nanoTime()
        println("Total movies: " + MOVIES.size)
        println("Movie Combos: " + movieCombos)

        val blah = Movie("Blah", 0, 0)

        progressBar.start()
        combinations2(8, 0, arrayOf(blah, blah, blah, blah, blah, blah, blah, blah))
        progressBar.stop()

        val duration = System.nanoTime() - startTime

        val numberFormat = NumberFormat.getNumberInstance(Locale.US)
        println("Valid Combos ${numberFormat.format(validCombos)}")
        println("Invalid Combos ${numberFormat.format(invalidCombos)}")
        println("Done - ${duration / 1000000000} seconds")
    }

    private fun combinations2(screensRemaining: Int, screenPosition: Int, movieTheater: Array<Movie>) {
        if (screensRemaining == 0) {
            progressBar.step()
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
