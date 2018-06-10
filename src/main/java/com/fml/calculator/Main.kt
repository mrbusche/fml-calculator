package com.fml.calculator

object Main {
    private val startTime = System.currentTimeMillis()

    private val MOVIES = listOf(
            Movie("Empty", 0, -200),
            // Movies of the week
            Movie("oceans 8", 626, 3923333),
            Movie("hereditary", 219, 1014444),
            Movie("solo", 218, 1380180),
            Movie("deadpool 2", 201, 1267850),
            Movie("hotel artemis", 138, 646666),
            Movie("infinity", 93, 642500),
            Movie("adrift", 89, 634350),
            Movie("book club", 67, 478000),
            Movie("upgrade", 32, 241875),
            Movie("life of the party", 31, 202187),
            Movie("breaking in", 24, 176000),
            Movie("quiet place", 16, 110800),
            Movie("overboard", 16, 102250),
            Movie("action point", 15, 99050),
            Movie("rbg", 11, 74300)
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
