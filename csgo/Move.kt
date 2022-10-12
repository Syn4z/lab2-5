// GRANDCHILD CLASS
class Move: Player() {

    // code in each function for changing position of player
    fun moveFront() {}

    fun moveBack() {}

    fun moveRight() {}

    fun moveLeft() {}

    // code to change the vertical position of player
    fun jump() {
        location = "Jump"
    }

    fun crouch() {
        location = "Crouch"
    }

    fun sneak() {
        location = "Sneak"
    }
}
