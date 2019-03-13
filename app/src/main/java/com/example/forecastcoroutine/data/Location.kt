package com.example.forecastcoroutine.data

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("country")
    val country: String,
    val lat: Double,
    val lon: Double,
    val localtime: String,
    @SerializedName("localtime_epoch")
    val localtimeEpoch: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("tz_id")
    val tzId: String
)