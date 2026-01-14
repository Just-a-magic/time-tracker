package com.example.timetracker.features.activity

data class ActivityModel(
    val id: Long = System.currentTimeMillis(),
    val name: String
)