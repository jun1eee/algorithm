import sys
from collections import deque
input = sys.stdin.readline
n = int(input())
graph = [[] for _ in range(n+1)]
for _ in range(n-1):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

parent = [0]*(n+1)
q = deque()
q.append(1)
parent[1] = -1

while q:
    cur = q. popleft()
    for nxt in graph[cur]:
        if parent[nxt] == 0:
            parent[nxt] = cur
            q.append(nxt)

for i in range(2,n+1):
    print(parent[i])