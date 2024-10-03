package com.nura.vechiledetails.data.model

data class BikeDetails(
    val bikeId: String,        // Unique identifier for the bike
    val brand: String,         // Brand of the bike
    val model: String,         // Model name of the bike
    val year: Int,             // Manufacturing year
    val color: String,         // Color of the bike
    val engineCapacity: Double,// Engine capacity in CC
    val price: Double,         // Price of the bike
    val isAvailable: Boolean ,  // Availability status (true for available, false for sold)
    val imageId: Int
)
