import sys
input = sys.stdin.readline

n, m = map(int, input().split())
height = list(map(int, input().split()))

lo, hi = 0, max(height)
ans = 0

while lo <= hi:
    mid = (lo + hi) // 2
    wood = 0
    for h in height:
        if h > mid:
            wood += (h - mid)
    if wood >= m:
        ans = mid
        lo = mid + 1
    else:
        hi = mid - 1
print(ans)