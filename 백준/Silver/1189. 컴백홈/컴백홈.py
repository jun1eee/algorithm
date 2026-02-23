import sys
input = sys.stdin.readline
r, c, k = map(int,input().split())
arr = [input().rstrip() for _ in range(r)]
visited = [[False]*c for _ in range(r)]
dirs = [(-1,0),(1,0),(0,-1),(0,1)]
cnt = 0
def dfs(x, y, dist):
    global cnt
    if x == 0 and y == c-1 and dist == k:
        cnt += 1
        return
    for dr, dc in dirs:
        nr, nc = x + dr, y +  dc
        if 0<=nr<r and 0<=nc<c and not visited[nr][nc] and arr[nr][nc] != 'T':
            visited[nr][nc] = True
            dfs(nr, nc, dist+1)
            visited[nr][nc] = False
visited[r-1][0] = True
dfs(r-1,0,1)
print(cnt)