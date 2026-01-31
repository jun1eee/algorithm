h, w = map(int, input().split())
arr = list(map(int, input().split()))
ans = 0
for i in range(1,w-1):
    tmp = min(max(arr[:i]),max(arr[i+1:]))
    water = tmp - arr[i]
    water = max(water, 0)
    ans += water 
print(ans)