from collections import defaultdict
n, d, k, c = map(int, input().split())
arr = [int(input()) for _ in range(n)]
arr = arr + arr[:k-1]
left, right = 0,0
dict = defaultdict(int)
dict[c] += 1

while right < k:
    dict[arr[right]] += 1
    right += 1

max_sushi = len(dict)
for _ in range(n-1):
    dict[arr[right]] += 1
    dict[arr[left]] -= 1
    if dict[arr[left]] == 0:
        dict.pop(arr[left])
    right += 1
    left += 1
    max_sushi = max(max_sushi, len(dict))
print(max_sushi)