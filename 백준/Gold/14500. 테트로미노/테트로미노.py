n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
visited = [[False]*m for _ in range(n)]
dirs = [(-1,0),(1,0),(0,-1),(0,1)]
ans = 0
def dfs(r, c, depth, total):
    global ans
    if depth == 4:
        ans = max(ans, total)
        return
    for dr, dc in dirs:
        nr = r + dr
        nc = c + dc
        if 0 <= nr < n and 0 <= nc < m and not visited[nr][nc]:
            visited[nr][nc] = True
            dfs(nr, nc, depth + 1, total + arr[nr][nc])
            visited[nr][nc] = False

def check_T(r, c):
    global ans
    s = arr[r][c]
    tmp = []
    for dr, dc in dirs:
        nr = r + dr
        nc = c + dc
        if 0 <= nr < n and 0 <= nc < m:
            tmp.append(arr[nr][nc])
    if len(tmp) >= 3:
        tmp.sort(reverse=True)
        ans = max(ans, s + tmp[0] + tmp[1] + tmp[2])

for i in range(n):
    for j in range(m):
        visited[i][j] = True
        dfs(i, j, 1, arr[i][j])
        visited[i][j] = False

        check_T(i, j)

print(ans)