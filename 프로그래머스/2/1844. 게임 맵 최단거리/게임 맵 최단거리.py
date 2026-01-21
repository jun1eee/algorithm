from collections import deque
def solution(maps):
    answer = 0
    n = len(maps)
    m = len(maps[0])
    visited = [[False]*m for _ in range(n)]
    dirs = [(-1,0),(1,0),(0,-1),(0,1)]
    q = deque()
    q.append((0,0,1))
    visited[0][0] = True
    def bfs():
        while q:
            r, c, dist = q.popleft()
            if r == n-1 and c == m-1:
                return dist
            for dr, dc in dirs:
                nr, nc = r + dr, c + dc
                if not(0<=nr<n and 0<=nc<m):
                    continue
                if maps[nr][nc] == 1 and not visited[nr][nc]:
                    visited[nr][nc] = True
                    q.append((nr,nc,dist+1))
        return -1
    answer = bfs()
    return answer