package com.fml.calculator

object MovieTheater {

    fun totalRevenue(movies: Array<Movie>): Int = movies.sumBy { it.revenue }

    fun totalCost(movies: Array<Movie>): Int = movies.sumBy { it.cost }
}
