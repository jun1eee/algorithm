import sys
input = sys.stdin.readline
nums = list(map(int,input().rstrip()))
cnt = [0] * 10
for n in nums:
    cnt[n] += 1
max_cnt = -1
for i in range(10):
    if i == 6 or i == 9:
        continue
    max_cnt = max(max_cnt, cnt[i])
print(max(max_cnt, (cnt[6] + cnt[9] + 1)//2))
