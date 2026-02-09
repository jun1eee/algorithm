import sys
from collections import deque
input = sys.stdin.readline
n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)
visited = [False] * (n+1)
def bfs(x):
    q = deque()
    q.append(x)
    visited[x] = True
    while q:
        cur = q.popleft()
        for nxt in graph[cur]:
            if not visited[nxt]:
                visited[nxt] = True
                q.append(nxt)
cnt = 0
for i in range(1,n+1):
    if not visited[i]:
        bfs(i)
        cnt += 1
print(cnt)
            
# import sys 
# input = sys.stdin.readline
# n, m = map(int,input().split())
# graph = [[] for _ in range(n+1)]

# for _ in range(m):
#     u, v = map(int, input().split())
#     graph[u].append(v)
#     graph[v].append(u)

# visited = [False] * (n+1)

# def dfs(x):
#     visited[x] = True
#     for nxt in graph[x]:
#         if not visited[nxt]:
#             dfs(nxt)
# cnt = 0
# for i in range(1,n+1):
#     if not visited[i]:
#         dfs(i)
#         cnt += 1
# print(cnt)