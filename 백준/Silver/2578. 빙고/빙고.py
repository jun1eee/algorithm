arr = [list(map(int,input().split())) for _ in range(5)]
visited = [[False] * 5 for _ in range(5)]
numbers = []
def check():
    cnt = 0
    for i in range(5):
        if visited[i] == [True] * 5:
           cnt += 1
    for j in range(5):
        if all(visited[i][j] for i in range(5)):
            cnt += 1
    if all(visited[i][i] for i in range(5)):
        cnt += 1
    if all(visited[i][4-i] for i in range(5)):
        cnt += 1
    return cnt  
for _ in range(5):
    tmp = list(map(int,input().split()))
    numbers.extend(tmp)

for cnt, n in enumerate(numbers, 1):
    for i in range(5):
        if n in arr[i]:
            visited[i][arr[i].index(n)] = True
    lines = 0
    if cnt >= 12:
        result = check()
        if result >= 3:
            print(cnt)
            break