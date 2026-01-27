from collections import deque
n, k = map(int, input().split())
INF = float('inf')
dist = [INF] * 200001
min_cnt = INF
q = deque()
q.append((n,0))
dist[n] = 0
while q:
    cur, cnt = q.popleft()
    if cur == k:
        min_cnt = cnt
        break
    if 0 <= 2*cur <= 200000 and dist[2*cur] == INF:
        dist[2*cur] = cnt
        q.appendleft((2*cur, cnt))
    
    if 0 <= cur-1 <= 200000 and dist[cur -1] == INF:
        dist[cur-1] = cnt+1
        q.append((cur-1, cnt+1))
    
    if 0 <= cur+1 <= 200000 and dist[cur + 1] == INF:
        dist[cur+1] = cnt+1
        q.append((cur+1, cnt+1))
print(min_cnt)
