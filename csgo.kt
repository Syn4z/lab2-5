
private class Player() {
    protected var health = 100

    protected var armor = 0

    val crosshair = mapOf("default" to 1, "cross" to 2, "square" to 3, "circle" to 4, "dot" to 5)

    var timer = 115

    init {
        println("Health = $health")
        println("Armor = $armor")
    }
}

private class View {
    protected var camera = listOf("Start")

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

    init {
        look_down()
        look_up()
        look_up()
        println(camera)
    }
}

private class Move {
    protected var location = ""

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

    init {
        move_back()
        move_front()
        move_right()
        println(location)
    }
}

private class Special {
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

private class Shoot {
    var health = 100

    var armor = 0

    fun shot() {
        println("You've been shot!")
        // different conditions for each of weapons
        health -= 50
        armor -= 30
    }

    init {
        shot()
    }
}

private class Weapons {
    var ct_pistol = mapOf("USP-S" to 1, "Dual Berettas" to 2, "P250" to 3, "Five-SeveN" to 4, "Desert Eagle" to 5)

    var ct_heavy = mapOf("Nova" to 1, "XM1014" to 2, "MAG-7" to 3, "M249" to 4, "Negev" to 5)

    var ct_smg = mapOf("MP9" to 1, "MP7" to 2, "UMP" to 3, "P90" to 4, "PP-Bizon" to 5)

    var ct_rifle = mapOf("FAMAS" to 1, "M4A1-S" to 2, "SSG 08" to 3, "AUG" to 4, "AWP" to 5, "SCAR-20" to 6)

    var ct_grenade = mapOf("Incendiary Grenade" to 1, "Decoy Grenade" to 2, "Flashbang" to 3, "High Explosive Grenade" to 4,
                            "Smoke Grenade" to 5)

    var ct_equipment = mapOf("Kevlar Vest" to 1, "Kevlar + Helmet" to 2, "Zeus x27" to 3, "Defuse Kit" to 4)

    fun stats() {
        // need to get the stats for the specific gun in the directory
        // damage and armor penetration
        // fire-rate and others
    }

    init {
        println("Pistols are: $ct_pistol")
    }
}

private class Bomb {
    var bomb = true
    var is_plant = false

    // function to drop the bomb
    fun drop() {
        bomb = false
    }

    // function to plant the bomb
    fun plant() {
        is_plant = true
    }

    init {
        drop()
        println(bomb)
    }
}

private class Radar {
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

private class Buy {
    // Buy menu
    fun read() {
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
            1 -> println("You bought a: $category_choise")
            2 -> println("You bought a: $category_choise")
            3 -> println("You bought a: $category_choise")
            4 -> println("You bought a: $category_choise")
            5 -> println("You bought a: $category_choise")
            6 -> println("You bought a: $category_choise")
            else -> "Not in the models!"
        }
    }

    init {
        read()
    }
}

private class Money {
    var balance = 800

    // operations to extract or add money
    fun win() {
        balance += 200
    }

    fun lose() {
        balance += 50
    }

    init {
        win()
        lose()
        println("Your balance is: $balance")
    }
}

private class Kill {
    var source = ""

    fun is_kill() {
        // variable for source of killing
        source = "Pistol"
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

    init {
        friendly()
        println("You have been killed by: $source")
    }
}

private class PlayerTab {
    var counter_terrorists = 5
    var terrorists = 5

    // changes the nr of ct and t when kill
    fun change() {
        counter_terrorists -= 1
        terrorists -= 2
    }

    fun reload() {
        // resets the nr of ct and t after each round
        counter_terrorists = 5
        terrorists = 5
    }

    init {
        change()
        println("Terrorists: $terrorists")
    }
}

fun main() {
    val obj = Player()

    val obj1 = View()

    val obj2 = Move()

    val obj3 = Special()

    val obj4 = Shoot()

    val obj5 = Buy()

    val obj6 = Money()

    val obj7 = Kill()

    val obj8 = Weapons()

    val obj9 = Bomb()

    val obj10 = Radar()

    val obj11 = PlayerTab()

}
