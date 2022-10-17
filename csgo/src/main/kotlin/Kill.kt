class Kill: Player() {
    private var source = ""

    fun isKill() {
        if ((counterTerrorists > 0) && (terrorists > 0)) {
            val choice = (0..1).random()
            if ((health <= 0) && (choice == 0)) {
                source = "Pistol"
                counterTerrorists -= 1
            } else if ((health <= 0) && (choice == 1)) {
                source = "Pistol"
                terrorists -= 1
            }
        }
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