package array.easy

fun main(){
    println(missingNumber(arrayOf(1, 2, 4), 4))
}

fun missingNumber(arr: Array<Int>, size: Int): Int {
    var xor1 = 0
    var xor2 = 0
    for(i in 0 until arr.size) {
        xor1 = xor1 xor  (i + 1)
        xor2 = xor2 xor  arr[i]
    }
    xor1 = xor1 xor size
    return xor1 xor  xor2
}