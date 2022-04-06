import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val dr = arrayOf(1, -1, 0, 0)
val dc = arrayOf(0, 0, 1, -1)
var n = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()

    val result = mutableListOf<Int>()
    val map = mutableListOf<List<Char>>()
    val visited = Array(n) { BooleanArray(n) { false } }
    repeat(n) {
        map.add(readLine().toList())
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (map[i][j] == '0') continue // 집이 아니거나
            if (visited[i][j]) continue // 방문 했던거면 진행하지않는다
            visited[i][j] = true
            result.add(bfs(i, j, map, visited))
        }
    }

    result.sort()
    println(result.size)
    for (r in result) println(r)
}

// i,j 위치에 있는 집과 연결된 단지의 개수를 반환
fun bfs(i: Int, j: Int, map: MutableList<List<Char>>, visited: Array<BooleanArray>): Int {
    var count = 0
    val q: Queue<Pair<Int, Int>> = LinkedList()

    q.offer(Pair(i, j))

    while (q.isNotEmpty()) {
        val front = q.poll() ?: break
        count++

        for (dir in 0 until 4) {
            val nextRow = front.first + dr[dir]
            val nextCol = front.second + dc[dir]

            if (nextRow !in 0 until n) continue
            if (nextCol !in 0 until n) continue
            if (map[nextRow][nextCol] == '0') continue
            if (visited[nextRow][nextCol]) continue
            visited[nextRow][nextCol] = true
            q.offer(Pair(nextRow, nextCol))
        }
    }

    return count
}