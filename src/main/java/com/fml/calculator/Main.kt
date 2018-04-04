package com.fml.calculator

object Main {
    private val MOVIES = listOf(
            Movie("Empty", 0, -200),
            // Movies of the week
            Movie("A quiet place", 460, 3220),
            Movie("Ready Player One", 334, 2180),
            Movie("Cock Blockers", 217, 1520),
            Movie("Black Panther", 108, 720),
            Movie("Acrimony", 103, 650),
            Movie("I can only imagine", 96, 620),
            Movie("Isle of Dogs", 62, 360),
            Movie("Pacific Rim", 58, 400),
            Movie("Gnomes", 57, 450),
            Movie("Miracle Season", 53, 380),
            Movie("Chappaquiddick", 50, 230),
            Movie("Wrinkle", 39, 270),
            Movie("Love Simon", 39, 270),
            Movie("Tomb Raider", 34, 230),
            Movie("Paul", 26, 160)
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
                .take(5)
                .forEach { println(it) }

    }
}
