import sys
input = sys.stdin.readline
n, k = map(int,input().split())
s = list(input().rstrip())
ans = 0
for i in range(n):
    if s[i] != 'P':
        continue
    left = max(0, i-k)
    right = min(n-1, i+k)

    for j in range(left,right+1):
        if s[j] == 'H':
            s[j] = '.'
            ans += 1
            break
print(ans)