n, d, k, c = map(int, input().split())
arr = [int(input()) for _ in range(n)]
res = 0

for i in range(n):
    if i + k > n:
        tmp = len(set(arr[i:n]+arr[:(i+k)%n]+[c]))
    else:
        tmp = len(set(arr[i:i+k]+[c]))
    res = max(res, tmp)

print(res)