package com.fml.calculator

object Main {
    private val startTime = System.currentTimeMillis()

    private val MOVIES = listOf(
            Movie("Empty", 0, -2000000),
            // Movies of the week
            Movie("oceans 8", 626, 39233333),
            Movie("hereditary", 219, 10144444),
            Movie("solo", 218, 13801800),
            Movie("deadpool 2", 201, 12678500),
            Movie("hotel artemis", 138, 6466666),
            Movie("infinity", 93, 6425000),
            Movie("adrift", 89, 6343500),
            Movie("book club", 67, 4780000),
            Movie("upgrade", 32, 4418750),
            Movie("life of the party", 31, 2021875),
            Movie("breaking in", 24, 1760000),
            Movie("quiet place", 16, 1108000),
            Movie("overboard", 16, 1022500),
            Movie("action point", 15, 990500),
            Movie("rbg", 11, 743000)
    )

    @JvmStatic
    fun main(args: Array<String>) {
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
}
