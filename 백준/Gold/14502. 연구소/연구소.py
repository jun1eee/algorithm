from collections import deque
n, m = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(n)]
dirs = [(-1,0),(1,0),(0,-1),(0,1)]
max_cnt = 0
def bfs():
    global max_cnt
    q = deque()
    tmp_arr = [row[:] for row in arr]
    for i in range(n):
        for j in range(m):
            if tmp_arr[i][j] == 2:
                q.append((i,j))
    while q:
        r,c = q.popleft()
        for dr, dc in dirs:
            nr, nc = r+dr, c+dc
            if not(0<=nr<n and 0<=nc<m):
                continue
            if tmp_arr[nr][nc] == 0:
                tmp_arr[nr][nc] = 2
                q.append((nr,nc))                
    cnt = 0
    for i in range(n):
        for j in range(m):
            if tmp_arr[i][j] == 0:
                cnt += 1
    max_cnt = max(max_cnt,cnt)
    
def back(depth):
    if depth == 3:
        bfs()
        return
    for i in range(n):
        for j in range(m):
            if arr[i][j] == 0:
                arr[i][j] = 1
                back(depth+1)
                arr[i][j] = 0
back(0)
print(max_cnt)