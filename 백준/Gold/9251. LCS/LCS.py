import sys
input = sys.stdin.readline
A = input().rstrip()
B = input().rstrip()
n, m = len(A), len(B)
dp =[[0]*(m+1) for _ in range(n+1)]
for i in range(1,n+1):
    a = A[i-1]
    for j in range(1,m+1):
        # dp[i][j] = A의 앞 i글자, B의 앞 j글자의 LCS 길이
        if a == B[j-1]:
            dp[i][j] = dp[i-1][j-1] + 1
        else:
            dp[i][j] = max(dp[i-1][j],dp[i][j-1])
print(dp[n][m])