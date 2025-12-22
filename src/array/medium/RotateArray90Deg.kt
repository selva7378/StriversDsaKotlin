package array.medium

fun rotate(matrix: Array<IntArray>): Unit {

    //transpose
    for (i in 0 until matrix.size) {
        for (j in 0 until matrix[i].size) {
            if(j <= i) continue
            else {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }
    }

    //reverse each row
    for(arr in matrix) {
        reverse(arr)
    }

}

fun reverse(arr: IntArray): Unit {
    var i = 0
    var j = arr.size -1
    while (i < j) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
        i++
        j--
    }
}