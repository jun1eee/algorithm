n, d = map(int, input().split())
shortcut = [tuple(map(int, input().split())) for _ in range(n)]
shortcut.sort()
dp = [i for i in range(d+1)]

k = 0
for i in range(d+1):
    if i > 0:
        dp[i] = min(dp[i-1] + 1, dp[i])

    while k < n and shortcut[k][0] == i:
        if shortcut[k][1] <= d:
            dp[shortcut[k][1]] = min(dp[shortcut[k][1]], dp[i] + shortcut[k][2])
        k += 1

print(dp[d])