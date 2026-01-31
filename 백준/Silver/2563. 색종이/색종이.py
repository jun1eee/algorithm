n = int(input())
visited = [[False] * 100 for _ in range(100)]
for _ in range(n):
    row, col = map(int,input().split())
    for r in range(row,row+10):
        if r >= 100:
            break
        for c in range(col,col+10):
            if c >= 100:
                break
            if visited[r][c]:
                continue
            visited[r][c] = True
cnt = 0
for i in range(100):
    for j in range(100):
       if visited[i][j]:
           cnt += 1
print(cnt) 