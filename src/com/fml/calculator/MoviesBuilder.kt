package com.fml.calculator

import java.util.ArrayList
import java.util.stream.IntStream

class MoviesBuilder {

    private val movies = ArrayList<Movie>()

    fun addMovie(movie: Movie, numScreens: Int): MoviesBuilder {

        IntStream.range(0, numScreens).forEach { _ -> movies.add(movie) }

        return this
    }

    fun build(): Array<Movie> = movies.toTypedArray()
}
