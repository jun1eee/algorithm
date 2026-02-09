n = int(input())
paper = [list(map(int,input().split())) for _ in range(n)]
white, blue = 0, 0

def solve(r,c,size):
    global white, blue
    first = paper[r][c]
    same = True
    for i in range(r, r+size):
        for j in range(c, c+size):
            if paper[i][j] != first:
                same = False
                break
        if not same:
            break
    if same:
        if first == 0:
            white += 1
        else:
            blue += 1
        return
    half = size // 2
    solve(r, c, half)
    solve(r, c+half, half)
    solve(r+half, c, half)
    solve(r+half, c+half, half)
solve(0,0,n)
print(white)
print(blue)