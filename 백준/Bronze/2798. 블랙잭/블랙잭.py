import sys
input = sys.stdin.readline
n, m = map(int,input().split())
nums = list(map(int,input().split()))

answer = 0

for i in range(n):
    for j in range(i + 1, n):
        for k in range(j + 1, n):
            total = nums[i] + nums[j] + nums[k]
            if total <= m:
                answer = max(answer, total)

print(answer)