import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, m) = readLine().split(" ").map { it.toInt() }


    val graph = Array(n + 1) { mutableListOf<Int>() }
    val inDegree = Array(n + 1) { 0 }

    repeat(m) {
        val (before, now) = readLine().split(" ").map { it.toInt() }
        graph[before].add(now)
        inDegree[now]++
    }

    // topology sort ( 위상 정렬 )

    val result = Array(n + 1) { 0 }
    val q: Queue<Int> = LinkedList()

    for (i in 1..n) {
        if (inDegree[i] == 0) q.offer(i)
    }


    for(i in 1..n){
        if( q.isEmpty()) return // 그럴일은 없을듯

        val front = q.poll()
        result[i] = front

        for(next in graph[front]){
            inDegree[next]--
            if( inDegree[next] == 0){
                q.offer(next)
            }
        }
    }


    for( i in 1.. n){
        print("${result[i]} ")
    }
}