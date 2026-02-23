import sys
input = sys.stdin.readline
n, m = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(n)]
dirs = [(1,-1),(1,0),(1,1)]
dp = [[[float('inf')]*3 for _ in range(m)] for _ in range(n)]
for j in range(m):
    dp[0][j][0] = dp[0][j][1] = dp[0][j][2] = arr[0][j]

for i in range(1,n):
    for j in range(m):
        pj = j + 1
        if 0 <= pj < m:
            dp[i][j][0] = min(dp[i][j][0], arr[i][j] + min(dp[i-1][pj][1], dp[i-1][pj][2]))
        
        pj = j
        if 0 <= pj < m:
            dp[i][j][1] = min(dp[i][j][1], arr[i][j] + min(dp[i-1][pj][0], dp[i-1][pj][2]))
        
        pj = j - 1
        if 0 <= pj < m:
            dp[i][j][2] = min(dp[i][j][2], arr[i][j] + min(dp[i-1][pj][0], dp[i-1][pj][1]))
ans = float('inf')
for j in range(m):
    ans = min(ans, dp[n-1][j][0], dp[n-1][j][1], dp[n-1][j][2])
print(ans)