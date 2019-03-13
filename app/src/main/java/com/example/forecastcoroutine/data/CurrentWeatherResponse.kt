package com.example.forecastcoroutine.data

import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("current")
    val current: CurrentWeatherEntry,
    @SerializedName("location")
    val location: Location
)