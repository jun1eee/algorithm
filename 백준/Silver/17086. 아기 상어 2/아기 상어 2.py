from collections import deque
n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
dirs = [(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]
dist = [[-1] * m for _ in range(n)]
q = deque()
for i in range(n):
    for j in range(m):
        if arr[i][j] == 1:
            q.append((i,j))
            dist[i][j] = 0
while q:
    r, c = q.popleft()
    for dr, dc in dirs:
        nr, nc = r + dr, c + dc
        if 0 > nr or n <= nr or 0 > nc or m <= nc:
            continue
        if dist[nr][nc] == -1:
            dist[nr][nc] = dist[r][c] + 1
            q.append((nr,nc))
max_dist = 0
for i in range(n):
    for j in range(m):
        max_dist = max(max_dist, dist[i][j])
print(max_dist)