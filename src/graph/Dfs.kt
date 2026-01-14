package graph

fun main() {
//    Fix for disconnected graph:
//    for (i in 0 until V) {
//        if (visited[i] == 0) {
//            dfsOfGraph(i, adjList, visited, res)
//        }
//    }

}

fun dfsOfGraph(vertex: Int, adjList: Array<List<Int>>, visited: IntArray, res: MutableList<Int>){
    visited[vertex] = 1
    res.add(vertex)

    for (neighbour in adjList[vertex]) {
        if (visited[neighbour] != 1) {
            dfsOfGraph(neighbour, adjList, visited, res)
        }
    }
}