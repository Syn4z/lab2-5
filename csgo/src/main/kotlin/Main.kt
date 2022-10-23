fun main() {
    fun firstScenario() {
        println("New round started\n")
        var ctRounds = 0
        var tRounds = 0
        val obj1 = Player(mutableListOf("John", "Chad", "Brian", "Cory", "Finn"),
            mutableListOf("Arnold", "Kyle", "Ringo", "Rip", "Zach"))
        obj1.kill(Buy().read(), false, 0)
        println("\n\tROUND IS OVER")
        when {
            obj1.counterTerrorists == 0 -> {
                println("\n\tTerrorists Win!")
                tRounds += 1
            }
            obj1.terrorists == 0 -> {
                println("\n\tCounterTerrorists Win!")
                ctRounds += 1
            }
        }
        println("\nRemaining CounterTerrorists: ${obj1.counterTerrorists}")
        println("Remaining Terrorists: ${obj1.terrorists}")
        println("\n\t CT won: $ctRounds rounds; T won: $tRounds rounds\n")
    }

    fun secondScenario() {
        println("New round started\n")
        var ctRounds = 0
        var tRounds = 0
        val obj1 = Player(mutableListOf("John", "Chad", "Brian", "Cory", "Finn"),
            mutableListOf("Arnold", "Kyle", "Ringo", "Rip", "Zach"))
        obj1.kill(Buy().read(), true, 0)
        println("\n\tROUND IS OVER")
        if (obj1.counterTerrorists == 0) {
            println("\n\tTerrorists Win!")
            tRounds += 1
        } else if (obj1.terrorists == 0) {
            println("\n\tCounterTerrorists Win!")
            ctRounds += 1
        }
        println("\nRemaining CounterTerrorists: ${obj1.counterTerrorists}")
        println("Remaining Terrorists: ${obj1.terrorists}")
        println("\n\t CT won: $ctRounds rounds; T won: $tRounds rounds\n")
    }

    fun thirdScenario() {
        println("New round started\n")
        var ctRounds = 0
        var tRounds = 0
        val obj1 = Player(mutableListOf("John", "Chad", "Brian", "Cory", "Finn"),
            mutableListOf("Arnold", "Kyle", "Ringo", "Rip", "Zach"))
        obj1.kill(Buy().read(), false, 0)
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
    }

    fun fourthScenario() {
        println("New round started\n")
        var ctRounds = 0
        var tRounds = 0
        val obj1 = Player(mutableListOf("John", "Chad", "Brian", "Cory", "Finn"),
            mutableListOf("Arnold", "Kyle", "Ringo", "Rip", "Zach"))
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
    }

    fun fifthScenario() {
        println("New round started\n")
        var ctRounds = 0
        var tRounds = 0
        val obj1 = Player(mutableListOf("John", "Chad", "Brian", "Cory", "Finn"),
            mutableListOf("Arnold", "Kyle", "Ringo", "Rip", "Zach"))
        obj1.kill(Buy().read(), true, 0)
        println("\n\tROUND IS OVER")
        if (!obj1.plant(false)) {
            if (obj1.counterTerrorists == 0) {
                println("\n\tTerrorists Win!")
                tRounds += 1
            } else if (obj1.terrorists == 0) {
                println("\n\tCounterTerrorists Win!")
                ctRounds += 1
            }
        }

        println("\nRemaining CounterTerrorists: ${obj1.counterTerrorists}")
        println("Remaining Terrorists: ${obj1.terrorists}")
        println("\n\t CT won: $ctRounds rounds; T won: $tRounds rounds\n")
    }

    fun sixthScenario() {
        println("New round started\n")
        var ctRounds = 0
        var tRounds = 0
        val obj1 = Player(mutableListOf("John", "Chad", "Brian", "Cory", "Finn"),
            mutableListOf("Arnold", "Kyle", "Ringo", "Rip", "Zach"))
        obj1.kill(Buy().read(), true, 200)
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
    }

    // suicide off, without bomb
    firstScenario()
    // suicide on, without bomb
    secondScenario()
    // suicide off, bomb planted
    thirdScenario()
    // suicide on, bomb planted
    fourthScenario()
    // suicide on, bomb not planted
    fifthScenario()
    // full armor, suicide on, bomb planted
    sixthScenario()

    /*fun simulation() {
        var j = 1
        var ctRounds = 0
        var tRounds = 0
        while (j < 31) {
            println("New Round started, round nr: $j\n")
            val obj1 = Player(mutableListOf("John", "Chad", "Brian", "Cory", "Finn"),
            mutableListOf("Arnold", "Kyle", "Ringo", "Rip", "Zach"))
            obj1.kill(Buy().read(), false, 0)
            if (obj1.counterTerrorists == 0) {
                println("\n\tTerrorists Win!")
                tRounds += 1
            } else {
                if (obj1.terrorists == 0) {
                    println("\n\tCounterTerrorists Win!")
                    ctRounds += 1
                }
            }

            println("\nRemaining CounterTerrorists: ${obj1.counterTerrorists}")
            println("Remaining Terrorists: ${obj1.terrorists}")
            println("\n\t CT won: $ctRounds rounds; T won: $tRounds rounds\n")

            if (ctRounds == 16 && ctRounds > tRounds) {
                println("\nCounterTerrorists won the match")
                break
            }
            else if (tRounds == 16 && tRounds > ctRounds) {
                println("\nTerrorists won the match")
                break
            }
            else if (ctRounds == 15 && tRounds == 15) {
                println("\nDraw")
                break
            }
            j++
        }
    }
    simulation()
     */
}