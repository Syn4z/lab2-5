class Player: Game() {
    private val crosshair = mapOf("default" to 1, "cross" to 2, "square" to 3, "circle" to 4, "dot" to 5)
    //var playerPosition = listOf(0,0)
    private var ctNames = mutableListOf("John", "Chad", "Brian", "Cory", "Finn")
    private var tNames = mutableListOf("Arnold", "Kyle", "Ringo", "Rip", "Zach")
    private val ctId = "(CT)"
    private val tId = "(T)"

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
        val playerInput = readln()
        when (playerInput.toInt()) {
            1 -> playerCrosshair = crosshair.filterValues { it == 1 }.keys.toString()
            2 -> playerCrosshair = crosshair.filterValues { it == 2 }.keys.toString()
            3 -> playerCrosshair = crosshair.filterValues { it == 3 }.keys.toString()
            4 -> playerCrosshair = crosshair.filterValues { it == 4 }.keys.toString()
        }
    }

    private fun shot(armorInput: Int) {
        armor = armorInput
        println("Shot!")
        if (health > 0) {
            when (armorInput) {
                200 -> {
                    health -= 25
                    armor -= 100

                }
                100 -> {
                    health -= 50
                    armor -= 100
                }
                else -> {
                    health -= 100
                }
            }
        }
    }

    fun kill(weapon : MutableList<String>, suicideOn : Boolean, armorInput: Int) {
        println("\n")
        fun randomShoot(n: Int, m: Int, shuffledWeapon: MutableList<String>) {
            val random = (0..1).random()
            if (random == 1) {
                if ("[AWP]" == shuffledWeapon[0] || "[Desert Eagle]" == shuffledWeapon[0] || "[MAG-7]" == shuffledWeapon[0]) {
                    println("Shot!")
                    health -= 100
                    armor -= 200
                } else {
                    val randomChoice = (n..m).random()
                    if (randomChoice == n) {
                        shot(armorInput)
                    }
                }
            }
            else {
                val randomChoice = (n..m).random()
                if (randomChoice == n) {
                    shot(armorInput)
                }
            }
        }
        while ((counterTerrorists > 0) && (terrorists > 0)) {
            val shuffledWeapon = weapon.shuffled().toMutableList()
            randomShoot(0, 1, shuffledWeapon)
            val choice = (0..5).random()
            if ((health <= 0) && (choice == 0 || choice == 2)) {
                ctNames = ctNames.shuffled().toMutableList()
                println("$ctId${ctNames[0]} was killed by $tId${tNames[(0 until tNames.size).random()]} with ${shuffledWeapon[0]}")
                ctNames.removeAt(0)
                counterTerrorists -= 1
                resetStats()
            }
            else if ((health <= 0) && (choice == 1 || choice == 4)) {
                tNames = tNames.shuffled().toMutableList()
                println("$tId${tNames[0]} was killed by $ctId${ctNames[(0 until ctNames.size).random()]} with ${shuffledWeapon[0]}")
                tNames.removeAt(0)
                terrorists -= 1
                resetStats()
            }
            else if (suicideOn && (health <= 0) && (choice == 5)) {
                ctNames = ctNames.shuffled().toMutableList()
                println("$ctId${ctNames[0]} had committed suicide")
                ctNames.removeAt(0)
                counterTerrorists -= 1
                resetStats()
            }
            else if (suicideOn && (health <= 0) && (choice == 3)) {
                tNames = tNames.shuffled().toMutableList()
                println("$tId${tNames[0]} had committed suicide")
                tNames.removeAt(0)
                terrorists -= 1
                resetStats()
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
}