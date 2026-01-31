n, k = map(int,input().split())
arr = [i for i in range(1,n+1)]
ans = []
index = 0
for _ in range(n):
    index = (index + k - 1) % len(arr)
    ans.append(str(arr.pop(index)))
print("<"+", ".join(ans)+">")