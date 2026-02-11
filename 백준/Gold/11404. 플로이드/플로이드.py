import sys
input = sys.stdin.readline
n = int(input())
m = int(input())
INF = float('inf')
dist = [[INF]*(n+1) for _ in range(n+1)]

for i in range(1,n+1):
    dist[i][i] = 0
    
for i in range(1,m+1):
    x, y, z = map(int,input().split())
    dist[x][y] = min(dist[x][y], z)

for k in range(1,n+1):
    for i in range(1,n+1):  
        for j in range(1,n+1):
            dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

for i in range(1,n+1):
    for j in range(1,n+1):
        if dist[i][j] == INF:
            print(0, end=" ")
        else:
            print(dist[i][j], end=" ")
    print()