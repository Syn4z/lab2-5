open class Game {
    var health = 100
    var armor = 0
    var playerCrosshair = ""
    val timer = 115
    var bomb = false
    open var weapons = listOf("")

    var counterTerrorists = 5
    var terrorists = 5

    var location = ""

    fun resetStats() {
        health = 100
        armor = 0
    }
}