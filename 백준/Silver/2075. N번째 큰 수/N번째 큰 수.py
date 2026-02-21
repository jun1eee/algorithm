import sys
import heapq
input = sys.stdin.readline
n = int(input())
hq = []
for _ in range(n):
    nums = list(map(int,input().split()))
    for num in nums:
        if len(hq) < n:
            heapq.heappush(hq,num)
        else:
            if num > hq[0]:
                heapq.heapreplace(hq,num)
print(hq[0])