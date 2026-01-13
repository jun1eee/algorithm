from collections import deque
n = int(input())
grid = [list(input()) for _ in range(n)]
visitedNormal = [[False] * n for _ in range(n)]
visitedRGB = [[False] * n for _ in range(n)]
dirs = [(-1,0),(1,0),(0,-1),(0,1)]


def bfsNormal(i,j,color):
    q = deque()
    q.append((i,j))
    visitedNormal[i][j] = True

    while q :
        r,c = q.popleft()
        for dr, dc in dirs:
            nr, nc = r + dr, c + dc
            if 0 > nr or n <= nr or 0 > nc or n <= nc :
                continue
            if grid[nr][nc] == color and not visitedNormal[nr][nc] :
                visitedNormal[nr][nc] = True
                q.append((nr,nc))

def bfsRGB(i,j,color):
    q = deque()
    q.append((i,j))
    visitedRGB[i][j] = True

    while q :
        r,c = q.popleft()
        for dr, dc in dirs:
            nr, nc = r + dr, c + dc
            if 0 > nr or n <= nr or 0 > nc or n <= nc :
                continue
            if color == 'R' or color == "G" :
                if (grid[nr][nc] == 'R' or grid[nr][nc] == 'G') and not visitedRGB[nr][nc] :
                    visitedRGB[nr][nc] = True
                    q.append((nr,nc))
            else :
                if grid[nr][nc] == color and not visitedRGB[nr][nc] :
                    visitedRGB[nr][nc] = True
                    q.append((nr,nc))

cntNormal = 0
cntRGB = 0

for i in range(n) :
    for j in range(n) :
        if not visitedNormal[i][j] :
            color = grid[i][j]
            cntNormal += 1
            bfsNormal(i,j,color)
        
        if not visitedRGB[i][j] :
            color = grid[i][j]
            cntRGB += 1
            bfsRGB(i,j,color)

print(cntNormal, cntRGB)