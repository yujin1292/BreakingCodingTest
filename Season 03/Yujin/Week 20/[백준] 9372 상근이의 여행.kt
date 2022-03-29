import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun getParent(x: Int, parent: IntArray): Int {
    return if (parent[x] == x) x
    else {
        parent[x] = getParent(parent[x], parent)
        parent[x]
    }
}

fun unionParent(a: Int, b: Int, parent: IntArray) {
    val parentA = getParent(a, parent)
    val parentB = getParent(b, parent)

    if (parentA < parentB) parent[parentB] = parentA
    else parent[parentA] = parentB
}

fun isSameParent(a: Int, b: Int, parent: IntArray): Boolean {
    val parentA = getParent(a, parent)
    val parentB = getParent(b, parent)
    return parentA == parentB
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val testcase = readLine().toInt()

    repeat(testcase) {
        // 크루스칼 알고리즘 응용입니다 distance가 모두 1 이라고 생각하면 쉬울듯하네요
        val (n, m) = readLine().split(" ").map { it.toInt() }
        val parent = IntArray(n) { it }
        var answer = 0
        repeat(m) {
            readLine().split(" ").map { it.toInt()-1 }.let {
                if( !isSameParent(it[0], it[1], parent)){
                    answer++
                    unionParent(it[0], it[1], parent)
                }
            }
        }
        bw.write("$answer\n")
    }
    bw.flush()
    bw.close()
}