package graph

fun main() {

}

fun bfsOfGraph(V: Int, adjList: Array<List<Int>>): List<Int> {
    val visited = IntArray(V) { 0 }
    val bfsRes = mutableListOf<Int>()
    val queue = ArrayDeque<Int>()

    queue.addLast(0)
    visited[0] = 1

    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        bfsRes.add(node)

        for (neighbor in adjList[node]) {
            if (visited[neighbor] == 0) {
                visited[neighbor] = 1
                queue.addLast(neighbor)
            }
        }
    }

    return bfsRes
}
