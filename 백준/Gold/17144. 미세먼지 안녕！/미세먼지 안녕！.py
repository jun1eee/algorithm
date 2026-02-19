import sys
input = sys.stdin.readline
dirs = [(-1,0),(1,0),(0,-1),(0,1)]
r, c, t = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(r)]

def spread(x,y):
    num = arr[x][y] // 5
    cnt = 0
    
    for dx, dy in dirs:
        nx, ny = x+dx, y+dy
        if 0<=nx<r and 0<=ny<c and arr[nx][ny] != -1:
            move[nx][ny] += num
            cnt += 1
    move[x][y] += arr[x][y] - (num*cnt)

def clean_up(x,y):
    dir = [0,3,1,2]
    d = 0
    while True:
        if d == 4:
            break
        nx = x + dirs[dir[d]][0]
        ny = y + dirs[dir[d]][1]
        if nx < 0 or nx > air or ny < 0 or ny >= c:
            d += 1
            continue
        if nx == air and ny == 0:
            move[x][y] = 0
            break
        move[x][y] = move[nx][ny]
        x, y = nx, ny

def clean_down(x,y):
    dir = [1,3,0,2]
    d = 0
    while True:
        if d == 4:
            break
        nx = x + dirs[dir[d]][0]
        ny = y + dirs[dir[d]][1]
        if nx <= air or nx >= r or ny < 0 or ny >= c:
            d += 1
            continue
        if nx == air + 1 and ny == 0:
            move[x][y] = 0
            break
        move[x][y] = move[nx][ny]
        x, y = nx, ny

air = 0
for i in range(r):
    if arr[i][0] == -1:
        air = i
        break

for _ in range(t):
    arr[air][0] = arr[air+1][0] = -1
    move = [[0] * c for _ in range(r)]
    for i in range(r):
        for j in range(c):
            if arr[i][j] > 0:
                spread(i,j)
    clean_up(air-1,0)
    clean_down(air+2,0)
    arr = move

result = 0
for i in arr:
    result += sum(i)
print(result)
    