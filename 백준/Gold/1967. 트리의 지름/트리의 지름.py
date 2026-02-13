import sys
from collections import deque
input = sys.stdin.readline
n = int(input())
graph = [[] for _ in range(n+1)]

for _ in range(n-1):
    u,v,d = map(int,input().split())
    graph[u].append((v,d))
    graph[v].append((u,d))

def bfs(start):
    q = deque([start])
    visited = [-1] * (n+1)
    visited[start] = 0
    while q:
        cur = q.popleft()
        for next, next_dist in graph[cur]:
            if visited[next] == -1:
                visited[next] = visited[cur] + next_dist
                q.append(next)
    m = max(visited)
    return [visited.index(m), m]
print(bfs(bfs(1)[0])[1])    