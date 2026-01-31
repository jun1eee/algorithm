from collections import defaultdict
n, k = map(int, input().split())
dict = defaultdict(int)
for _ in range(n):
    s, y = map(int, input().split())
    dict[(s,y)] += 1
ans = 0
for y in range(1,7):
   ans += (dict[(0,y)]+k-1)//k + (dict[(1,y)]+k-1)//k
print(ans)