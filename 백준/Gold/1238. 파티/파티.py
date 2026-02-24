import sys
import heapq
imput = sys.stdin.readline

def dijkstra(start, graph, n):
    pq = []
    heapq.heappush(pq,(0,start))
    dist = [float('inf')] * (n+1)
    dist[start] = 0
    while pq:
        distance, cur = heapq.heappop(pq)
        if dist[cur] < distance:
            continue
        for v, w in graph[cur]:
            cost = distance + w
            if cost < dist[v]:
                dist[v] = cost
                heapq.heappush(pq, (cost,v))
    return dist

n, m, x = map(int,input().split())
graph = [[] for _ in range(n+1)]
reverse_graph = [[] for _ in range(n+1)]
for _ in range(m):
    s, e, t = map(int,input().split())
    graph[s].append((e,t))
    reverse_graph[e].append((s,t))

dist_from_x = dijkstra(x, graph, n)
dist_to_x = dijkstra(x, reverse_graph,n)

ans = 0
for i in range(1,n+1):
    ans = max(ans, dist_to_x[i] + dist_from_x[i])
print(ans)