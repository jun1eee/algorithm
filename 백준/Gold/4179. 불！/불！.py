from collections import deque
R, C = map(int, input().split())
grid = [list(input().strip()) for _ in range(R)]
distF = [[-1] * C for _ in range(R)]
distJ = [[-1] * C for _ in range(R)]
dirs = [(-1,0),(1,0),(0,-1),(0,1)]

fireQ = deque()
jihunQ = deque()

for i in range(R) :
    for j in range(C) :
        if grid[i][j] == 'F':
            fireQ.append((i,j))
            distF[i][j] = 0
        elif grid[i][j] == 'J':
            jihunQ.append((i,j))
            distJ[i][j] = 0
def fireBFS() :
    while fireQ :
        r,c = fireQ.popleft()
        for dr, dc in dirs:
            nr, nc = r + dr, c + dc
            if 0 > nr or R <= nr or 0 > nc or C <= nc :
                continue
            if grid[nr][nc] == '#' or distF[nr][nc] != -1 :
                continue
            distF[nr][nc] = distF[r][c] + 1
            fireQ.append((nr,nc))

def jihunBFS() :
    while jihunQ :
        r,c = jihunQ.popleft()
        for dr, dc in dirs:
            nr, nc = r + dr, c + dc
            if 0 > nr or R <= nr or 0 > nc or C <= nc :
                return distJ[r][c] + 1
            if grid[nr][nc] == '#' or distJ[nr][nc] != -1 :
                continue
            if distF[nr][nc] != -1 and (distF[nr][nc] <= distJ[r][c] + 1) :
                continue
            distJ[nr][nc] = distJ[r][c] + 1
            jihunQ.append((nr,nc))
    return -1
fireBFS()
answer = jihunBFS()
print(answer) if answer != -1 else print("IMPOSSIBLE")