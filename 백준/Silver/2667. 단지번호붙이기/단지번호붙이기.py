from collections import deque
n = int(input())
arr = [list(map(int,input())) for _ in range(n)]
dirs = [(-1,0),(1,0),(0,-1),(0,1)]
visited = [[False] * n for _ in range(n)]
cnt_list = []
def bfs(i,j):
    cnt = 1
    q = deque()
    q.append((i,j))
    visited[i][j] = True
    while q:
        r, c = q.popleft()
        for dr, dc in dirs:
            nr, nc = r + dr, c + dc
            if 0 > nr or n <= nr or 0 > nc or n <= nc:
                continue
            if arr[nr][nc] == 1 and not visited[nr][nc]:
                visited[nr][nc] = True
                cnt += 1
                q.append((nr,nc))
    return cnt
for i in range(n):
    for j in range(n):
        if arr[i][j] == 1 and not visited[i][j]:
            cnt_list.append(bfs(i,j))
print(len(cnt_list))
cnt_list.sort()
for c in cnt_list:
    print(c)