fun main() {
    val obj1 = Kill()
    obj1.isKill()
    if (obj1.counterTerrorists == 0) {
        println("\n\tTerrorists Win!")
    }
    else {
        if (obj1.terrorists == 0) {
            println("\n\tCounterTerrorists Win!")
        }
    }
    println("\nRemaining CounterTerrorists: ${obj1.counterTerrorists}")
    println("Remaining Terrorists: ${obj1.terrorists}")
}