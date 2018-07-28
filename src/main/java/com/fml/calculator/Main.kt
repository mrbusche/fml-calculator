package com.fml.calculator

object Main {
    private val startTime = System.currentTimeMillis()
    private var bestPick = 0
    private var currentRate = 0

    private val MOVIES = listOf(
            Movie("Empty", 0, -2000000),
            // Movies of the week
            Movie("incredibles", 591, 45025000),
            Movie("saturday", 356, 25133103),
            Movie("sunday", 278, 19590997),
            Movie("uncle drew", 275, 14350000),
            Movie("friday", 266, 18435899),
            Movie("sicario", 201, 15075000),
            Movie("oceans", 97, 7350000),
            Movie("tag", 64, 5100000),
            Movie("deadpool", 41, 3300000),
            Movie("solo", 31, 2450000),
            Movie("sanju", 30, 2000000),
            Movie("hereditary", 24, 2050000),
            Movie("neighbor", 24, 1800000),
            Movie("superfly", 22, 1700000),
            Movie("infinity", 18, 1500000)
    )

    @JvmStatic
    fun main(args: Array<String>) {
        //var movieName = bestMoviePick(MOVIES)
        //println(movieName)
        CombosWithReps(8, MOVIES).getComboList()
                .map { MovieTheater(it) }
                .filter { it.totalCost() <= 1000 }
                .groupBy { it.totalRevenue() }
                .toSortedMap()
                .toList()
                .asReversed()
                .take(10)
                .forEach { println(it) }
        println("" + (System.currentTimeMillis() - startTime) + "ms")
    }

//    fun bestMoviePick(MOVIES: List<Movie>) {
//        var bestPickMovieName = ""
//        println(MOVIES.size)
//
//        for (movie in MOVIES) {
//            if (movie.cost > 0) {
//                currentRate = movie.revenue / movie.cost
//                if (currentRate > bestPick) {
//                    bestPick = currentRate
//                    bestPickMovieName = movie.name
//                }
//            }
//        }
//        return bestPickMovieName
//    }
}
