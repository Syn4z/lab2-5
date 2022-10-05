import kotlin.random.Random
import kotlin.system.exitProcess

// PARENT CLASS
open class Game {

    var health = 100
    var armor = 0
    var playerCrosshair = ""
    val timer = 115
    var bomb = true

    var counterTerrorists = 5
    var terrorists = 5

    var location = ""
    var map = ""
}

// CHILD CLASS
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

// GRANDCHILD CLASS
class Move: Player() {

    // code in each function for changing position of player
    fun moveFront() {}

    fun moveBack() {}

    fun moveRight() {}

    fun moveLeft() {}

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
}

// GRANDCHILD CLASS
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

// CHILD CLASS
open class Weapons: Game() {

    var ctPistol = mapOf("USP-S" to 1, "Dual Berettas" to 2, "P250" to 3, "Five-SeveN" to 4, "Desert Eagle" to 5)

    var ctHeavy = mapOf("Nova" to 1, "XM1014" to 2, "MAG-7" to 3, "M249" to 4, "Negev" to 5)

    var ctSmg = mapOf("MP9" to 1, "MP7" to 2, "UMP" to 3, "P90" to 4, "PP-Bizon" to 5)

    var ctRifle = mapOf("FAMAS" to 1, "M4A1-S" to 2, "SSG 08" to 3, "AUG" to 4, "AWP" to 5, "SCAR-20" to 6)

    var ctGrenade = mapOf("Incendiary Grenade" to 1, "Decoy Grenade" to 2, "Flashbang" to 3, "High Explosive Grenade" to 4,
        "Smoke Grenade" to 5)

    var ctEquipment = mapOf("Kevlar Vest" to 1, "Kevlar + Helmet" to 2, "Zeus x27" to 3, "Defuse Kit" to 4)
}

// CHILD CLASS
class Radar: Game() {
    // function to display the map
    private fun display() {
        map = "1"
    }

    // adjust the map where the player goes
    fun adjust() {
        map = "2"
    }
}

// GRANDCHILD CLASS
open class Buy: Weapons() {

    var categoryInput = ""
    var typeInput = ""
    private var oneMore = true
    private var moreBuy = ""

    protected var balance = 800

    // Buy menu
    fun read() {
        while (oneMore) {
            var categoryChoice = mapOf("" to 0)
            println("What type of weapon do you want to buy? ")
            categoryInput = readLine()!!
            when (categoryInput.toInt()) {
                1 -> categoryChoice = ctPistol
                2 -> categoryChoice = ctHeavy
                3 -> categoryChoice = ctSmg
                4 -> categoryChoice = ctRifle
                5 -> categoryChoice = ctGrenade
                6 -> categoryChoice = ctEquipment
                else -> println("Not in categories!")
            }
            println("What model do you want to buy? ")
            typeInput = readLine()!!
            when (typeInput.toInt()) {
                // the specific model of a category
                1 -> println("You bought a: ${categoryChoice.filterValues { it == 1 }.keys}")
                2 -> println("You bought a: ${categoryChoice.filterValues { it == 2 }.keys}")
                3 -> println("You bought a: ${categoryChoice.filterValues { it == 3 }.keys}")
                4 -> println("You bought a: ${categoryChoice.filterValues { it == 4 }.keys}")
                5 -> println("You bought a: ${categoryChoice.filterValues { it == 5 }.keys}")
                6 -> println("You bought a: ${categoryChoice.filterValues { it == 6 }.keys}")
                else -> println("Not in the models!")
            }
            if ((categoryChoice == ctEquipment) && (typeInput.toInt() == 1)) {
                armor += 100
            } else if ((categoryChoice == ctEquipment) && (typeInput.toInt() == 2)) {
                armor += 200
            }
            println("Do you want to buy something else?(Y or N) ")
            moreBuy = readLine()!!
            if (moreBuy == "Y") {
                oneMore = true
                continue
            } else {
                oneMore = false
                break
            }
        }
    }
}

// GRAND-GRANDCHILD CLASS
open class Stats: Buy() {

    private var ammo = mapOf("12/24" to 1, "30/120" to 2, "13/26" to 3, "20/100" to 4, "7/35" to 5,
        "8/32" to 6, "7/32" to 7, "5/32" to 8, "100/200" to 9, "150/300" to 10, "30/120" to 11, "30/120" to 12,
        "25/100" to 13, "50/100" to 14, "64/120" to 15, "25/90" to 16, "20/80" to 17, "10/90" to 18, "30/90" to 19,
        "10/30" to 20, "20/90" to 21)

    fun ammo() {

        when (categoryInput.toInt()) {
            1 -> when (typeInput.toInt()) {
                1 -> println("Weapon ammo: ${ammo.filterValues { it == 1 }.keys}")
                2 -> println("Weapon ammo: ${ammo.filterValues { it == 2 }.keys}")
                3 -> println("Weapon ammo: ${ammo.filterValues { it == 3 }.keys}")
                4 -> println("Weapon ammo: ${ammo.filterValues { it == 4 }.keys}")
                5 -> println("Weapon ammo: ${ammo.filterValues { it == 5 }.keys}")
                else -> println("No weapon!")
            }
            2 -> when (typeInput.toInt()) {
                1 -> println("Weapon ammo: ${ammo.filterValues { it == 6 }.keys}")
                2 -> println("Weapon ammo: ${ammo.filterValues { it == 7 }.keys}")
                3 -> println("Weapon ammo: ${ammo.filterValues { it == 8 }.keys}")
                4 -> println("Weapon ammo: ${ammo.filterValues { it == 9 }.keys}")
                5 -> println("Weapon ammo: ${ammo.filterValues { it == 10 }.keys}")
                else -> println("No weapon!")
            }
            3 -> when (typeInput.toInt()) {
                1 -> println("Weapon ammo: ${ammo.filterValues { it == 11 }.keys}")
                2 -> println("Weapon ammo: ${ammo.filterValues { it == 12 }.keys}")
                3 -> println("Weapon ammo: ${ammo.filterValues { it == 13 }.keys}")
                4 -> println("Weapon ammo: ${ammo.filterValues { it == 14 }.keys}")
                5 -> println("Weapon ammo: ${ammo.filterValues { it == 15 }.keys}")
                else -> println("No weapon!")
            }
            4 -> when (typeInput.toInt()) {
                1 -> println("Weapon ammo: ${ammo.filterValues { it == 16 }.keys}")
                2 -> println("Weapon ammo: ${ammo.filterValues { it == 17 }.keys}")
                3 -> println("Weapon ammo: ${ammo.filterValues { it == 18 }.keys}")
                4 -> println("Weapon ammo: ${ammo.filterValues { it == 19 }.keys}")
                5 -> println("Weapon ammo: ${ammo.filterValues { it == 20 }.keys}")
                else -> println("No weapon!")
            }
        }
    }
    // need to get the stats for the specific gun in the directory
    // damage and armor penetration
    // fire-rate and others
}

// GRAND-GRAND-GRANDCHILD CLASS
class Round: Stats() {

    private var isPlant = false

    // operations to extract or add money
    fun win() {
        balance += 200
        println("You won the round, current balance: $balance")
    }

    fun lose() {
        balance += 50
        println("You lost the round, current balance: $balance")
    }

    // function to drop the bomb
    private fun drop() {
        bomb = false
    }

    // function to plant the bomb
    fun plant() {
        isPlant = true
    }
}

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

// GRAND-GRANDCHILD CLASS
class Kill: Shoot() {

    private var source = ""

    fun isKill() {
        if ((counterTerrorists > 0) && (terrorists > 0)) {
            val choice = (0..1).random()
            if ((health <= 0) && (choice == 0)) {
                source = "Pistol"
                counterTerrorists -= 1
            } else if ((health <= 0) && (choice == 1)) {
                source = "Pistol"
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


    val obj1 = Round()
    obj1.read()
    obj1.ammo()
    obj1.win()
    obj1.lose()
    println(obj1.armor)

    val obj2 = Move()
    obj2.crouch()
    obj2.jump()
    obj2.sneak()
    println(obj2.location)

    val obj3 = Shoot()
    obj3.shot()

    val obj4 = PlayerTab()
    obj4.reload()
}
