package graph

fun numIslands(matrix: Array<IntArray>): Int {
    var islands = 0
    var visited = Array<IntArray>(matrix.size) { IntArray(matrix[0].size) {0} }
    for (i in 0 until matrix.size) {
        for (j in 0 until matrix[0].size) {
            if (visited[i][j] == 0 && matrix[i][j] == 1) {
                islands++
                bfs(i, j, matrix, visited)
            }
        }
    }
    return islands
}

fun bfs(row: Int, col: Int, matrix: Array<IntArray>, visited: Array<IntArray>) {
    visited[row][col] = 1
    var r = matrix.size
    var c = matrix[0].size
    var queue = ArrayDeque<Pair<Int, Int>>()
    queue.add(row to col)
    while (queue.isNotEmpty()) {
        val curr = queue.removeFirst()
        for (i in -1..1){
            for (j in -1..1){
                val trow = curr.first + i
                val tcol = curr.second + j
                if (trow >= 0 && trow < r &&
                    tcol >= 0 && tcol < c &&
                    visited[trow][tcol] == 0 &&
                    matrix[trow][tcol] == 1) {
                    visited[trow][tcol] = 1
                    queue.add(Pair(trow, tcol))
                }
            }
        }
    }
}