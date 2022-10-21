class Player(): Game() {
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

    fun kill(weapon : List<String>, suicideOn : Boolean) {
        fun randomShoot(n: Int, m: Int) {
            val random = (n..m).random()
            if (random == n) {
                shot()
            }
        }
        while ((counterTerrorists > 0) && (terrorists > 0)) {
            randomShoot(0, 1)
            val choice = (0..5).random()
            if ((health <= 0) && (choice == 0 || choice == 2)) {
                println("${ctNames[(0..9).random()]} was killed with ${weapon[(1..9).random()]}")
                counterTerrorists -= 1
                resetStats()
            }
            else if ((health <= 0) && (choice == 1 || choice == 4)) {
                println("${tNames[(0..9).random()]} was killed with ${weapon[(1..9).random()]}")
                terrorists -= 1
                resetStats()
            }
            else if (suicideOn && (health <= 0) && (choice == 5)) {
                println("${ctNames[(0..9).random()]} had committed suicide")
            }
            else if (suicideOn && (health <= 0) && (choice == 3)) {
                println("${tNames[(0..9).random()]} had committed suicide")
            }
        }
    }

    // function to drop the bomb
    private fun drop() {
        bomb = false
    }

    // function to plant the bomb
    fun plant(isPlant : Boolean): Boolean {
        var result = false
        if (isPlant) {
            bomb = true
            println("\nBomb has been planted!")
            val explode = (0..1).random()
            if (explode == 0) {
                println("\nBomb exploded!")
                result = true
            }
            else if (explode == 1) {
                println("\nCounterTerrorists defused the bomb")
            }
        }
        return result
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