/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
    val list = mutableListOf(2,3,5)
    println(numberAppearsOnce(list, 5))

}

fun numberAppearsOnce(list: MutableList<Int>, ele: Int): Int {
    val map = mutableMapOf(0 to 0)
    var preSum = 0
    var res = 0
    for((index, num) in list.withIndex()) {
        preSum += num
        map[preSum] = index + 1
        val rem = preSum - ele
        if(map.contains(rem)){
            var len = index +  - (map[rem] ?: 0)
            res = if(len > res)  len else res
        }
    }
    return res
}