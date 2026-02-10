n, l = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(n)]
ans = 0
def check(line):
    used = [False]*n
    for i in range(n-1):
        if line[i] == line[i+1]:
            continue
        if abs(line[i]-line[i+1]) > 1:
            return False
        if line[i] > line[i+1]:
            for j in range(i+1, i+1+l):
                if j>=n or line[j]!=line[i+1] or used[j]:
                    return False
                used[j]=True
        else:
            for j in range(i, i-l, -1):
                if j<0 or line[j]!=line[i] or used[j]:
                    return False
                used[j]=True
    return True
for i in range(n):
    if check(arr[i]):
        ans += 1
for j in range(n):
    col = [arr[i][j] for i in range(n)]
    if check(col):
        ans += 1
print(ans)