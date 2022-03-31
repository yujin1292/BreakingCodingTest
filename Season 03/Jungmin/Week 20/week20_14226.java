// 14226 이모티콘

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class EmojiState {
    int curEmojiCnt;    // 화면에 있는 이모티콘 개수
    int clipboard;  // 클립보드에 복사된 이모티콘 개수
    int time;   // 경과된 시간

    EmojiState(int curEmojiCnt, int clipboard, int time) {
        this.curEmojiCnt = curEmojiCnt;
        this.clipboard = clipboard;
        this.time = time;
    }
}


public class week20_14226 {

    public static int S;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());

        visited = new boolean[10001][10001];
        visited[1][0] = true;

        EmojiState emoji = new EmojiState(1, 0, 0);
        bfs(emoji);

    }

    public static void bfs(EmojiState emoji) {
        Queue<EmojiState> queue = new LinkedList();
        queue.offer(emoji);

        while(!queue.isEmpty()) {
            EmojiState curEmoji = queue.poll();

            if (curEmoji.curEmojiCnt == S) {
                System.out.println(curEmoji.time);
                break;
            }

            for (int i = 0; i < 3; i++) {

                int newCurEmojiCnt = curEmoji.curEmojiCnt;
                int newClipboard = curEmoji.clipboard;
                int newTime = curEmoji.time;

                // 화면에 있는 이모티콘을 모두 복사
                if (i == 0) {
                    newClipboard = newCurEmojiCnt;
                    newTime++;
                }

                // 클립보드에 있는 이모티콘을 화면에 붙여넣기
                else if (i == 1) {
                    if (newClipboard != 0) {
                        newCurEmojiCnt += newClipboard;
                        newTime++;
                    }
                }

                // 화면에 있는 이모티콘 중 하나 삭제
                else {
                    if (newCurEmojiCnt > 0) {
                        newCurEmojiCnt--;
                        newTime++;
                    }
                }

                if (!visited[newCurEmojiCnt][newClipboard]) {
                    visited[newCurEmojiCnt][newClipboard] = true;
                    queue.offer(new EmojiState(newCurEmojiCnt, newClipboard, newTime));
                }
            }
        }
    }
}
