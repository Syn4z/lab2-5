
class Player {
    var health = 100

    var armor = 0

    val crosshiar = "dot"

    var timer = 115
}

class View {
    var camera = listOf("Start")

    fun look_up() {
        camera += "Up"
    }

    fun look_down() {
        camera += "Down"
    }

    fun look_right() {
        camera += "Right"
    }

    fun look_left() {
        camera += "Left"
    }
}

class Move {
    var location = ""

    // code in each function for changing position of player
    fun move_front() {
        location = "Front"
    }

    fun move_back() {
        location = "Back"
    }

    fun move_right() {
        location = "Right"
    }

    fun move_left() {
        location = "Left"
    }
}

class Special {
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
}

class Shoot {
    /*private*/ fun shot() {
        println("You've been shot!")
        Player().health -= 50
        Player().armor -= 30
    }
}

class Weapons {
    var ct_pistol = mapOf("USP-S" to 1, "Dual Berettas" to 2, "P250" to 3, "Five-SeveN" to 4, "Desert Eagle" to 5)

    var ct_heavy = mapOf("Nova" to 1, "XM1014" to 2, "MAG-7" to 3, "M249" to 4, "Negev" to 5)

    var ct_smg = mapOf("MP9" to 1, "MP7" to 2, "UMP" to 3, "P90" to 4, "PP-Bizon" to 5)

    var ct_rifle = mapOf("FAMAS" to 1, "M4A1-S" to 2, "SSG 08" to 3, "AUG" to 4, "AWP" to 5, "SCAR-20" to 6)

    var ct_grenade = mapOf("Incendiary Grenade" to 1, "Decoy Grenade" to 2, "Flashbang" to 3, "High Explosive Grenade" to 4,
                            "Smoke Grenade" to 5)

    var ct_equipment = mapOf("Kevlar Vest" to 1, "Kevlar + Helmet" to 2, "Zeus x27" to 3, "Defuse Kit" to 4)

    private fun stats() {
        // need to get the stats for the specific gun in the directory
    }

    private fun damage() {}

    private fun armor_penetration() {}
}

class Bomb {
    var bomb = true

    // function to drop the bomb
    fun drop() {
        bomb = false
    }

    // function to plant the bomb
    fun plant() {
        var is_plant = true
    }
}

class Radar {
    var map = ""
    // function to display the map
    fun dispay() {
        map = "1"
    }

    // adjust the map where the player goes
    fun adjust() {
        map = "2"
    }
}

class Buy {
    /*private*/ fun read() {
        var category_choise = ""
        println("What type of weapon do you want to buy? ")
        val category_input = readLine()!!
        when (category_input.toInt()) {
            1 -> category_choise = "pistol"
            2 -> category_choise = "heavy"
            3 -> category_choise = "smg"
            4 -> category_choise = "rifle"
            5 -> category_choise = "grenade"
            6 -> category_choise = "equipment"
            else -> "Not in categories!"
        }
        println("What model do you want to buy? ")
        val type_input = readLine()!!
        when (type_input.toInt()) {
            // the specific model of a category
            1 -> println("You bought a: " + category_choise)
            2 -> println("You bought a: " + category_choise)
            3 -> println("You bought a: " + category_choise)
            4 -> println("You bought a: " + category_choise)
            5 -> println("You bought a: " + category_choise)
            6 -> println("You bought a: " + category_choise)
            else -> "Not in the models!"
        }
    }
}

class Money {
    var balance = 800

    // operations to extract or add money
}

class Kill {
    /*private*/ fun is_kill() {
        // variable for source of killing
        val source = "Pistol"

        println(source)
    }
}

class PlayerTab {
    var counter_terorists = 5
    var terrorists = 5

    // changes the nr of ct and t when kill
    fun change() {
        counter_terorists -= 1
        terrorists -= 2
    }
}

fun main() {
    val obj = Player()
    println("Health: " + obj.health)
    println("Armor: " + obj.armor)

    val obj1 = View()
    obj1.look_down()
    obj1.look_left()
    println("Look: " +obj1.camera)

    val obj2 = Move()
    obj2.move_front()
    println("Move: " + obj2.location)

    val obj3 = Special()
    obj3.crouch()
    println("Crouch: " + obj3.location)

    val obj4 = Shoot()
    obj4.shot()

    val obj5 = Buy()
    obj5.read()

    val obj6 = Money()
    println("Balance: " + obj6.balance)

    val obj7 = Kill()
    print("You have been killed with: ")
    obj7.is_kill()

    val obj8 = Weapons()
    println("Weapon: " + obj8.ct_pistol)

    val obj9 = Bomb()
    obj9.drop()
    println("Bomb: " + obj9.bomb)

    val obj10 = Radar()
    obj10.adjust()
    println("Map: " + obj10.map)

    val obj11 = PlayerTab()
    obj11.change()
    println("Terrorists: " + obj11.terrorists)
}
