class Player(override val ctNames: MutableList<String>,
             override val tNames: MutableList<String>
): Game, Team, Move {
    override val ctId: String = "(CT)"
    override val tId: String = "(T)"
    override var timer: Int = 115
    override var armor: Int = 0
    override var health: Int = 100
    override var bomb: Boolean = false
    override var counterTerrorists: Int = 5
    override var terrorists: Int = 5
    override var location: String = ""
    //var playerCrosshair: String = ""
    //private val crosshair = mapOf("default" to 1, "cross" to 2, "square" to 3, "circle" to 4, "dot" to 5)
    //var playerPosition = listOf(0,0)
    override val moveFront: String = ""
    override val moveBack: String = ""
    override val moveRight: String = ""
    override val moveLeft: String = ""
    override val crouch: String = ""
    override val jump: String = ""
    override val sneak: String = ""

    private var shuffledCtNames = ctNames
    private var shuffledTNames = tNames
    /*
    fun showHealth() {
        println("The health is : $health")
    }
     */
    /*
    fun showArmor() {
        println("The armor is : $armor")
    }
     */
    /*
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
     */

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
                shuffledCtNames = shuffledCtNames.shuffled().toMutableList()
                println("$ctId${shuffledCtNames[0]} was killed by $tId${shuffledTNames[(0 until shuffledTNames.size).random()]} with ${shuffledWeapon[0]}")
                shuffledCtNames.removeAt(0)
                counterTerrorists -= 1
                resetStats()
            }
            else if ((health <= 0) && (choice == 1 || choice == 4)) {
                shuffledTNames = shuffledTNames.shuffled().toMutableList()
                println("$tId${shuffledTNames[0]} was killed by $ctId${shuffledCtNames[(0 until shuffledCtNames.size).random()]} with ${shuffledWeapon[0]}")
                shuffledTNames.removeAt(0)
                terrorists -= 1
                resetStats()
            }
            else if (suicideOn && (health <= 0) && (choice == 5)) {
                shuffledCtNames = shuffledCtNames.shuffled().toMutableList()
                println("$ctId${shuffledCtNames[0]} had committed suicide")
                shuffledCtNames.removeAt(0)
                counterTerrorists -= 1
                resetStats()
            }
            else if (suicideOn && (health <= 0) && (choice == 3)) {
                shuffledTNames = shuffledTNames.shuffled().toMutableList()
                println("$tId${shuffledTNames[0]} had committed suicide")
                shuffledTNames.removeAt(0)
                terrorists -= 1
                resetStats()
            }
        }
    }

    // function to drop the bomb
    /*
    private fun drop() {
        bomb = false
    }
     */

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

    // shows how many ct and t are alive or dead
    /*
    fun showTab() {
        println("CounterTerrorists: $counterTerrorists")
        println("Terrorists: $terrorists")
    }
     */

    private fun resetStats() {
        health = 100
        armor = 0
    }
}