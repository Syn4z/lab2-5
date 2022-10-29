import kotlin.system.exitProcess

fun main() {
    fun simulation() {
        var matchCount = 1
        while (true) {
            println("Match nr: $matchCount")
            var j = 1
            var ctRounds = 0
            var tRounds = 0
            while (j < 31) {
                println("New Round started, round nr: $j\n")
                val obj1 = Player(
                    mutableListOf("John", "Chad", "Brian", "Cory", "Finn"),
                    mutableListOf("Arnold", "Kyle", "Ringo", "Rip", "Zach")
                )
                obj1.kill(Buy().read(), true, 0)
                if (obj1.plant(true)) {
                    println("\n\tROUND IS OVER")
                    println("\n\tTerrorists Win!")
                    tRounds += 1
                } else {
                    println("\n\tROUND IS OVER")
                    println("\n\tCounterTerrorists Win!")
                    ctRounds += 1
                }

                println("\nRemaining CounterTerrorists: ${obj1.counterTerrorists}")
                println("Remaining Terrorists: ${obj1.terrorists}")
                println("\n\t CT won: $ctRounds rounds; T won: $tRounds rounds\n")

                if (ctRounds == 16 && ctRounds > tRounds) {
                    println("\nCounterTerrorists won the match")
                    matchCount += 1
                    break
                } else if (tRounds == 16 && tRounds > ctRounds) {
                    println("\nTerrorists won the match")
                    matchCount += 1
                    break
                } else if (ctRounds == 15 && tRounds == 15) {
                    println("\nDraw")
                    matchCount += 1
                    break
                }
                j++
            }
            println("Next match?(y/n)")
            when (readln().lowercase()) {
                "y" -> {
                    continue
                }
                "n" -> {
                    break
                }
            }
        }
    }

    simulation()
}