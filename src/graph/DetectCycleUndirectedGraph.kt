package graph


fun main() {

}

fun isCyclic(vertex: Int, adjList: Array<List<Int>>): Boolean {
    var visited = BooleanArray(vertex){false}
    for (i in 0 until vertex) {
        if (!visited[i]) {
            if (detect(adjList, visited, i)) return true
        }
    }
    return false
}

fun detect(adjList: Array<List<Int>>, vis: BooleanArray, src: Int): Boolean {
    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.add(src to -1)
    vis[src] = true

    while (queue.isNotEmpty()) {
        val (node, parent) = queue.removeFirst()

        for (neighbour in adjList[node]) {
            if (!vis[neighbour]) {
                vis[neighbour] = true
                queue.add(neighbour to node)
            } else if (neighbour != parent) {
                return true
            }
        }
    }
    return false
}
