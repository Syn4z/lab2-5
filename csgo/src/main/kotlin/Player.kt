open class Player: Game() {
    private val crosshair = mapOf("default" to 1, "cross" to 2, "square" to 3, "circle" to 4, "dot" to 5)
    private var isPlant = false
    var playerPosition = listOf(0,0)
    val ctNames = listOf("Dave", "John", "Doug", "Chad", "Brian", "Cory", "Erik", "Finn", "Jim", "Seth")
    val tNames = listOf("Arnold", "Brett", "Kurt", "Kyle", "Moe", "Quade", "Quintin", "Ringo", "Rip", "Zach")

    fun teamChoice(): Boolean {
        var result = true
        val choice = (0..1).random()
        if (choice == 0) {
            counterTerrorists =+ 1
        }
        else if (choice == 1) {
            terrorists =+ 1
            result = false
        }

        return result
    }

    fun showHealth() {
        println("The health is : $health")
    }

    fun showArmor() {
        println("The armor is : $armor")
    }

    fun showCrosshair() {
        println("Choose your crosshair: ")
        val playerInput = readLine()!!
        when (playerInput.toInt()) {
            1 -> playerCrosshair = crosshair.filterValues { it == 1 }.keys.toString()
            2 -> playerCrosshair = crosshair.filterValues { it == 2 }.keys.toString()
            3 -> playerCrosshair = crosshair.filterValues { it == 3 }.keys.toString()
            4 -> playerCrosshair = crosshair.filterValues { it == 4 }.keys.toString()
        }
    }

    fun shot() {
        println("Shot!")
        if (health > 0) {
            if (armor > 100) {
                health -= 25
                armor -= 100
            }
            else if (armor == 100) {
                health -= 50
                armor -= 100
            }
            else {
                health -= 100
            }
        }
    }

    // function to drop the bomb
    private fun drop() {
        bomb = false
    }

    // function to plant the bomb
    fun plant() {
        isPlant = true
    }

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