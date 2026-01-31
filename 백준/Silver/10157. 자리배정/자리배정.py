m, n = map(int,input().split())
num = int(input())
if num > n * m:
    print(0)
    exit()
visited = [[False]*m for _ in range(n)]
dirs = [(1,0),(0,1),(-1,0),(0,-1)]
r, c = 0, 0
dir_idx = 0
for i in range(1,num):
    visited[r][c] = True
    nr, nc = r + dirs[dir_idx][0], c + dirs[dir_idx][1]
    if nr < 0 or nr >= n or nc < 0 or nc >= m or visited[nr][nc]:
        dir_idx = (dir_idx + 1) % 4
        nr, nc = r + dirs[dir_idx][0], c + dirs[dir_idx][1]
    
    r, c = nr, nc
print(c+1, r+1)