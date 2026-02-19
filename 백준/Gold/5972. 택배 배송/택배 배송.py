import sys
import heapq
def dijkstra(start):
    pq = []
    dist[start] = 0
    heapq.heappush(pq,(0,start))
    while pq:
        distance, cur = heapq.heappop(pq)
        if dist[cur] < distance:
            continue
        for v, w in graph[cur]:
            cost = distance + w
            if cost < dist[v]:
                dist[v] = cost
                heapq.heappush(pq,(cost, v))
        
input = sys.stdin.readline
n, m = map(int,input().split())
graph = [[] for _ in range(n+1)]
dist = [float('inf')] * (n+1)
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))
dijkstra(1)
print(dist[n])