package array.hard

fun main() {
    print(subArrayXorNoOf(intArrayOf(4, 2, 2, 6, 4), 6))
    print(subArrayXorNoOf(intArrayOf(5, 6, 7, 8, 9), 5))
}


fun subArrayXorNoOf(arr: IntArray, target: Int): Int {
    val map = mutableMapOf<Int, Int>()
    var preSum = 0
    var res = 0
    map[0] = 1
    for (num in arr) {
        preSum = preSum xor num
        val rem = preSum xor target
        if (map.containsKey(rem)) {
            res = res + map[rem]!!
        }

        map[preSum] = (map[preSum] ?: 0) + 1
    }
    return res
}