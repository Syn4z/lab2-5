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
