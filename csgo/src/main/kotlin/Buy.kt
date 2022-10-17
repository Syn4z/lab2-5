abstract class Buy: Weapons() {
    var categoryInput = 0
    var typeInput = 0
    var categoryChoice = mapOf("" to 0)
    var weapons = listOf("")
    private var i = 10
    private var ammo = mapOf("12/24" to 1, "30/110" to 2, "13/26" to 3, "20/100" to 4, "7/35" to 5,
        "8/32" to 6, "7/32" to 7, "5/32" to 8, "100/200" to 9, "150/300" to 10, "30/130" to 11, "30/120" to 12,
        "25/100" to 13, "50/100" to 14, "64/120" to 15, "25/90" to 16, "20/80" to 17, "10/90" to 18, "30/90" to 19,
        "10/30" to 20, "20/90" to 21)

    protected var balance = 800

    // Buy menu
    fun read() {
        while (i > 0) {
            categoryInput = (1..6).random()
            when (categoryInput) {
                1 -> categoryChoice = ctPistol
                2 -> categoryChoice = ctHeavy
                3 -> categoryChoice = ctSmg
                4 -> categoryChoice = ctRifle
                5 -> categoryChoice = ctGrenade
                6 -> categoryChoice = ctEquipment
            }
            typeInput = when (categoryInput) {
                4 -> {
                    (1..6).random()
                }

                6 -> {
                    (1..4).random()
                }

                else -> {
                    (1..5).random()
                }
            }
            when (typeInput) {
                // the specific model of a category
                1 -> println("Weapon/Utility: ${categoryChoice.filterValues { it == 1 }.keys}")
                2 -> println("Weapon/Utility: ${categoryChoice.filterValues { it == 2 }.keys}")
                3 -> println("Weapon/Utility: ${categoryChoice.filterValues { it == 3 }.keys}")
                4 -> println("Weapon/Utility: ${categoryChoice.filterValues { it == 4 }.keys}")
                5 -> println("Weapon/Utility: ${categoryChoice.filterValues { it == 5 }.keys}")
                6 -> println("Weapon/Utility: ${categoryChoice.filterValues { it == 6 }.keys}")
            }
            if ((categoryInput != 5) && (categoryInput != 6)) {
                weapons += categoryChoice.filterValues { it == typeInput }.keys.toString()
            }
            else {
                weapons += ctPistol.filterValues { it == typeInput }.keys.toString()
            }
            if ((categoryChoice == ctEquipment) && (typeInput == 1)) {
                armor = 100
            } else if ((categoryChoice == ctEquipment) && (typeInput == 2)) {
                armor = 200
            }
            when (categoryInput) {
                1 -> when (typeInput) {
                    1 -> println("Ammo: ${ammo.filterValues { it == 1 }.keys}")
                    2 -> println("Ammo: ${ammo.filterValues { it == 2 }.keys}")
                    3 -> println("Ammo: ${ammo.filterValues { it == 3 }.keys}")
                    4 -> println("Ammo: ${ammo.filterValues { it == 4 }.keys}")
                    5 -> println("Ammo: ${ammo.filterValues { it == 5 }.keys}")
                }

                2 -> when (typeInput) {
                    1 -> println("Ammo: ${ammo.filterValues { it == 6 }.keys}")
                    2 -> println("Ammo: ${ammo.filterValues { it == 7 }.keys}")
                    3 -> println("Ammo: ${ammo.filterValues { it == 8 }.keys}")
                    4 -> println("Ammo: ${ammo.filterValues { it == 9 }.keys}")
                    5 -> println("Ammo: ${ammo.filterValues { it == 10 }.keys}")
                }

                3 -> when (typeInput) {
                    1 -> println("Ammo: ${ammo.filterValues { it == 11 }.keys}")
                    2 -> println("Ammo: ${ammo.filterValues { it == 12 }.keys}")
                    3 -> println("Ammo: ${ammo.filterValues { it == 13 }.keys}")
                    4 -> println("Ammo: ${ammo.filterValues { it == 14 }.keys}")
                    5 -> println("Ammo: ${ammo.filterValues { it == 15 }.keys}")
                }

                4 -> when (typeInput) {
                    1 -> println("Ammo: ${ammo.filterValues { it == 16 }.keys}")
                    2 -> println("Ammo: ${ammo.filterValues { it == 17 }.keys}")
                    3 -> println("Ammo: ${ammo.filterValues { it == 18 }.keys}")
                    4 -> println("Ammo: ${ammo.filterValues { it == 19 }.keys}")
                    5 -> println("Ammo: ${ammo.filterValues { it == 20 }.keys}")
                    6 -> println("Ammo: ${ammo.filterValues { it == 21 }.keys}")
                }
            }
            i -= 1
        }
    }
}