import kotlin.random.Random
import kotlin.system.exitProcess

open class Game {
    var health = 100
    var armor = 0
    var playerCrosshair = ""
    val timer = 115
    var counterTerrorists = 5
    var terrorists = 5
}

open class Player: Game() {
    private val crosshair = mapOf("default" to 1, "cross" to 2, "square" to 3, "circle" to 4, "dot" to 5)
    var playerPosition = listOf(0,0)

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
        println("Your health is : $health")
    }

    fun showArmor() {
        println("Your armor is : $armor")
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

    fun showTimer() {
        for (time in timer..0) {
            println(time)
        }
    }

}

class Move: Player() {

    // code in each function for changing position of player
    fun moveFront() {

    }

    fun moveBack() {

    }

    fun moveRight() {

    }

    fun moveLeft() {

    }

}

class Special: Player() {
    var location = ""
    // code to change the vertical position of player
    fun jump() {
        location = "Jump"
    }

    fun crouch() {
        location = "Crouch"
    }

    fun sneak() {
        location = "Sneak"
    }

    init {
        crouch()
        sneak()
        jump()
        println(location)
    }
}

open class Shoot: Player() {

    fun shot() {
        println("You've been shot!")
        // different conditions for each of weapons
        health -= 50

        if (armor != 0) {
            armor -= 30
        }
    }

}

open class Weapons: Game() {

    var ctPistol = mapOf("USP-S" to 1, "Dual Berettas" to 2, "P250" to 3, "Five-SeveN" to 4, "Desert Eagle" to 5)

    var ctHeavy = mapOf("Nova" to 1, "XM1014" to 2, "MAG-7" to 3, "M249" to 4, "Negev" to 5)

    var ctSmg = mapOf("MP9" to 1, "MP7" to 2, "UMP" to 3, "P90" to 4, "PP-Bizon" to 5)

    var ctRifle = mapOf("FAMAS" to 1, "M4A1-S" to 2, "SSG 08" to 3, "AUG" to 4, "AWP" to 5, "SCAR-20" to 6)

    var ctGrenade = mapOf("Incendiary Grenade" to 1, "Decoy Grenade" to 2, "Flashbang" to 3, "High Explosive Grenade" to 4,
        "Smoke Grenade" to 5)

    var ctEquipment = mapOf("Kevlar Vest" to 1, "Kevlar + Helmet" to 2, "Zeus x27" to 3, "Defuse Kit" to 4)

}

class Stats: Weapons() {

    var ammo = ""

    fun ammo() {
        println("Input your weapon: ")
        for (x in ctPistol.values) {
            when (x) {
                1 -> {ammo = "12/24"
                    println(ammo)}
                2 -> {ammo = "30/120"
                    println(ammo)}
                3 -> {ammo = "13/26"
                    println(ammo)}
                4 -> {ammo = "20/100"
                    println(ammo)}
                5 -> {ammo = "7/35"
                    println(ammo)}
            }
        }
    }
        // need to get the stats for the specific gun in the directory
        // damage and armor penetration
        // fire-rate and others
}

class Bomb: Game() {
    var bomb = true
    var isPlant = false

    // function to drop the bomb
    fun drop() {
        bomb = false
    }

    // function to plant the bomb
    fun plant() {
        isPlant = true
    }

    init {
        drop()
        println(bomb)
    }
}

class Radar: Game() {
    var map = ""
    // function to display the map
    fun display() {
        map = "1"
    }

    // adjust the map where the player goes
    fun adjust() {
        map = "2"
    }

    init {
        display()
        println(map)
    }
}

class Buy: Weapons() {

    var balance = 800

    // operations to extract or add money
    fun win() {
        balance += 200
    }

    fun lose() {
        balance += 50
    }
    // Buy menu
    fun read() {
        var categoryChoice = ""
        println("What type of weapon do you want to buy? ")
        val categoryInput = readLine()!!
        when (categoryInput.toInt()) {
            1 -> categoryChoice = "pistol"
            2 -> categoryChoice = "heavy"
            3 -> categoryChoice = "smg"
            4 -> categoryChoice = "rifle"
            5 -> categoryChoice = "grenade"
            6 -> categoryChoice = "equipment"
            else -> "Not in categories!"
        }
        println("What model do you want to buy? ")
        val typeInput = readLine()!!
        when (typeInput.toInt()) {
            // the specific model of a category
            1 -> println("You bought a: $categoryChoice")
            2 -> println("You bought a: $categoryChoice")
            3 -> println("You bought a: $categoryChoice")
            4 -> println("You bought a: $categoryChoice")
            5 -> println("You bought a: $categoryChoice")
            6 -> println("You bought a: $categoryChoice")
            else -> "Not in the models!"
        }
    }

    init {
        read()
    }
}

class PlayerTab: Player() {

    // changes the nr of ct and t when kill
    fun change() {
        counterTerrorists -= 1
        terrorists -= 2
    }

    fun reload() {
        // resets the nr of ct and t after each round
        counterTerrorists = 5
        terrorists = 5
    }

    init {
        change()
        println("Terrorists: $terrorists")
    }
}

class Kill: Shoot() {
    var source = ""

    fun isKill() {
        if ((counterTerrorists > 0) && (terrorists > 0)) {
            var choice = (0..1).random()
            if ((health <= 0) && (choice == 0)) {
                source = "Pistol"
                counterTerrorists -= 1
            } else if ((health <= 0) && (choice == 1)) {
                terrorists -= 1
            }
        }
        else {
            exitProcess(0)
        }
    }

    fun suicide() {
        source = "Yourself"
    }

    fun bomb() {
        source = "Terrorist Bomb"
    }

    fun friendly() {
        source = "Your smart teammate"
    }

}

fun main() {
    val obj = Kill()

    obj.shot()
    obj.shot()
    obj.showHealth()
    println("CounterTerrorists: ${obj.counterTerrorists}")
    println("Terrorists: ${obj.terrorists}")
    obj.isKill()
    println("CounterTerrorists: ${obj.counterTerrorists}")
    println("Terrorists: ${obj.terrorists}")
    obj.isKill()
    println("CounterTerrorists: ${obj.counterTerrorists}")
    println("Terrorists: ${obj.terrorists}")

    //val obj2 = Move()

    //val obj3 = Special()

    //val obj4 = Shoot()

    //val obj5 = Buy()

    //val obj7 = Kill()

    //val obj8 = Player()
    //obj8.showCrosshair()
    //println(obj8.playerCrosshair)

    //val obj9 = Bomb()

    //val obj10 = Radar()

    //val obj11 = PlayerTab()

    //val obj12 = Weapons()
    //println(obj12.ctPistol.keys)
}
