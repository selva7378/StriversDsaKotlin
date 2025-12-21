package array.medium

fun setZeroes(matrix: Array<IntArray>): Unit {
    var firstRow = false
    var firstCol = false
    for (num in matrix[0]) {
        if (num == 0) firstRow = true
    }

    for (i in 0..matrix.size - 1) {
        if (matrix[i][0] == 0) firstCol = true
    }
    for(i in 1 until matrix.size) {
        for(j in 1 until matrix[i].size) {
            if(matrix[i][j] == 0) {
                matrix[0][j] = 0
                matrix[i][0] = 0
            }
        }
    }

    for(i in 1 until matrix.size) {
        for(j in 1 until matrix[i].size) {
            if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0
        }
    }

    if(firstRow) {
        for(i in 0 until matrix[0].size) {
            matrix[0][i] = 0
        }
    }

    if(firstCol) {
        for(i in 0 until matrix.size) {
            matrix[i][0] = 0
        }
    }
}