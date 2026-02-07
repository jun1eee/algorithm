n, m = map(int,input().split())
r, c, d = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(n)]
visited = [[False]*m for _ in range(n)]
dirs = [(-1,0),(0,1),(1,0),(0,-1)]
# dirs = {0:(-1,0),1:(0,1),2:(1,0),3:(0,-1)}
ans = 0

while True:
    if arr[r][c] == 0 and not visited[r][c]:
        visited[r][c] = True
        ans += 1
    check = True
    for dr, dc in dirs:
        nr, nc = r+dr, c+dc
        if arr[nr][nc] == 0 and not visited[nr][nc]:
            check = False
            break
    if not check:
        for _ in range(4):
            d = (d+3) % 4
            nr, nc = r+dirs[d][0], c+dirs[d][1]
            if arr[nr][nc] == 0 and not visited[nr][nc]:
                r, c = nr, nc
                break
    else:
        nr, nc = r-dirs[d][0], c-dirs[d][1]
        if 0<=nr<n and 0<=nc<m and arr[nr][nc] == 0:
            r, c = nr, nc
        else:
            break
print(ans)