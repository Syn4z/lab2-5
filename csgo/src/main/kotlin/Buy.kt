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