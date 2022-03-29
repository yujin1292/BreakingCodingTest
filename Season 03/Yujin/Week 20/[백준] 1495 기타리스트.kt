import java.io.BufferedReader
import java.io.InputStreamReader

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (N, S, M) = readLine().split(" ").map { it.toInt() }

    val volume = mutableListOf(0)
    volume.addAll(readLine().split(" ").map { it.toInt() })

    // isPossible[i][v] -> i 번째 노래에서 v 의 볼륨이 송출 가능한지
    val isPossible = List(N + 1) { MutableList(M + 1) { false } }
    isPossible[0][S] = true

    for (track in 0 until N) {
        for (vol in 0..M) {
            if (isPossible[track][vol]) {
                // 다음 track 계산
                val increasedVolume = vol + volume[track + 1]
                val decreasedVolume = vol - volume[track + 1]

                if (increasedVolume in 0..M) isPossible[track + 1][increasedVolume] = true
                if (decreasedVolume in 0..M) isPossible[track + 1][decreasedVolume] = true
            }
        }
    }

    // 최대값을 구해야 하니 M 부터 하나씩 찾아내려감
    for (vol in M downTo 0 ) {
        if (isPossible[N][vol]) {
            println(vol)
            return@with // 화면 출력 후 함수 종료
        }
    }

    // 송출못하는 경우
    println(-1)
}

