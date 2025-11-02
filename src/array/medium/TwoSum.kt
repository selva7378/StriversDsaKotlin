package array.medium

fun main() {
    println(twoSum(arrayOf(2,6,5,8,11), 14))
    println(twoSum(arrayOf(2,6,5,8,11), 15))

}

fun twoSum(arr: Array<Int>, target: Int): Boolean {
    var map = mutableSetOf<Int>()
    for (num in arr) {
        var rem = target - num

        if (map.contains(rem)){
            return true
        }
        map.add(num)
    }
    return false
}

fun twoSum(list: MutableList<Int>, target: Int): Boolean {
    var i = 0
    var j = list.size -1
    while(i < j) {
        val num = list[i] + list[j]
        if(num > target){
            j--
        }else if(num < target){
            i++
        }else{
            return true
        }
    }
    return false
}

fun bubbleSort(list: MutableList<Int>) {
    for(i in 0 until list.size - 1) {
        for(j in 0 until (list.size - i - 1)) {
            if(list[j] > list[j + 1]){
                val temp = list[j]
                list[j] = list[j + 1]
                list[j + 1] = temp
            }
        }
    }
}