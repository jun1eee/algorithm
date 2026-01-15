from collections import defaultdict
n, k = map(int, input().split())
nums = list(map(int, input().split()))
left, right = 0, 0
dic = defaultdict(int)

ans = 0
while True:
    if right == n:
        break
    if dic[nums[right]] >= k:
        dic[nums[left]] -= 1
        left += 1
    else:
        dic[nums[right]] += 1
        right += 1
    ans = max(ans, right-left)
print(ans)