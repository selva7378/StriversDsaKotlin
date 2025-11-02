package array.easy

fun secondLargestElement(arr: Array<Int>): Int {
    var largest = Integer.MIN_VALUE
    var secondLargest = Integer.MIN_VALUE
    for (i in arr) {
        if (i > largest) {
            secondLargest = largest
            largest = i
        }
    }
    return secondLargest
}

