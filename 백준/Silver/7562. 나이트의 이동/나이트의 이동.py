from collections import deque
t = int(input())
dirs = [(-1,-2),(-2,-1),(-1,2),(-2,1),(1,-2),(2,-1),(1,2),(2,1)]
for _ in range(t):
    n = int(input())
    sr, sc = map(int, input().split())
    er, ec = map(int, input().split())
    visited = [[False] * n for _ in range(n)]
    visited[sr][sc] = True
    q = deque()
    q.append((sr,sc, 0))
    while q:
        r, c, dist= q.popleft()
        if r == er and c == ec:
            print(dist)
            break    
        for dr, dc in dirs:
            nr, nc = r + dr, c + dc
            if 0 > nr or n <= nr or 0 > nc or n <= nc:
                continue
            if not visited[nr][nc]:
                visited[nr][nc] = True
                q.append((nr,nc,dist+1))