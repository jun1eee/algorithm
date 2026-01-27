n, k = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
dp = [0] * (k+1)
for w, v in arr:
    for i in range(k,w-1,-1):
        dp[i] = max(dp[i], dp[i-w] + v)
print(max(dp))

# n, k = map(int, input().split())
# arr = [list(map(int, input().split())) for _ in range(n)]
# max_value = -1
# def dfs(depth, weight, value):
#     global max_value
#     if weight > k:
#         return
#     if depth == n:
#         if value > max_value:
#             max_value = value
#         return
#     w, v = arr[depth]
#     dfs(depth+1, weight + w, value + v)
#     dfs(depth+1, weight, value)
# dfs(0,0,0)
# print(max_value)