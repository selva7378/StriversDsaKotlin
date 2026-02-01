package graph

fun isBipartite(graph: Array<IntArray>): Boolean {
    val visited = IntArray(graph.size) {-1}
    for(i in 0 until visited.size) {
        if(visited[i] == -1) {
            if(dfs(graph, i, 0, visited) == false) return false
        }
    }
    return true
}

fun dfs(graph: Array<IntArray>,node: Int, col: Int, visited: IntArray): Boolean {
    visited[node] = col

    for(neighbour in graph[node]) {
        if(visited[neighbour] == -1) {
            if(dfs(graph, neighbour, 1 - col, visited) == false) return false
        }else if(visited[neighbour] == col) {
            return false
        }
    }
    return true
}

// below one if bfs version
fun isBipartiteBfs(graph: Array<IntArray>): Boolean {
    val color = IntArray(graph.size) { -1 } // -1 = uncolored

    for (i in graph.indices) {
        if (color[i] != -1) continue

        val queue = ArrayDeque<Int>()
        queue.add(i)
        color[i] = 0

        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()

            for (neighbour in graph[node]) {
                if (color[neighbour] == -1) {
                    // assign opposite color
                    color[neighbour] = 1 - color[node]
                    queue.add(neighbour)
                }
                else if (color[neighbour] == color[node]) {
                    return false
                }
            }
        }
    }
    return true
}