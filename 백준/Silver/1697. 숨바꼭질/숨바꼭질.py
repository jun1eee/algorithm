from collections import deque

N, K = map(int, input().split())
max_num = 10 ** 5
dist = [0] * (max_num + 1)

def bfs():
    q = deque()
    q.append(N)
    while q :
        x = q.popleft()

        if x == K :
            print(dist[x])
            break
        for nx in (x-1, x+1, x*2):
            if 0 <= nx <= max_num and not dist[nx] :
                dist[nx] = dist[x] + 1
                q.append(nx)

bfs()