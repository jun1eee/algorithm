from collections import deque
m, n = map(int,input().split())
num = int(input())
if num > n * m:
    print(0)
    exit()
seats = [[0]*m for _ in range(n)]
dirs = [(1,0),(0,1),(-1,0),(0,-1)]
q = deque()
q.append((0,0,1))
seats[0][0] = 1
dirs_index = 0
while q:
    r, c, cnt = q.popleft()
    if cnt == num:
        print(c+1, r+1)
        break
    nr, nc = r + dirs[dirs_index][0], c + dirs[dirs_index][1]
    if 0<= nr <n and 0<= nc < m and seats[nr][nc] == 0:
        seats[nr][nc] = cnt + 1
        q.append((nr,nc,cnt + 1))
    else:
        dirs_index = (dirs_index + 1) % 4
        nr, nc = r + dirs[dirs_index][0], c + dirs[dirs_index][1]
        seats[nr][nc] = cnt + 1
        q.append((nr,nc,cnt + 1))