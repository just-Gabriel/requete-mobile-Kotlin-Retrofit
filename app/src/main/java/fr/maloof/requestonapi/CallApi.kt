package fr.maloof.requestonapi

data class Experience(
    val id: Int,
    val agreabilite: Int,
    val intensite: Int,
    val impression: String,
    val user: String,
    val telephone: String,
    val vibration: String
)