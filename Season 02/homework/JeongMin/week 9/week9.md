# Week 9

## **최단 거리**

### **Dijkstra 알고리즘**

- BFS와 DP를 활용한 **최단경로 탐색 알고리즘**
- 그래프 내부 하나의 정점(Vertex)에서 다른 모든 정점으로 가는 최단경로를 알려줌
- 그래프의 간선(Edge)마다 가중치가 존재할 때 사용

```java
/*
sample input
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
 */
```

```java
// 도착 지점과, 도착지점으로 가는 비용을 의미하는 클래스를 정의한다.
class Node {
	int idx;
	int cost;

	// 생성자
	Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}
}

public class Dijkstra {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 노드와 간선의 개수
		int V = sc.nextInt();
		int E = sc.nextInt();
		// 출발지점
		int start = sc.nextInt();

		// 1. 인접리스트를 이용한 그래프 초기화
		ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
		// 노드의 번호가 1부터 시작하므로, 0번 인덱스 부분을 임의로 만들어 놓기만 한다.
		for (int i = 0; i < V + 1; i++) {
			graph.add(new ArrayList<>());
		}
		// 그래프에 값을 넣는다.
		for (int i = 0; i < E; i++) {
			// a로 부터 b로 가는 값은 cost이다.
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();

			graph.get(a).add(new Node(b, cost));
		}

		// 2. 방문 여부를 확인할 boolean 배열, 
		//start 노드부터 end 노드 까지의 최소 거리를 저장할 배열을 만든다.
		boolean[] visited = new boolean[V + 1];
		int[] dist = new int[V + 1];

		// 3. 최소 거리 정보를 담을 배열을 초기화 한다.
		for (int i = 0; i < V + 1; i++) {
			// 출발 지점 외 나머지 지점까지의 최소 비용은 최대로 지정해둔다.
			dist[i] = Integer.MAX_VALUE;
		}
		// 출발 지점의 비용은 0으로 시작한다.
		dist[start] = 0;

		// 4. 다익스트라 알고리즘을 진행한다.
		// 모든 노드을 방문하면 종료하기 때문에, 노드의 개수 만큼만 반복을 한다.
		for (int i = 0; i < V; i++) {
			// 4 - 1. 현재 거리 비용 중 최소인 지점을 선택한다.
			// 해당 노드가 가지고 있는 현재 비용.
			int nodeValue = Integer.MAX_VALUE;
			// 해당 노드의 인덱스(번호).
			int nodeIdx = 0;
			// 인덱스 0은 생각하지 않기 때문에 0부터 반복을 진행한다.
			for (int j = 1; j < V + 1; j++) {
				// 해당 노드를 방문하지 않았고, 현재 모든 거리비용 중 최솟값을 찾는다.
				if (!visited[j] && dist[j] < nodeValue) {
					nodeValue = dist[j];
					nodeIdx = j;
				}
			}
			// 최종 선택된 노드를 방문처리 한다.
			visited[nodeIdx] = true;

			// 4 - 2. 해당 지점을 기준으로 인접 노드의 최소 거리 값을 갱신한다.
			for (int j = 0; j < graph.get(nodeIdx).size(); j++) {
				// 인접 노드를 선택한다.
				Node adjNode = graph.get(nodeIdx).get(j);
				// 인접 노드가 현재 가지는 최소 비용과
				// 현재 선택된 노드의 값 + 현재 노드에서 인접 노드로 가는 값을 비교하여 
				// 더 작은 값으로 갱신한다.
				if (dist[adjNode.idx] > dist[nodeIdx] + adjNode.cost) {
					dist[adjNode.idx] = dist[nodeIdx] + adjNode.cost;
				}
			}
		}

		// 5. 최종 비용을 출력한다.
		for (int i = 1; i < V + 1; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
		sc.close();
	}
}
```

### **Floyd Warshall 알고리즘**

- 음수 사이클만 없다면 음의 가중치를 갖는 간선이 존재할 수 있음
    - 음수 사이클 : 사이클의 모든 경로를 지나 원래 지점으로 돌아왔을 때, 최종적인 비용이 음수가 되는 경우

```jsx
/*
sample input(첫 번째 숫자는 노드의 개수, 두 번째 숫자는 간선의 개수)
5
8
0 1 5
0 4 1
0 2 7
0 3 2
1 2 3
1 3 6
2 3 10
3 4 4
 */
```

```java
public class Floyd {
	static int N, M;
	static int[][] dist;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		// 플로이드 초기 거리 테이블 초기화
		dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 자기 자신으로 가는 길은 최소 비용이 0이다
				if (i == j) {
					dist[i][j] = 0;
					continue;
				}
				// 자기 자신으로 가는 경우를 제외하고는 매우 큰 값
				// (N개의 노드를 모두 거쳐서 가더라도 더 큰 값)
				dist[i][j] = 100_000_000;
			}
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			// 가는 경로가 하나가 아닐 수 있다. 따라서 그 중 최소 비용을 저장해두면 된다.
			dist[a][b] = Math.min(dist[a][b], cost);
			dist[b][a] = Math.min(dist[b][a], cost);
		}

		// 플로이드 워셜 알고리즘
		// 노드를 1개부터 N개까지 거쳐가는 경우를 모두 고려한다
		for (int k = 0; k < N; k++) {
			// 노드 i에서 j로 가는 경우.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// k번째 노드를 거쳐가는 비용이 기존 비용보다 더 작은 경우 갱신
					// 또는 연결이 안되어있던 경우(INF) 연결 비용 갱신
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		// 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 연결이 안되어 있는 경우
				if (dist[i][j] == 100_000_000) {
					System.out.print("INF ");
				} else {
					System.out.print(dist[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}
```

### **Bellman-Ford 알고리즘**

- **Dijkstra** 알고리즘의 한계를 해결
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7b3d0726-e26b-4d0a-87a8-8c89a3be07e1/Untitled.png)
    
    - A → B → C : cost = 3
    - A → C : cost = 5
    - B를 거쳐서 가는 것이 최단거리 비용이지만, **Dijkstra** 알고리즘에서는 최단거리를 5로 확정
- 각 정점들을 돌아가면서 해당 정점의 간선들을 탐색
- 맨 처음은 시작점부터 탐색
- 간선의 가중치 + 시작점에서 정점까지의 거리 ≤ 해당 간선이 도달하고자 하는 정점의 기존 거리 → 업데이트
- **d[T] <= d[S] + w(S,T)**
    - T : 해당 간선이 도달하고자 하는 정점
    - S : 해당 간선의 시작점
    - d : 시작점에서 해당 정점의 거리
    - w : 해당 간선의 가중치
- v+1번째 탐색을 수행한 뒤 업데이트 되는 값의 존재 여부 발견 = 음수사이클 존재

```java
public class BellmanFord {

    public static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int num = 5;
        int[][] adj = new int[][] {
                {0, -4, 5, 2, 3},
                {INF, 0, INF, -1, INF},
                {INF, INF, 0, -7, INF},
                {INF, INF, INF, 0, 6},
                {INF, INF, INF, -4, 0},
        };
        int src = 0;
        int dst = 1;

        solve(num, adj, src, dst);
    }

    public static void solve(int num, int[][] adj, int src, int dst) {
        int[] dists = new int[num];
        Arrays.fill(dists, INF);
        dists[src] = 0;

        for(int v=0; v < num; ++v) {
            for(int w=0; w < num; ++w) {
                if(adj[v][w] != INF)
                    dists[w] = Math.min(dists[w], dists[v] + adj[v][w]);
            }
        }

        for(int i=0; i< num; ++i)
            System.out.println(dists[i]);
    }
}
```

### **Dijkstra vs Floyd Warshall**

1. 차이점
- Floyd Warshall은 음의 가중치를 갖는 간선이 존재할 수 있음
- Dijkstra는 가장 적은 비용을 가지는 간선을 하나씩 선택하여 알고리즘을 수행
- Floyd Warshall은 거쳐가는 정점을 기준으로 알고리즘을 수행
1. 공통점
- 그래프 내의 각 정점에서 정점까지의 최단 거리를 모두 구할 수 있음

### **Floyd Warshall vs Bellman-Ford**

1. 차이점
- Floyd Warshall 알고리즘은 모든 쌍에 대한 최단경로를 구할 수 있음
- Bellman-Ford 알고리즘은 시작점에서의 최단경로만 알 수 있음
1. 공통점
- 음의 가중치를 갖는 간선이 존재할 수 있음

## **최소 비용**

### **What is `Union Find`?**

- 합집합 찾기, 상호배타적 집합
- 여러 노드가 존재할 때, 두 개의 노드를 선택해서 현재 두 노드가 서로 같은 그래프에 속하는지 판별하는 알고리즘
    - Find : x가 어떤 집합에 포함되어 있는지 찾는 연산
    - Union : x와 y가 포함되어 있는 집합을 합치는 연산 (부모를 합칠 때는 일반적으로 더 작은 값 쪽으로 합침)

```java
public class Union_Find { 

		public static int[] parent = new int[1000001]; 

		public static int find(int x) { 
				if (x == parent[x]) 
						return x; 
				else 
						return parent[x] = find(parent[x]); 
		}
	 
		public static void union(int x, int y) { 
				x = find(x); 
				y = find(y); 

				// 같은 부모를 가지고 있지 않을 때 
				if (x != y) { 
						// y가 x 보다 크다는 것을 가정한다면 아래와 같이 표현 
						parent[y] = x; 

						// 더 작은 값으로 넣어 줄 때 다음과 같이도 표현 가능 
						/* 
							* if(x < y) parent[y] = x; else parent[x] = y; 
						*/ 
				} 
		} 

		// 같은 부모 노드를 가지는지 확인 
		public static boolean isSameParent(int x, int y) {
 
				x = find(x); 
				y = find(y); 

				if (x == y) 
						return true; 
				else 
						return false; 
		} 

		public static void main(String[] args) { 

				for (int i = 1; i <= 8; i++) { 
						parent[i] = i; 
				} 

				union(1, 2); 
				union(2, 3); 

				System.out.println("1과 3은 연결되어 있나요? " + isSameParent(1, 3)); 
		} 
}
```

## **Kruskal's Algorlthm**

- 최소 신장 트리 알고리즘
    - 신장 트리 : 하나의 그래프가 있을 때 모든 노드를 포함하면서 사이클이 존재하지 않는 부분 그래프
- 신장 트리 중에서도 최소한의 비용으로 만들 수 있는 최소 신장 트리를 찾음
- 먼저 그래프의 모든 간선 정보만 빼내어 오름차순 정렬을 수행
- 모든 간선에 대하여 현재의 간선이 사이클을 발생시키지 않는지 확인
- find, union 알고리즘 활용

```java
/*
sample input(첫 줄의 첫 숫자는 정점의 개수, 두 번째 숫자는 간선의 개수).
6 9
1 6 5
2 4 6
1 2 7
3 5 15
5 6 9
3 4 10
1 3 11
2 3 3
4 5 7
 */
```

```java
class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int cost;
    Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        if(this.cost < o.cost)
            return -1;
        else if(this.cost == o.cost)
            return 0;
        else
            return 1;
    }
}
public class Main {
    public static int[] parent;
    public static ArrayList<Edge> edgeList;
	
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y)
            parent[y] = x;
    }
	
    public static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) return true;
        else return false;
    }
    public static void main(String[] args) {
        edgeList = new ArrayList<Edge>();
        edgeList.add(new Edge(1,4,4));
        // ... edgeList에 노드, 간선, 가중치 정보 추가
		
        parent = new int[7];
        for(int i = 1; i <= 6; i++) {
            parent[i] = i;
        }
		
        Collections.sort(edgeList);
		
        int sum = 0;
        for(int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            if(!isSameParent(edge.v1, edge.v2)) {
                sum += edge.cost;
                union(edge.v1, edge.v2);
            }
        }
		
        System.out.println(sum);
    }	
}
```