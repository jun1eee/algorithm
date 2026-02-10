import sys
input = sys.stdin.readline
n = int(input())
cost = [list(map(int, input().split())) for _ in range(n)]
# dp[i][0]: i번째 집을 R로 칠했을 때 최소 비용
# dp[i][1]: i번째 집을 G로
# dp[i][2]: i번째 집을 B로
dp = [[0]*3 for _ in range(n)]

# 초기값 (0번째 집)
dp[0][0] = cost[0][0]
dp[0][1] = cost[0][1]
dp[0][2] = cost[0][2]

# 점화식 적용
for i in range(1, n):
    dp[i][0] = cost[i][0] + min(dp[i-1][1], dp[i-1][2])
    dp[i][1] = cost[i][1] + min(dp[i-1][0], dp[i-1][2])
    dp[i][2] = cost[i][2] + min(dp[i-1][0], dp[i-1][1])

print(min(dp[n-1]))
