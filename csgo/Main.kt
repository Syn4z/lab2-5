import kotlin.random.Random
import kotlin.system.exitProcess

fun main() {
    val obj = Kill()
    obj.shot()
    obj.shot()
    obj.showHealth()
    println("CounterTerrorists: ${obj.counterTerrorists}")
    println("Terrorists: ${obj.terrorists}")
    obj.isKill()
    println("CounterTerrorists: ${obj.counterTerrorists}")
    println("Terrorists: ${obj.terrorists}")
    obj.isKill()
    println("CounterTerrorists: ${obj.counterTerrorists}")
    println("Terrorists: ${obj.terrorists}")


    val obj1 = Round()
    obj1.read()
    obj1.ammo()
    obj1.win()
    obj1.lose()
    println(obj1.armor)

    val obj2 = Move()
    obj2.crouch()
    obj2.jump()
    obj2.sneak()
    println(obj2.location)

    val obj3 = Shoot()
    obj3.shot()

    val obj4 = PlayerTab()
    obj4.reload()
}
