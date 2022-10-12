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
