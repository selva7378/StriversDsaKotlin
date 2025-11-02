package array.easy

fun main() {
    print(maximumConsecutiveOnes(arrayOf(1, 1, 0, 1, 0, 1)))
}

fun maximumConsecutiveOnes(arr: Array<Int>): Int {
    var maxConsecutive = Integer.MIN_VALUE
    var currConsecutive = Integer.MIN_VALUE
    for (i in 0 until arr.size) {
        if(arr[i] == 0) {
            currConsecutive = 0
            continue
        }
        currConsecutive++
        if (currConsecutive > maxConsecutive) maxConsecutive = currConsecutive
    }
    return maxConsecutive
}