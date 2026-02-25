import sys
input = sys.stdin.readline
T = int(input())
for _ in range(T):
    n, k, t, m = map(int,input().split())
    scores = {i:[0]*(k+1) for i in range(1,n+1)}
    total = [0] * (n+1)
    cnt = [0] * (n+1)
    order = [0] * (n+1)
    for index in range(m):
        i, j, s = map(int,input().split())
        if s > scores[i][j]:
            total[i] += s - scores[i][j]
            scores[i][j] = s
        # scores[i][j] = max(scores[i][j], s)
        cnt[i] += 1
        order[i] = index
    print(sorted(scores, key=lambda x: (-total[x], cnt[x], order[x])).index(t) + 1)
        