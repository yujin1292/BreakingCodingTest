import java.util.*

var N = 0
var M = 0

val dc = arrayListOf(-1, 1, 0, 0)
val dr = arrayListOf(0, 0, 1, -1)

// 특정 방향에 맞춰 굴린 후의 리스트를 반환한다. 답일 경우에는 비어있는 리스트를, 답이 절대될수없을경우 null을 반환
fun move(list: MutableList<MutableList<Char>>, dir: Int): MutableList<MutableList<Char>>? {
    val map = mutableListOf<MutableList<Char>>()
    list.forEach { map.add(it.toMutableList()) }
    var red = Pair(0, 0)
    var blue = Pair(0, 0)
    for (i in 0 until N) {
        for (j in 0 until M) {
            if (map[i][j] == 'R') red = Pair(i, j)
            if (map[i][j] == 'B') blue = Pair(i, j)
        }
    }

    var isRedOut = false
    var isBlueOut = false

    // move( 'R', {1,1} ) 형태로 실행 하는 함수안의 미니 함수 (= 익명함수 코틀린의 장점..)
    // 'R'을 방향에 맞춰서 굴림
    val move: (Char, Pair<Int, Int>) -> Unit = { it, pos ->
        var next = Pair(pos.first + dc[dir], pos.second + dr[dir])
        while (next.first in 0 until N && next.second in 0 until M) {
            if (map[next.first][next.second] == 'O') {
                if (it == 'B') isBlueOut = true
                if (it == 'R') isRedOut = true
                map[pos.first][pos.second] = '.'
                break
            } else if (map[next.first][next.second] != '.') {
                val stop = Pair(next.first - dc[dir], next.second - dr[dir])
                map[pos.first][pos.second] = '.'
                map[stop.first][stop.second] = it
                break
            }
            next = Pair(next.first + dc[dir], next.second + dr[dir])
        }
    }


    // 방향은 순서대로 아래 위 오 왼
    // 방향에 맞춰서 놓인 위치에 따라 굴려야하는 구슬의 순서가 달라 요렇게 표현
    when (dir) {
        0 -> {
            if (red.first < blue.first) {
                move('R', red)
                move('B', blue)
            } else {
                move('B', blue)
                move('R', red)
            }
        }
        1 -> {
            if (red.first < blue.first) {
                move('B', blue)
                move('R', red)
            } else {
                move('R', red)
                move('B', blue)
            }
        }
        2 -> {
            if (red.second < blue.second) {
                // blue first
                move('B', blue)
                move('R', red)

            } else {
                move('R', red)
                move('B', blue)
            }

        }
        3 -> {
            if (red.second < blue.second) {
                // red first
                move('R', red)
                move('B', blue)

            } else {
                move('B', blue)
                move('R', red)
            }
        }
    }

    if (isBlueOut) return null
    if (isRedOut) return mutableListOf()
    return map
}

fun main() = with(Scanner(System.`in`)) {

    N = nextInt()
    M = nextInt()
    nextLine() // 아니 nextInt 하고나서 nextLine 하니까 공백이들어오길래 ;

    val map = mutableListOf<MutableList<Char>>() // 2차원 리스트
    for (i in 0 until N) map.add(nextLine().toMutableList())

    var answer = -1
    var count = 1

    // bfs를 위한 queue
    val q: Queue<MutableList<MutableList<Char>>> = LinkedList()

    // 현재 상태를 string 으로 변환 시켜서 중복이 있는지 체크한다!
    val visited = mutableSetOf<String>()
    visited.add(map.toString())
    q.offer(map)

    // 전형적인 bfs 진행!
    while (q.isNotEmpty()) {
        val size = q.size
        for (i in 0 until size) {
            // q가 empty 일때 poll 연산을하면 null 을 반환하는데,
            // ?: 연산자는 아래와 같이 실행된다
            // nul ?: do_something 일때 do_something 을 실행
            val front = q.poll() ?: break

            for (dir in 0..3) {
                val moved = move(front, dir) ?: continue
                if (moved.isEmpty()) { // 빨간 구슬이 구멍에 들어갔음!
                    q.clear()
                    answer = count
                    break
                }

                if (visited.contains(moved.toString())) continue
                visited.add(moved.toString())
                q.offer(moved)
            }
        }
        count++
        if (count > 10) break
    }

    print(answer)
}