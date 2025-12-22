package array.medium


fun main() {
    var arr = arrayOf(
        intArrayOf(1,2,3,4),
        intArrayOf(5, 6, 7, 8 ),
        intArrayOf(9, 10, 11, 12),
        intArrayOf(13, 14, 15, 16),
    )
    print(spiralOrder(arr))
}
fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val list = mutableListOf<Int>()
    var top = 0
    var left = 0
    var bottom = matrix.size - 1
    var right = matrix[0].size - 1
    while(top <= bottom && left <= right) {
        for(i in left..right) {
            list.add(matrix[top][i])
        }
        top++

        for(i in top..bottom) {
            list.add(matrix[i][right])
        }
        right--

        if(top <= bottom) {
            for(i in right downTo left) {
                list.add(matrix[bottom][i])
            }
            bottom--
        }

        if(left <= right) {
            for(i in bottom downTo top) {
                list.add(matrix[i][left])
            }
            left++
        }
    }
    return list
}