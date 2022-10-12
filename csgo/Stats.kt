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
