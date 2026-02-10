import sys
from collections import deque
input = sys.stdin.readline
tob = [None] + [deque(input().rstrip()) for _ in range(4)]
k = int(input())
for _ in range(k):
    num, d = map(int, input().split())
    rot = [0] * 5
    rot[num] = d
    
    for i in range(num-1, 0, -1):
        if tob[i][2] != tob[i+1][6]:
            rot[i] = -rot[i+1]
        else:
            break
    for i in range(num+1,5):
        if tob[i-1][2] != tob[i][6]:
            rot[i] = -rot[i-1]
        else:
            break
    for i in range(1,5):
        if rot[i] != 0:
            tob[i].rotate(rot[i])
ans = 0
for i in range(1,5):
    if tob[i][0] == '1':
        ans += 2 ** (i-1)
print(ans)