class Kill: Buy() {
    var source = ""

    fun randomShoot() {
        val random = (0..1).random()
        if (random == 0) {
            shot()
        }
    }

    fun isKill() {
        read()
        while ((counterTerrorists > 0) && (terrorists > 0)) {
            randomShoot()
            val choice = (0..1).random()
            if ((health <= 0) && (choice == 0)) {
                println("${ctNames[(0..9).random()]} was killed with ${weapons[(1..9).random()]}")
                counterTerrorists -= 1
                health = 100
                armor = 0
            }
            else if ((health <= 0) && (choice == 1)) {
                println("${tNames[(0..9).random()]} was killed with ${weapons[(1..9).random()]}")
                terrorists -= 1
                health = 100
                armor = 0
            }
        }
        println("Round is over")
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
}