package graph

fun findCircleNum(isConnected: Array<IntArray>): Int {
    var res = 0
    val visited = IntArray(isConnected.size)
    for(i in 0 until isConnected.size) {
        if(visited[i] != 1) {
            res++
            dfs(i, isConnected, visited)
        }
    }
    return res
}

fun dfs(vertex: Int, matrixRep: Array<IntArray>, visited: IntArray) {
    visited[vertex] = 1
    for((neighbours, isConnected) in matrixRep[vertex].withIndex()) {
        if(isConnected == 1 && visited[neighbours] != 1) {
            dfs(neighbours, matrixRep, visited)
        }
    }
}