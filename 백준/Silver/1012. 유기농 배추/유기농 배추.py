from collections import deque
T = int(input())
dirs = [(-1,0),(1,0),(0,-1),(0,1)]

for t in range(T):
    M, N, K = map(int, input().split())
    grid = [[0] * M for _ in range(N)]
    visited = [[False] * M for _ in range(N)]
    for k in range(K):
        j, i = map(int, input().split())
        grid[i][j] = 1
    def bfs(i,j) :
        q = deque()
        q.append((i,j))
        visited[i][j] = True
        while q :
            r,c = q.popleft()
            for dr, dc in dirs:
                nr, nc = r+dr, c+dc
                if 0 > nr or N <= nr or 0 > nc or M <= nc :
                    continue
                if grid[nr][nc] == 1 and not visited[nr][nc]:
                    visited[nr][nc] = True
                    q.append((nr,nc))
    cnt = 0
    for i in range(N):
        for j in range(M):
            if grid[i][j] == 1 and not visited[i][j] :
                cnt += 1
                bfs(i,j)
    print(cnt)
