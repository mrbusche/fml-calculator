package com.fml.calculator

data class Movie(val name: String, val cost: Int, val revenue: Int) {

    override fun toString(): String {
        return name
    }
}
