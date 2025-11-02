package array.easy

// Find the number that appears once, and the other numbers twice

fun main() {
    print(xorOnce(arrayOf(2, 2, 1, 1, 3)))
}

fun xorOnce(arr: Array<Int>): Int {
    var res = 0
    for (i in 0 until arr.size) {
        res = res xor arr[i]
    }
    return res
}