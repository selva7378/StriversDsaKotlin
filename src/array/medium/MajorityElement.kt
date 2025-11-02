package array.medium

fun main() {
    println(majorityElement(arrayOf(3,2,3)))
    println(majorityElement(arrayOf(2,2,1,1,1,2,2)))
    println(majorityElement(arrayOf(4,4,2,4,3,4,4,3,2,4)))
}

fun majorityElement(arr: Array<Int>): Int {
    var candidate = 0
    var voteCount = 0
    for (num in arr){
        if (voteCount == 0){
            candidate = num
            voteCount++
        }else if (num == candidate){
            voteCount++
        }else{
            voteCount--
        }
    }
    return candidate
}