from collections import deque
n, m = map(int, input().split())
arr = [list(map(int, input())) for _ in range(n)]
dist = [[[-1] * 2 for _ in range(m)] for _ in range(n)]
dirs = [(-1,0),(1,0),(0,-1),(0,1)]
q = deque()
q.append((0,0,0))
dist[0][0][0] = 1
while q:
    r, c, cnt = q.popleft()
    if r == n-1 and c == m -1:
        print(dist[r][c][cnt])
        exit()
    for dr, dc in dirs:
        nr, nc = r + dr, c + dc
        if 0 > nr or n <= nr or 0 > nc or m <= nc:
            continue
        if arr[nr][nc] == 0 and dist[nr][nc][cnt] == -1:
            dist[nr][nc][cnt] = dist[r][c][cnt] + 1   
            q.append((nr,nc,cnt))
        elif arr[nr][nc] == 1 and dist[nr][nc][1] == -1 and cnt == 0:
            dist[nr][nc][1] = dist[r][c][0] + 1
            q.append((nr,nc,1))
print(-1)