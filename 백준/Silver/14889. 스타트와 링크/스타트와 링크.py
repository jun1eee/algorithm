import sys
input = sys.stdin.readline
n = int(input())
arr = [list(map(int,input().split())) for _ in range(n)]
visited = [False] * n
ans = float('inf')

def dfs(idx, depth):
    global ans
    
    if depth == n//2:
        start = 0
        link = 0
        for i in range(n):
            for j in range(i+1,n):
                if visited[i] and visited[j]:
                    start += arr[i][j] + arr[j][i]
                elif not visited[i] and not visited[j]:
                    link += arr[i][j] + arr[j][i]
        ans = min(ans, abs(start-link))
        return
    
    for i in range(idx, n):
        visited[i] = True
        dfs(i+1, depth+1)
        visited[i] = False
dfs(0,0)
print(ans)