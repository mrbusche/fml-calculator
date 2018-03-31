package com.fml.calculator

class MovieTheater(private val theater: List<Movie>) {

    fun totalRevenue(): Int = theater.sumBy { it.revenue }

    fun totalCost(): Int = theater.sumBy { it.cost }

    override fun toString(): String {
        return "MovieTheater($theater)"
    }

    companion object {
        fun totalRevenue(movies: Array<Movie>): Int = movies.sumBy { it.revenue }

        fun totalCost(movies: Array<Movie>): Int = movies.sumBy { it.cost }
    }


}
