import sys
from itertools import permutations
input = sys.stdin.readline
n, k = map(int,input().split())
arr = list(map(int,input().split()))
ans = 0
for perm in permutations(arr):
    weight = 500
    check = True
    
    for kit in perm:
        weight += kit - k
        if weight < 500:
            check = False
            break
    if check:
        ans += 1
print(ans)

# visited = [False] * n
# ans = 0
# def dfs(day, weight):
#     global ans
#     if day == n:
#         ans += 1
#         return
#     for i in range(n):
#         if not visited[i]:
#             next_weight = weight + arr[i] - k
#             if next_weight < 500:
#                 continue
#             visited[i] = True
#             dfs(day+1, next_weight)
#             visited[i] = False
# dfs(0,500)
# print(ans)