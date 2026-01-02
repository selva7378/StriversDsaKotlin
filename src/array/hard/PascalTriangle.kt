package array.hard

fun main() {
    print(generate(3))
}

fun generate(numRows: Int): List<List<Int>> {
    val list = mutableListOf<MutableList<Int>>()
    for(i in 0 until numRows) {
        val tempList = MutableList(i+1) {1}
        for(j in 1 until i) {
            tempList[j] = list[i - 1][j - 1] + list[i - 1][j]
        }
        list.add(tempList)
    }
    return list
}