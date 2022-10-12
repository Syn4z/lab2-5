// GRANDCHILD CLASS
class PlayerTab: Player() {
    // changes the nr of ct and t when kill
    fun showTab() {
        println("CounterTerrorists: $counterTerrorists")
        println("Terrorists: $terrorists")
    }

    fun reload() {
        // resets the nr of ct and t after each round
        counterTerrorists = 5
        terrorists = 5
    }
}
