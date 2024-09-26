package fr.iut.cinecool.model

data class CinemaResult(
    val lat: Double,
    val lon: Double,
    val display_name: String
)

data class RouteResult(
    val routes: List<Route>
)

data class Route(
    val segments: List<Segment>
)

data class Segment(
    val steps: List<Step>
)

data class Step(
    val instruction: String
)
